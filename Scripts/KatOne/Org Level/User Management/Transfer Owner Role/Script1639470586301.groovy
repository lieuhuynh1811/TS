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
import org.openqa.selenium.WebElement as WebElement

WebElement emailRow = CustomKeywords.'page.UserManagementPage.getRowByEmail'(newOwnerEmail)

List<String> Columns_row = emailRow.findElements(By.tagName('td'))

String fullname = Columns_row.get(1).getText()

WebElement optionButton = Columns_row.get(Columns_row.size() - 1).findElement(By.tagName('button'))

optionButton.click()

WebUI.click(findTestObject('Page_KatOne/User Management/Transfer Owner Role/ul_transferRole'))

WebUI.sendKeys(findTestObject('Page_KatOne/User Management/Transfer Owner Role/input_password'), password)

WebUI.click(findTestObject('Page_KatOne/User Management/Transfer Owner Role/button_transfer'))

String msgText = WebUI.getText(findTestObject('Page_KatOne/User Management/toastMessage'), FailureHandling.OPTIONAL )
 
println msgText

String expectedMsg = 'Organization Owner rolehas been successfully transferred to '+fullname

WebUI.verifyEqual(msgText, expectedMsg, FailureHandling.CONTINUE_ON_FAILURE)

@com.kms.katalon.core.annotation.SetUp
def setup() {
//    WebUI.openBrowser('')
//
//    WebUI.maximizeWindow()

    WebUI.callTestCase(findTestCase('Common Test Cases/Go To User Management'), [('username') : username, ('password') : password
            , ('orgId') : orgId], FailureHandling.STOP_ON_FAILURE)
}

