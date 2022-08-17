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


WebUI.navigateToUrl(GlobalVariable.Admin_url + 'organization/'+orgId+'/admin/payment-method?')

// Add new 
WebUI.sendKeys(findTestObject('Page_KatOne/Payment Method/input_Card Number'), cardNumber)

WebUI.sendKeys(findTestObject('Page_KatOne/Payment Method/input_exp date'), expDate)

WebUI.sendKeys(findTestObject('Page_KatOne/Payment Method/input_cvc'), cvc)

WebUI.sendKeys(findTestObject('Page_KatOne/Payment Method/input_card holder'), cardHolder)

WebUI.click(findTestObject('Page_KatOne/Payment Method/button_add new card'))

//Add billing info
WebUI.click(findTestObject('Page_KatOne/Payment Method/button_update_billing info'))

WebUI.clearText(findTestObject('Page_KatOne/Payment Method/input_address1'))

WebUI.sendKeys(findTestObject('Page_KatOne/Payment Method/input_address1'), address1)

WebUI.clearText(findTestObject('Page_KatOne/Payment Method/input_city'))

WebUI.sendKeys(findTestObject('Page_KatOne/Payment Method/input_city'), city)

WebUI.clearText(findTestObject('Page_KatOne/Payment Method/input_state'))

WebUI.sendKeys(findTestObject('Page_KatOne/Payment Method/input_state'), state)

WebUI.sendKeys(findTestObject('Page_KatOne/Payment Method/select_country'), country)

WebUI.sendKeys(findTestObject('Page_KatOne/Payment Method/select_country'), Keys.chord(Keys.ENTER))

WebUI.clearText(findTestObject('Page_KatOne/Payment Method/input_postal code'))

WebUI.sendKeys(findTestObject('Page_KatOne/Payment Method/input_postal code'), postalCode)

WebUI.clearText(findTestObject('Page_KatOne/Payment Method/input_business name'))

WebUI.sendKeys(findTestObject('Page_KatOne/Payment Method/input_business name'), businessName)

WebUI.click(findTestObject('Page_KatOne/Payment Method/button_save billing info'))


