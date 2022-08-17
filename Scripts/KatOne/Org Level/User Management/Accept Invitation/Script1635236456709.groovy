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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

CustomKeywords.'Common.login'(username, password)

String textBtn = WebUI.getText(findTestObject('Page_KatOne/User Management/Pending Invitation/btnJoinOrg'))

String orgName = textBtn.replace('Join ', '')

WebUI.click(findTestObject('Page_KatOne/User Management/Pending Invitation/btnJoinOrg'))

String msgText = WebUI.getText(findTestObject('Page_KatOne/User Management/toastMessage'))

String expectMsg = "You are now a member of $orgName"

WebUI.verifyEqual(msgText, expectMsg)

@com.kms.katalon.core.annotation.SetUp
def setup() {
    WebUI.openBrowser(url)

    WebUI.maximizeWindow()
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
    WebUI.closeBrowser()
}

