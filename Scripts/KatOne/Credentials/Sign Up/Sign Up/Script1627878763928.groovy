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
import emailVerification.FetchEmailVarLink as FetchEmailVarLink

WebUI.click(findTestObject('Page_KatOne/Login/a_Sign Up'))

WebUI.callTestCase(findTestCase('Common Test Cases/Sign Up'), [('password') : password, ('email') : email, ('fullname') : fullname], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

switch (expected_case) {
    case GlobalVariable.INVALID_EMAIL:
        error = handleError()

        WebUI.verifyMatch(error, GlobalVariable.INVALID_EMAIL_MSG, false)

        break
    case GlobalVariable.INVALID_NAME:
        error = handleError()

        WebUI.verifyMatch(error, GlobalVariable.INVALID_NAME_MSG, false)

        break
    case GlobalVariable.WRONG_PASS:
        error = handleError()

        WebUI.verifyMatch(error, GlobalVariable.WRONG_PASS_MSG, false)

        break
    case GlobalVariable.DUPPLICATE_EMAIL:
        error = handleError()

        WebUI.verifyMatch(error, GlobalVariable.DUPPLICATE_EMAIL_MSG, false)

        break
    default:
        handleError()
		
		WebUI.delay(10);

//        WebUI.verifyMatch(WebUI.getUrl(), 'https://staging.katalon.com/sign-up-survey/', false)

        String emailLink = FetchEmailVarLink.getEmailLinkFromEmail('Acivate', email)

        println(emailLink)
		
		WebUI.verifyNotEqual(emailLink, "")

        WebUI.navigateToUrl(emailLink)

        WebUI.delay(5)

        WebUI.callTestCase(findTestCase('KatOne/Credentials/Login/Login All Cases In One'), [('username') : email, ('password') : password, ('expected_case') : '', ('is_open_browser'): false],
			 FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('null'), [('username') : email, ('password') : password, ('is_open_browser'): false], 
			FailureHandling.STOP_ON_FAILURE)

        break
}


@com.kms.katalon.core.annotation.SetUp
def setup() {
    WebUI.openBrowser(GlobalVariable.k1_url)

    WebUI.maximizeWindow()
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
    WebUI.closeBrowser()
}

def handleError() {
    if (WebUI.verifyElementNotPresent(findTestObject('Page_KatOne/Sign up/error_msg'), 5, FailureHandling.OPTIONAL)) {
		return
    }
    
    String error = WebUI.getText(findTestObject('Page_KatOne/Sign up/error_msg'))

    if (!(error.equals('Invalid captcha'))) {
        return error
    }
    
    handleCaptcha();
	
	if(expected_case.equals(GlobalVariable.SUCCESS)) return
	
	return handleError();

}

def handleCaptcha() {
	String className = WebUI.getAttribute(findTestObject('Page_KatOne/Sign up/captcha_checkmark'), 'class')
	
	println(className)
		
	sum = 0
		
	while (!className.contains("recaptcha-checkbox-checked") && sum <= timeout) {
		WebUI.delay(10)
		sum+=10
		className = WebUI.getAttribute(findTestObject('Page_KatOne/Sign up/captcha_checkmark'), 'class')
	}
		
	WebUI.click(findTestObject('Page_KatOne/Sign up/btn_SignUp'))
		
	WebUI.delay(10)
}

