 /**
 * KO-1883
 * **/ import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
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
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

WebUI.click(findTestObject('Object Repository/Page_Welcome/svg_create'))

WebUI.sendKeys(findTestObject('Page_Welcome/Create New Account Dialog/input_Account Name'), accountName)

WebUI.sendKeys(findTestObject('Page_Welcome/Create New Account Dialog/input_Org Name'), orgName)

WebUI.sendKeys(findTestObject('Object Repository/Page_Welcome/Create New Account Dialog/input_invite emails'), emails.join(
        ' ') + ' ')

WebUI.click(findTestObject('Page_Welcome/Create New Account Dialog/button_Create'))

WebUI.waitForElementVisible(findTestObject('Page_Account Home/h6_account name'), 0)

//WebUI.delay(5)

def currentUrl = WebUI.getUrl()

def accountId = currentUrl.split('=').getAt(1)

println(accountId)

WebUI.closeBrowser()

for(def email : emails) {
	
	WebUI.openBrowser(GlobalVariable.k1_url)

	WebUI.callTestCase(findTestCase('Common Test Cases/Login'), [('username') : email, ('password') : GlobalVariable.owner_pass], 
    FailureHandling.STOP_ON_FAILURE)

	WebUI.verifyElementVisible(findTestObject('Page_Welcome/span_accountId', [('id') : accountId]))
	
	WebUI.delay(2)

	WebUI.closeBrowser()
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
}

