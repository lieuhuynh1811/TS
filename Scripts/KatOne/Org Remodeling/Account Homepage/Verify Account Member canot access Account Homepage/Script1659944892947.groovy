/*KO-2046*/
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

WebUI.click(findTestObject('Page_Welcome/a_account id link', [('accountId') : '279006']))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_403/a_Go to Organization'), 5)

WebUI.verifyEqual(WebUI.getUrl(), 'https://my2.staging.katalon.com/forbidden') 

@com.kms.katalon.core.annotation.SetUp
def setup() {
    WebUI.openBrowser(GlobalVariable.k1_url)

    WebUI.maximizeWindow()

    WebUI.callTestCase(findTestCase('Common Test Cases/Login'), [('username') : 'truongbaothuy93+71@gmail.com', ('password') : 'KzXoJXJYxul3D9DRe4bCdA=='], 
        FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}

