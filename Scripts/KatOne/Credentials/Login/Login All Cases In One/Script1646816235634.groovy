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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.delay(3)

CustomKeywords.'Common.login'(username, password)

WebUI.delay(3)
WebDriver driver = DriverFactory.getWebDriver()

url = GlobalVariable.k1_url

switch (expected_case) {
    case GlobalVariable.EMPTY_CASE:
    case GlobalVariable.EMPTY_EMAIL:
        AlertText = driver.findElement(By.name('email')).getAttribute('validationMessage')

        WebUI.verifyMatch(GlobalVariable.EMPTY_MSG, AlertText, false)

        break
    case GlobalVariable.EMPTY_PASS:
        AlertText = driver.findElement(By.name('password')).getAttribute('validationMessage')

        WebUI.verifyMatch(GlobalVariable.EMPTY_MSG, AlertText, false)

        break
    case GlobalVariable.WRONG_EMAIL:
        String AlertText = driver.findElement(By.name('email')).getAttribute('validationMessage')

        println(AlertText)

        errorMsg1 = "Please include an '@' in the email address. '$username' is missing an '@'."

        errorMsg2 = "Please enter a part followed by '@'. '$username' is incomplete."

        WebUI.verifyEqual(AlertText.equals(errorMsg1.toString()) || AlertText.equals(errorMsg2.toString()), true)

        break
    case GlobalVariable.FAILED:
        AlertText = WebUI.getText(findTestObject('Page_KatOne/Login/span_Incorrect email or password. Please try again'))

        WebUI.verifyMatch(GlobalVariable.WRONG_CREDENTIALS_MSG, AlertText, false)

        WebUI.verifyMatch(WebUI.getText(findTestObject('Page_KatOne/Login/Unauthorized')), 'Unauthorized', false)

        break
    default:
        email = WebUI.getText(findTestObject('Page_KatOne/Profile/text_email'))

        WebUI.verifyMatch(email, username, false)

        WebUI.verifyMatch(WebUI.getUrl(), url + 'profile', false)

        break
}



//@com.kms.katalon.core.annotation.SetUp
//def setup() {
//    if (!(is_open_browser)) {
//        WebUI.navigateToUrl(GlobalVariable.k1_url)
//
//        return 
//    }
//    
//    WebUI.openBrowser(GlobalVariable.k1_url)
//
//    WebUI.maximizeWindow()
//}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
    if (!(is_open_browser)) {
		return
		}
    
    WebUI.closeBrowser()
}

