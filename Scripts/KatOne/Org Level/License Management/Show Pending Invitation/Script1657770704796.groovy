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

WebUI.callTestCase(findTestCase('Common Test Cases/Go To User Management'), [('username') : GlobalVariable.owner_mail
        , ('password') : GlobalVariable.owner_pass, ('orgId') : orgId], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_KatOne/User Management/button_Invite Users'))

WebUI.sendKeys(findTestObject('Page_KatOne/User Management/Invite Dialog/input_Email Invite'), emails.join(' '))

WebUI.click(findTestObject('Page_KatOne/User Management/Invite Dialog/button_Next'))

CustomKeywords.'page.UserManagementPage.selectLicense'([GlobalVariable.KSE_PER_USER])

WebUI.click(findTestObject('Page_KatOne/User Management/Invite Dialog/button_Confirm'))

WebUI.click(findTestObject('Menu/a_License Management item'))

String a = WebUI.getText(findTestObject('Page_KatOne/License Management/KSE perUser/table_License Users'))

println(a)

WebUI.verifyEqual(CustomKeywords.'page.LicenseManagementPage.verifyUserExistInLicesnedUser'(emails, 'Pending'), true)

@com.kms.katalon.core.annotation.SetUp
def setup() {

	WebUI.openBrowser(GlobalVariable.k1_url)

	WebUI.maximizeWindow()
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {

	WebUI.closeBrowser()
}
