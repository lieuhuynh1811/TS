package emailVerification

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;
import javax.mail.Address
import javax.mail.internet.MimeMultipart;
import org.jsoup.Jsoup

import com.kms.katalon.core.annotation.Keyword


/*
 * from https://stackoverflow.com/questions/36707939/how-to-extract-a-registration-url-from-a-mail-content
 * Author(s): B_L
 * Created: 01/30/2019
 * 
 * Last Modified by: B_L
 * Last Modified: 01/30/2019
 * 
 * 
 * Purpose: Grab verify link from email
 * 
 */
public class FetchEmailVarLink {

	private static ResultMail check(String host, String storeType, String user,
			String password, String subject, String flag) {
		try {
			String emailLink = ''
			String recipientMail = ''
			//create properties field
			Properties properties = new Properties();

			properties.put("mail.imap.host",host);
			properties.put("mail.imap.port", "993");
			properties.put("mail.imap.starttls.enable", "true");
			properties.setProperty("mail.imap.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			properties.setProperty("mail.imap.socketFactory.fallback", "false");
			properties.setProperty("mail.imap.socketFactory.port",String.valueOf(993));
			Session emailSession = Session.getDefaultInstance(properties);

			//create the imap store object and connect with the pop server
			Store store = emailSession.getStore("imap");

			store.connect(host, user, password);

			//create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			MimeMessage[] messages = emailFolder.getMessages();
			//System.out.println("messages.length---" + messages.length);
			int n=messages.length;
			String desc = ''

			//change n- to number of emails you want to dig through
			for (int i = n-1; i >= n-5; --i) {
				MimeMessage message = messages[i];
				ArrayList<String> links = new ArrayList<String>();

				System.out.println("Subject: " + message.getSubject());


				if(message.getSubject().contains(subject)){
					MimeMultipart messageBody = message.getContent();

					String abc = messageBody.getBodyPart(0).getContent().toString();

					desc = messageBody.getBodyPart(1).getContent().toString();

					System.out.println("Description: " + desc);

					Pattern linkPattern = Pattern.compile("href=\"(.*?)\"",  Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
					Matcher pageMatcher = linkPattern.matcher(desc);
					while(pageMatcher.find()){
						links.add(pageMatcher.group(1));
					}

					for(String temp:links){
						if(temp.contains(flag)){
							emailLink = temp;
							//System.out.println(temp);
						}
					}

					Address[] recipients =  message.getAllRecipients()
					recipientMail = recipients[0].toString().split("<")[1].replaceAll(">","")

					break;
				}else{
					System.out.println("Email:"+ i + " is not a wanted email");
				}
			}

			ResultMail result = new ResultMail(emailLink, recipientMail)

			return result;

			//close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Keyword
	public static String getEmailLinkFromEmail(String mode, String receiver=""){
		String host = "imap.gmail.com";
		String mailStoreType = "imap";
		String username = "pgialinh.iuetv@gmail.com";
		String password = "Gaara1912003";
		String subject = '';
		String flag = '';

		switch (mode) {
			case "Acivate":
				subject = "Verify Your Katalon Account";
				flag = "activation_code"
				break
			default:
				subject = "Katalon Password Reset"
				flag = "reset_password_code"
				break;
		}

		ResultMail result = check(host, mailStoreType, username, password, subject, flag );

		if(receiver) {
			if(receiver.equals(result.recipient)) {
				return result.link;
			}
			return "";
		}

		return result.link;
	}



}

public class ResultMail{
	String link;
	String recipient;
	public ResultMail(String link, String mail) {
		this.link = link
		this.recipient = mail
	}
}