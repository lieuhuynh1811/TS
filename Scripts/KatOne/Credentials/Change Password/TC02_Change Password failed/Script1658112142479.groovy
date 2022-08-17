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

import constants.Message


WebUI.callTestCase(findTestCase('Common Test Cases/Login'), [('username') : var_username, ('password') : var_password, ('statusExpectedResult'): var_statusExpectedResult], FailureHandling.STOP_ON_FAILURE)
//Check expected data
println("Email is ${var_username}")
println("Email is ${var_password}")

switch(var_statusExpectedResult.toString())
{
	case 'FAILED_ETP':
	
		WebUI.callTestCase(findTestCase('Common Test Cases/Change Pass'), [('var_currentpassword') : var_currentpassword, ('var_newpassword') : var_newpassword
	        , ('var_confirmpassword') : var_confirmpassword, ('statusExpectedResult') : var_statusExpectedResult], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.delay(2)
		
		String getCurrentPasswordError = WebUI.getText(findTestObject('Object Repository/Page_KatOne/ChangePassword/Message change password/Message Change Password popup/div_Please fill in CURRENT PASSWORD'), 
		    FailureHandling.CONTINUE_ON_FAILURE)
		
		String getNewPasswordError = WebUI.getText(findTestObject('Object Repository/Page_KatOne/ChangePassword/Message change password/Message Change Password popup/div_Please fill in NEW PASSWORD'), 
		    FailureHandling.CONTINUE_ON_FAILURE)
		
		String getConfirmPasswordError = WebUI.getText(findTestObject('Object Repository/Page_KatOne/ChangePassword/Message change password/Message Change Password popup/div_Please fill in CONFIRM PASSWORD'), 
		    FailureHandling.CONTINUE_ON_FAILURE)
		
		WebUI.verifyMatch(Message.Empty_CurrentPassword_ErrorMsg, getCurrentPasswordError, false)
		
		WebUI.verifyMatch(Message.Empty_NewPassword_ErrorMsg, getNewPasswordError, false)
		
		WebUI.verifyMatch(Message.Empty_ConfirmPassword_ErrorMsg, getConfirmPasswordError, false)
		
	break
		
	case 'FAILED_ECP':
	
		WebUI.callTestCase(findTestCase('Common Test Cases/Change Pass'), [('var_currentpassword') : var_currentpassword, ('var_newpassword') : var_newpassword
			, ('var_confirmpassword') : var_confirmpassword, ('statusExpectedResult') : var_statusExpectedResult], FailureHandling.STOP_ON_FAILURE)	
		
		WebUI.delay(2)

		String getCurrentPasswordError = WebUI.getText(findTestObject('Object Repository/Page_KatOne/ChangePassword/Message change password/Message Change Password popup/div_Please fill in CURRENT PASSWORD'), 
		    FailureHandling.CONTINUE_ON_FAILURE)
		
		println("Error current pasword field is ${getCurrentPasswordError}")
		
		WebUI.verifyMatch(Message.Empty_CurrentPassword_ErrorMsg, getCurrentPasswordError, false)
		
	break

	case 'FAILED_ENP':
		
		WebUI.callTestCase(findTestCase('Common Test Cases/Change Pass'), [('var_currentpassword') : var_currentpassword, ('var_newpassword') : var_newpassword
				, ('var_confirmpassword') : var_confirmpassword, ('statusExpectedResult') : var_statusExpectedResult], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.delay(2)

		String getNewPasswordError = WebUI.getText(findTestObject('Object Repository/Page_KatOne/ChangePassword/Message change password/Message Change Password popup/div_Please fill in NEW PASSWORD'), 
		    FailureHandling.CONTINUE_ON_FAILURE)
		
		println("Error new pasword field is ${getNewPasswordError}")
		
		WebUI.verifyMatch(Message.Empty_NewPassword_ErrorMsg, getNewPasswordError, false)
		
	break
		
	
	case 'FAILED_ECO':
	
		WebUI.callTestCase(findTestCase('Common Test Cases/Change Pass'), [('var_currentpassword') : var_currentpassword, ('var_newpassword') : var_newpassword
			, ('var_confirmpassword') : var_confirmpassword, ('statusExpectedResult') : var_statusExpectedResult], FailureHandling.STOP_ON_FAILURE)
	
		WebUI.delay(2)
		
		String getConfirmPasswordError = WebUI.getText(findTestObject('Object Repository/Page_KatOne/ChangePassword/Message change password/Message Change Password popup/div_Please fill in CONFIRM PASSWORD'), 
			FailureHandling.CONTINUE_ON_FAILURE)

		println("Error confirm pasword field is ${getConfirmPasswordError}")
		
		WebUI.verifyMatch(Message.Empty_ConfirmPassword_ErrorMsg, getConfirmPasswordError, false)
		
	break
		
	case 'FAILED_ICP':
	
		WebUI.callTestCase(findTestCase('Common Test Cases/Change Pass'), [('var_currentpassword') : var_currentpassword, ('var_newpassword') : var_newpassword
			, ('var_confirmpassword') : var_confirmpassword, ('statusExpectedResult') : var_statusExpectedResult], FailureHandling.STOP_ON_FAILURE)
	
		WebUI.delay(2)
		
		String getError = WebUI.getText(findTestObject('Object Repository/Page_KatOne/ChangePassword/Message change password/Message Change Password popup/div_Incorrect password'), 
	    FailureHandling.CONTINUE_ON_FAILURE)

		println("Error field is ${getError}")
		
		WebUI.verifyMatch(Message.Incorrect_CurrentPassword_ErrorMsg, getError, false)
		
	break
		
	case 'FAILED_DNM':
	
		WebUI.callTestCase(findTestCase('Common Test Cases/Change Pass'), [('var_currentpassword') : var_currentpassword, ('var_newpassword') : var_newpassword
			, ('var_confirmpassword') : var_confirmpassword, ('statusExpectedResult') : var_statusExpectedResult], FailureHandling.STOP_ON_FAILURE)
	
		WebUI.delay(2)
		
		String getError = WebUI.getText(findTestObject('Object Repository/Page_KatOne/ChangePassword/Message change password/Message Change Password popup/div_Passwords do not match'), 
		    FailureHandling.CONTINUE_ON_FAILURE)
		
		println("Error field is ${getError}")
		
		WebUI.verifyMatch(Message.DonotMatch_ConfirmPassword_ErrorMsg, getError, false)
		
	break
		
	case 'FAILED_PMB':
	
		WebUI.callTestCase(findTestCase('Common Test Cases/Change Pass'), [('var_currentpassword') : var_currentpassword, ('var_newpassword') : var_newpassword
			, ('var_confirmpassword') : var_confirmpassword, ('statusExpectedResult') : var_statusExpectedResult], FailureHandling.STOP_ON_FAILURE)
	
		WebUI.delay(2)
		
		String getError = WebUI.getText(findTestObject('Object Repository/Page_KatOne/ChangePassword/Message change password/Message Change Password popup/div_Password Input Rules'), FailureHandling.CONTINUE_ON_FAILURE)
		
		println("Error field is ${getError}")
		
		WebUI.verifyMatch(Message.WrongRules_ErrorMsg, getError, false)
		
	break

	case 'FAILED_NMM':
	
		WebUI.callTestCase(findTestCase('Common Test Cases/Change Pass'), [('var_currentpassword') : var_currentpassword, ('var_newpassword') : var_newpassword
		        , ('var_confirmpassword') : var_confirmpassword, ('statusExpectedResult') : var_statusExpectedResult], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.delay(2)
		
		String getError = WebUI.getText(findTestObject('Object Repository/Page_KatOne/ChangePassword/Message change password/Message Change Password popup/div_Please enter no more than 255 characters'), 
		    FailureHandling.CONTINUE_ON_FAILURE)
		
		println("Error field is $getError")
		
		WebUI.verifyMatch(Message.CP001_ErrorMsg, getError, false)
		
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
				