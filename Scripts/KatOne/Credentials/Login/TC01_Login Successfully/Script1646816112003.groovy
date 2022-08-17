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

WebUI.callTestCase(findTestCase('Common Test Cases/Login'), [('username') : GlobalVariable.owner_mail, ('password') : GlobalVariable.owner_pass], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.k1_url+'profile')

WebUI.takeFullPageScreenshotAsCheckpoint("Homepage")

email = WebUI.getText(findTestObject('Page_KatOne/Profile/text_email'))

WebUI.verifyMatch(email, GlobalVariable.owner_mail, false)

@com.kms.katalon.core.annotation.SetUp
def setup() {

    WebUI.openBrowser(GlobalVariable.k1_url)

    WebUI.maximizeWindow()
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}