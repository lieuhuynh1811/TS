package page
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.stream.Collectors

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import utilities.TableHandler as TableHandler

public class UserManagementPage {
	@Keyword
	def goToTab(String orgId, int tabNumber = 1) {
		String type = 'active-users';

		switch (tabNumber) {
			case 2:
				type = 'pending-invitations'
				break;
			case 3:
				type = 'removed-users'
				break;
			default:
				break
		}

		String url = (GlobalVariable.k1_url + "user-management/$type?orgId=") + orgId

		WebUI.navigateToUrl(url)
	}

	@Keyword
	def getIndexRole(String role) {
		switch (role) {
			case GlobalVariable.ADMIN:
				return 1
			case GlobalVariable.BILLING_MANAGER:
				return 2
			case GlobalVariable.MEMBER:
				return 3
			default:
				break
		}
	}

	@Keyword
	def selectLicense(List<String> licenses) {
		for (String s : licenses) {
			WebUI.click(findTestObject('Page_KatOne/User Management/Invite Dialog/option_License', ['value': s]))
		}
	}

	def verifyChangeRoleOnePage(List<String> emailList, String role ) {
		List<WebElement> rows_table =  TableHandler.getHtmlTableRows(findTestObject('Page_KatOne/User Management/table'))

		int rows_count = rows_table.size()

		int changed = 0

		println('#Verifying... ')

		for (int index : (0..rows_count - 1)) {

			List<WebElement> Columns_row = rows_table.get(index).findElements(By.tagName('td'))

			String email = Columns_row.get(2).getText()

			String userRole = Columns_row.get(4).getText()

			if (emailList.contains(email) && role.equals(userRole)) {

				changed++
				emailList.remove(emailList.indexOf(email))

				println(email + " is "+userRole)
			}
		}

		println(changed + " verified users ")
		return emailList
	}

	@Keyword
	def selectEmailInTable( List<String> emailList) {

		for(String email : emailList) {
			WebUI.sendKeys(findTestObject('Page_KatOne/User Management/input_Search'), email)
			WebElement row = getRowByEmail(email)
			if(row != null) {
				row.findElement(By.tagName('input')).click()
			}
			WebUI.clearText(findTestObject('Page_KatOne/User Management/input_Search'))
		}
	}

	@Keyword
	def verifyEmailExistInTableWithPagination(int emailColumnIndex, List<String> emailList) {
		List<String> unVerifiedEmails = emailList.stream().collect(Collectors.toList());
		List<WebElement> pages = WebUI.findWebElements(findTestObject('Page_KatOne/User Management/pagination'), 10)
		int totalPageElement = pages.size()

		if( totalPageElement - 2 == 1) {
			TableHandler.verifyTextsInTable(findTestObject('Page_KatOne/User Management/table'), emailColumnIndex, unVerifiedEmails)
		}else {
			WebElement firstButton = pages.get(1)
			WebElement nextButton = pages.get(totalPageElement-1)

			firstButton.click()

			for (int index = 1; index <= totalPageElement - 2; index++) {
				TableHandler.verifyTextsInTable(findTestObject('Page_KatOne/User Management/table'), emailColumnIndex, unVerifiedEmails)
				if(unVerifiedEmails.size() == 0) break
					nextButton.click()
			}
		}

		WebUI.verifyEqual(unVerifiedEmails.size(), 0)
	}

	@Keyword
	def verifyEmailExistInTableWithSearch(List<String> emailList) {
		int verifiedEmail = 0;

		println('Verifying... ')

		for(String email : emailList) {
			WebUI.sendKeys(findTestObject('Page_KatOne/User Management/input_Search'), email)
			// Check no result
			WebElement row = getRowByEmail(email)
			if(row != null) {
				verifiedEmail++
			}
			WebUI.clearText(findTestObject('Page_KatOne/User Management/input_Search'))
		}

		println(verifiedEmail + " verified users ")
		WebUI.verifyEqual(emailList.size(), verifiedEmail)
	}

	@Keyword
	def verifyChangeRole(List<String> emailList, String role) {
		List<String> unVerifiedEmails = emailList.stream().collect(Collectors.toList());
		List<WebElement> pages = WebUI.findWebElements(findTestObject('Page_KatOne/User Management/pagination'), 10)
		int totalPageElement = pages.size()

		if( totalPageElement - 2 == 1) {
			verifyChangeRoleOnePage(unVerifiedEmails, role)
		}else {
			WebElement firstButton = pages.get(1)
			WebElement nextButton = pages.get(totalPageElement-1)

			firstButton.click()

			for (int index = 1; index <= totalPageElement - 2; index++) {
				verifyChangeRoleOnePage(unVerifiedEmails, role)
				if(unVerifiedEmails.size() == 0) break
					nextButton.click()
			}
		}

		WebUI.verifyEqual(unVerifiedEmails.size(), 0)
	}

	@Keyword
	def verifyChangeRoleWithSearch(List<String> emailList, String role) {
		int verifiedRole = 0;

		println('Verifying... ')

		for(String email : emailList) {
			WebUI.sendKeys(findTestObject('Page_KatOne/User Management/input_Search'), email)
			WebElement row = getRowByEmail(email)

			if(row != null) {
				String roleText = row.findElements(By.tagName('td')).get(4).getText()
				verifiedRole = roleText.equals(role) ? ++verifiedRole : verifiedRole
			}
			WebUI.clearText(findTestObject('Page_KatOne/User Management/input_Search'))
		}

		println(verifiedRole + " verified roles ")
		WebUI.verifyEqual(emailList.size(), verifiedRole)
	}

	@Keyword
	def getRowByEmail(String email) {
		WebElement emailRow = TableHandler.getRowByColumnIndex(findTestObject('Page_KatOne/User Management/table'), 2, email)
		return emailRow;
	}
}
