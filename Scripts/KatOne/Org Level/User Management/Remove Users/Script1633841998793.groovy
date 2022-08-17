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

List<String> emailList = DataHandler.getColumnValues(fileName, 0)

CustomKeywords.'page.UserManagementPage.selectEmailInTable'(2, emailList)

WebUI.click(findTestObject('Page_KatOne/User Management/Active Users/button_Remove Users'))

WebUI.click(findTestObject('Page_KatOne/User Management/Active Users/Dialog/btnConfirm'))

WebUI.waitForElementClickable(findTestObject('Page_KatOne/User Management/btn_close_toastMessage'), 30)

String msgText = WebUI.getText(findTestObject('Page_KatOne/User Management/toastMessage'))

total = emailList.size()

String expectedMsg = (total == 1 ? '1 member' : "$total members") + ' successfully removed'

WebUI.verifyEqual(msgText, expectedMsg, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Page_KatOne/User Management/a_userTab', [('index') : '3']))

CustomKeywords.'page.UserManagementPage.verifyEmailExistInTable'(1, emailList)

@com.kms.katalon.core.annotation.SetUp
def setup() {
    WebUI.openBrowser('')

    WebUI.maximizeWindow()

    WebUI.callTestCase(findTestCase('Common Test Cases/Go To User Management'), [('username') : username, ('password') : password
            , ('orgId') : orgId], FailureHandling.STOP_ON_FAILURE)
}

