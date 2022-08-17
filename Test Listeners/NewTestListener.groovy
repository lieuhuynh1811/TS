import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class NewTestListener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
//@BeforeTestCase
//	def beforeTestCase(TestCaseContext testCaseContext) {
//			
//		//‘Open browser’
//		WebUI.openBrowser(GlobalVariable.k1_url)
//		
//		//‘Maximize window’
//		WebUI.maximizeWindow()
//	}
	
	/**
	* Executes after every test case ends.
	* @param testCaseContext related information of the executed test case.
	*/
//	@AfterTestCase
//	def afterTestCase(TestCaseContext testCaseContext) {
//		
//		//‘Close browser’
//		WebUI.closeBrowser(FailureHandling.OPTIONAL)
//	}
	
//	@BeforeTestSuite
//	def login() {
//		WebUI.openBrowser(GlobalVariable.k1_url)
//		
//		WebUI.maximizeWindow()
//		
//		WebUI.sendKeys(findTestObject('Page_KatOne/Login/input_Email_email'), 'pgialinh.iuetv+1@gmail.com')
//		
//		WebUI.sendKeys(findTestObject('Page_KatOne/Login/input_Password_password'), 'Abcd@1234')
//		
//		WebUI.click(findTestObject('Page_KatOne/Login/button_Sign In'))
//		
//		WebUI.delay(2)
//	}
//	
//	@AfterTestSuite
//	def closeBrowser2() {
//		WebUI.closeBrowser()
//	}
	
}