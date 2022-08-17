/*KO-2049*/
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

WebUI.click(findTestObject('Object Repository/Page_Welcome/svg_arrow_1st account'))

WebUI.click(findTestObject('Object Repository/Page_Account Home/Featured Documentation/a_Products and Licenses'))

def link = WebUI.getUrl()

WebUI.verifyMatch(link, "https://docs.katalon.com/docs/products-and-licenses/katalon-studio-enterprise-and-runtime-engine-licenses/license-overview", false)

WebUI.back()

WebUI.click(findTestObject('Object Repository/Page_Account Home/Featured Documentation/a_Katalon Studio Overview'))

link = WebUI.getUrl()

WebUI.verifyMatch(link, "https://docs.katalon.com/docs/katalon-studio-enterprise/katalon-studio-overview", false)

WebUI.back()

WebUI.click(findTestObject('Object Repository/Page_Account Home/Featured Documentation/a_Katalon Runtime Engine Introduction'))

link = WebUI.getUrl()

WebUI.verifyMatch(link, "https://docs.katalon.com/docs/katalon-runtime-engine/introduction-to-runtime-engine", false)

WebUI.back()

WebUI.click(findTestObject('Object Repository/Page_Account Home/Featured Documentation/a_Katalon TestOps Overview'))

link = WebUI.getUrl()

WebUI.verifyMatch(link, "https://docs.katalon.com/docs/katalon-testops/overview/testops-overview", false)

WebUI.back()

WebUI.click(findTestObject('Object Repository/Page_Account Home/Featured Documentation/a_Katalon TestCloud Overview'))

link = WebUI.getUrl()

WebUI.verifyMatch(link, "https://docs.katalon.com/docs/katalon-testcloud/testcloud-overview", false)

WebUI.back()

WebUI.click(findTestObject('Object Repository/Page_Account Home/Featured Documentation/a_Katalon Recorder Overview')) 

link = WebUI.getUrl()

WebUI.verifyMatch(link, "https://docs.katalon.com/docs/katalon-recorder/get-started/overview", false)


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

