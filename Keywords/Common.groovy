import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.annotation.Keyword

public class Common {

	@Keyword
	def login(String username, String password) {

		WebUI.sendKeys(findTestObject('Page_KatOne/Login/input_Email_email'), username)

		WebUI.sendKeys(findTestObject('Page_KatOne/Login/input_Password_password'), password)

		WebUI.click(findTestObject('Page_KatOne/Login/button_Sign In'))
	}
}
