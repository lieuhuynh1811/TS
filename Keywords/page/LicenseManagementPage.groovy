package page
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import utilities.TableHandler as TableHandler


class LicenseManagementPage {
	/**
	 * Verify if users exist in Licensed User with correct status
	 */
	@Keyword
	def verifyUserExistInLicesnedUser(List<String> emails, String status) {
		List<WebElement> rows_table = TableHandler.getHtmlTableRows(findTestObject("Page_KatOne/License Management/KSE perUser/table_License Users"))
		
		int count = 0
		
		println('#Verifying... ')
		
		for (int index : (0..emails.size() - 1)) {
			
			List<WebElement> Columns_row = rows_table.get(index).findElements(By.tagName('td'))
			
			String email = Columns_row.get(1).getText()
			String statusText = Columns_row.get(2).getText()
			
			if(emails.contains(email) && statusText.toLowerCase().equals(status.toLowerCase())) {
				count++
				println('#Verifyed... '+email + ' ' + statusText)
			}
		
		}
		println("#Result... ${count} counted")
		return count == emails.size();

	}
	}