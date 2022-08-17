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

WebUI.callTestCase(findTestCase('Common Test Cases/Create New Org'), [('orgName') : orgName], FailureHandling.STOP_ON_FAILURE)

String url = WebUI.getUrl()

String orgId = url.substring(url.length() - 6)

WebUI.callTestCase(findTestCase('Common Test Cases/Add Payment Method'), [('cardNumber') : '4242424242424242', ('expDate') : '1125'
        , ('cvc') : '123', ('cardHolder') : 'Linh', ('address1') : 'Dien Bien Phu', ('city') : 'Ho Chi Minh', ('state') : 'state'
        , ('country') : 'viet', ('businessName') : 'Katalon', ('postalCode') : '7000', ('orgId') : orgId], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.navigateToUrl(GlobalVariable.k1_url + 'home')

WebUI.click(findTestObject('Page_KatOne/Home/button_setting icon'))

WebUI.click(findTestObject('Menu/a_Subscription Management item'))

WebUI.click(findTestObject('Page_KatOne/Home/a_TestCloud subscription'))

WebUI.click(findTestObject('Page_Admin/Menu/button_Subscribe'))

WebUI.waitForPageLoad(3)

WebUI.sendKeys(findTestObject('Page_KatOne/Subscription Management/TestCloud/TC Purchasing/input_No of session'), '10')

WebUI.delay(1)

WebUI.scrollToElement(findTestObject('Page_KatOne/Subscription Management/TestCloud/TC Purchasing/button_Check out'), 5)

WebUI.verifyElementClickable(findTestObject('Page_KatOne/Subscription Management/TestCloud/TC Purchasing/button_Check out'))

WebUI.click(findTestObject('Page_KatOne/Subscription Management/TestCloud/TC Purchasing/button_Check out'))

WebUI.waitForPageLoad(3)

WebUI.verifyElementVisible(findTestObject('Page_KatOne/Subscription Management/TestCloud/Payment Success/h2_Thank you for the purchase'), 
    FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.SetUp
def setup() {
    WebUI.callTestCase(findTestCase('Common Test Cases/Login'), [('username') : 'pgialinh.iuetv+3@gmail.com', ('password') : GlobalVariable.owner_pass], 
        FailureHandling.STOP_ON_FAILURE)
}

