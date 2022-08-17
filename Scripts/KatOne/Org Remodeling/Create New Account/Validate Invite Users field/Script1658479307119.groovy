/**
 * KO-2095
 * */

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

List<String> emailList = DataHandler.getColumnValues('Invalid Emails', 0)

String emails = emailList.join(' ') + ' '

WebUI.click(findTestObject('Object Repository/Page_Welcome/svg_create'))

WebUI.sendKeys(findTestObject('Object Repository/Page_Welcome/Create New Account Dialog/input_invite emails'), emails)

WebUI.click(findTestObject('Page_Welcome/Create New Account Dialog/button_Create'))

WebUI.delay(2)

def actualErrorMsg = WebUI.getText(findTestObject('Object Repository/Page_Welcome/Create New Account Dialog/p_Invite email error message'))

def expectedMsg = "41 Invalid emails"

WebUI.takeFullPageScreenshotAsCheckpoint("invalid emails")

WebUI.verifyMatch(actualErrorMsg.trim(), expectedMsg.trim(), false)

//Verify can't input the account owner email

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Welcome/Create New Account Dialog/button_Clear All'))

WebUI.click(findTestObject('Object Repository/Page_Welcome/Create New Account Dialog/button_Clear All'))

WebUI.sendKeys(findTestObject('Object Repository/Page_Welcome/Create New Account Dialog/input_invite emails'), GlobalVariable.owner_mail+' ')

WebUI.takeFullPageScreenshotAsCheckpoint("invite owner email")

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Welcome/Create New Account Dialog/p_Invite email error message'))




@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser(GlobalVariable.k1_url)

	WebUI.maximizeWindow()

	WebUI.callTestCase(findTestCase('Common Test Cases/Login'), [('username') : GlobalVariable.owner_mail, ('password') : GlobalVariable.owner_pass],
		FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
		//WebUI.closeBrowser()
}


