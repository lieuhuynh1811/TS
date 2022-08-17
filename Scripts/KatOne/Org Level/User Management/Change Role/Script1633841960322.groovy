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
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

//CustomKeywords.'utilities.TableHandler.selectRowsInTable'(findTestObject('Page_KatOne/User Management/table'), 2, emailList)
CustomKeywords.'page.UserManagementPage.selectEmailInTable'(2, emailList)

WebUI.click(findTestObject('Object Repository/Page_KatOne/User Management/Active Users/button_Change Role'))

WebUI.verifyElementNotClickable(findTestObject('Page_KatOne/User Management/Active Users/Dialog/btnConfirm'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_KatOne/User Management/Active Users/Dialog/dropdown_role'))

def roleIndex = CustomKeywords.'page.UserManagementPage.getIndexRole'(role)

WebUI.click(findTestObject('Page_KatOne/User Management/Active Users/Dialog/li_RoleOption', [('index') : roleIndex]))

WebUI.verifyElementClickable(findTestObject('Page_KatOne/User Management/Active Users/Dialog/btnConfirm'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.click(findTestObject('Page_KatOne/User Management/Active Users/Dialog/iconX_EmailTag', [('index') : 2]))

WebUI.click(findTestObject('Page_KatOne/User Management/Active Users/Dialog/btnConfirm'))

String msgText = WebUI.getText(findTestObject('Page_KatOne/User Management/toastMessage'), FailureHandling.CONTINUE_ON_FAILURE)

if ((msgText != null) && (msgText.length() > 0)) {
    total = emailList.size()

    String expectedMsg = total == 1 ? '1 member' : "$total members" + " successfully added as $role."

    WebUI.verifyEqual(msgText, expectedMsg, FailureHandling.CONTINUE_ON_FAILURE)
}

//CustomKeywords.'page.UserManagementPage.verifyEmailExistInTable'(2, emailList)
println(emailList)

CustomKeywords.'page.UserManagementPage.verifyChangeRole'(emailList, role)

@com.kms.katalon.core.annotation.SetUp
def setup() {
    WebUI.openBrowser('')

    WebUI.maximizeWindow()

    WebUI.callTestCase(findTestCase('Common Test Cases/Go To User Management'), [('username') : username, ('password') : password
            , ('orgId') : orgId], FailureHandling.STOP_ON_FAILURE)
}

/*
 * Role Index:
 * 1: Admin
 * 2: Billing Manager
 * 3. Member
 * */ 