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
import java.util.stream.Collectors

WebUI.openBrowser(GlobalVariable.k1_url)

WebUI.maximizeWindow()

WebUI.callTestCase(findTestCase('Common Test Cases/Login'), [('username') : 'pgialinh.iuetv+1@gmail.com', ('password') : GlobalVariable.owner_pass], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://my2.staging.katalon.com/payment-method?accountId=1926781')

WebUI.click(findTestObject('Object Repository/Page_Payment Method/button_Update'))

WebUI.sendKeys(findTestObject('Object Repository/Page_Payment Method/input_CC Email_ccEmail'), Keys.chord(Keys.CONTROL))
WebUI.sendKeys(findTestObject('Object Repository/Page_Payment Method/input_CC Email_ccEmail'), 'A')


/*
WebUI.setText(findTestObject('Object Repository/Page_Payment Method/input_CC Email_ccEmail'), '@')

WebUI.click(findTestObject('Object Repository/Page_Payment Method/button_Save billing information'))

WebUI.clearText(findTestObject('Object Repository/Page_Payment Method/input_CC Email_ccEmail'))

TestData td = findTestData('Invalid Emails')

List<String> emails = td.getAllData().stream()
.map{data -> data[0]}
.collect(Collectors.toList())

println(emails)

for (def n : emails) {
	WebUI.clearText(findTestObject('Object Repository/Page_Payment Method/input_CC Email_ccEmail'))
	
    WebUI.setText(findTestObject('Object Repository/Page_Payment Method/input_CC Email_ccEmail'), n)

    WebUI.delay(5)
}

*/


