/**
 * KO-1879 & KO-1880
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

WebUI.click(findTestObject('Object Repository/Page_Welcome/svg_create'))

WebUI.sendKeys(findTestObject('Page_Welcome/Create New Account Dialog/input_Account Name'), invalidName)

WebUI.sendKeys(findTestObject('Page_Welcome/Create New Account Dialog/input_Org Name'), invalidName)

WebUI.click(findTestObject('Page_Welcome/Create New Account Dialog/button_Create'))


def actualErrorMessage1 = WebUI.getText(findTestObject('Object Repository/Page_Welcome/Create New Account Dialog/p_Account error message'))

def actualErrorMessage2 = WebUI.getText(findTestObject('Object Repository/Page_Welcome/Create New Account Dialog/p_Org error message'))

def emptyErrorMessage = "You must fill in the required field to proceed."

def errorMessageOnlyLetterAndNumber = "You can only enter letters and numbers."

if(invalidName.equals('')) {
	WebUI.verifyMatch(actualErrorMessage1, emptyErrorMessage, false)	
	WebUI.verifyMatch(actualErrorMessage2, emptyErrorMessage, false)
}else {
	WebUI.verifyMatch(actualErrorMessage1, errorMessageOnlyLetterAndNumber, false)
	WebUI.verifyMatch(actualErrorMessage2, errorMessageOnlyLetterAndNumber, false)
}


@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser(GlobalVariable.k1_url)

	WebUI.maximizeWindow()

	WebUI.callTestCase(findTestCase('Common Test Cases/Login'), [('username') : GlobalVariable.owner_mail, ('password') : GlobalVariable.owner_pass],
		FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
		WebUI.closeBrowser()
}


