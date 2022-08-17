import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import utilities.DataHandler as DataHandler

WebUI.callTestCase(findTestCase('Common Test Cases/Go To User Management'), [('username') : username, ('password') : password
	, ('orgId') : orgId], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_KatOne/User Management/button_Invite Users'))

List<String> emailList = DataHandler.getColumnValues(fileName, 0)
	
String emails = emailList.join(' ') + ' '

WebUI.sendKeys(findTestObject('Page_KatOne/User Management/Invite Dialog/input_Email Invite'), emails)

WebUI.click(findTestObject('Page_KatOne/User Management/Invite Dialog/button_Next'))

if (licenses.size() > 0) {
    CustomKeywords.'page.UserManagementPage.selectLicense'(licenses)
}

WebUI.click(findTestObject('Page_KatOne/User Management/Invite Dialog/button_Confirm'))

CustomKeywords.'page.UserManagementPage.verifyEmailExistInTableWithSearch'(emailList)


