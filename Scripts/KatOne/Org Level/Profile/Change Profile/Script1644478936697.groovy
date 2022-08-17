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


common.Login.loginSuccess(email, password)
WebUI.click(findTestObject('Object Repository/Page_KatOne/Profile/a_IconKO'))
//Get url after click icon Katalon
WebUI.waitForPageLoad(30)
urlResult = WebUI.getUrl()
println("Current url is": urlResult)
WebUI.verifyMatch(urlResult, "https://staging.katalon.com/", false)

//Verify url after click Katalon Studio on Product header menu
//WebUI.navigateToUrl(urlProfile)
//WebUI.mouseOver(findTestObject('Object Repository/Page_KatOne/Profile/Menu Heder/Products/div_Product'))
//WebUI.click(findTestObject('Object Repository/Page_KatOne/Profile/Menu Heder/Products/h6_Katalon Studio'), FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.waitForPageLoad(30)
//urlResult = WebUI.getUrl()
//println("Current url is": urlResult)
//WebUI.verifyMatch(urlResult, "https://staging.katalon.com/katalon-studio/", false)

//Verify url after click Katalon TestOps on Product header menu
//WebUI.navigateToUrl(urlProfile)
//WebUI.mouseOver(findTestObject('Object Repository/Page_KatOne/Profile/Menu Heder/Products/div_Product'))
//WebUI.click(findTestObject('Object Repository/Page_KatOne/Profile/Menu Heder/Products/h6_Katalon TestOps'), FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.waitForPageLoad(30)
//urlResult = WebUI.getUrl()
//println("Current url is": urlResult)
//WebUI.verifyMatch(urlResult, "https://staging.katalon.com/testops/", false)

//Verify url after click Katalon Recorder on Product header menu
//WebUI.navigateToUrl(urlProfile)
//WebUI.mouseOver(findTestObject('Object Repository/Page_KatOne/Profile/Menu Heder/Products/div_Product'))
//WebUI.click(findTestObject('Object Repository/Page_KatOne/Profile/Menu Heder/Products/h6_Katalon Recorder'), FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.waitForPageLoad(30)
//urlResult = WebUI.getUrl()
//println("Current url is": urlResult)
//WebUI.verifyMatch(urlResult, "https://staging.katalon.com/katalon-recorder-ide/", false)

//Verify url after click Web Testing on Product header menu
//WebUI.navigateToUrl(urlProfile)
//WebUI.mouseOver(findTestObject('Object Repository/Page_KatOne/Profile/Menu Heder/Products/div_Product'))
//WebUI.click(findTestObject('Object Repository/Page_KatOne/Profile/Menu Heder/Products/h6_Web Testing'), FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.waitForPageLoad(30)
//urlResult = WebUI.getUrl()
//println("Current url is": urlResult)
//WebUI.verifyMatch(urlResult, "https://staging.katalon.com/web-testing/", false)

//Verify url after click Mobile Testing on Product header menu
//WebUI.navigateToUrl(urlProfile)
//WebUI.mouseOver(findTestObject('Object Repository/Page_KatOne/Profile/Menu Heder/Products/div_Product'))
//WebUI.click(findTestObject('Object Repository/Page_KatOne/Profile/Menu Heder/Products/h6_Mobile Testing'), FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.waitForPageLoad(30)
//urlResult = WebUI.getUrl()
//println("Current url is": urlResult)
//WebUI.verifyMatch(urlResult, "https://staging.katalon.com/mobile-testing/", false)

//Verify url after click Integrations on Product header menu
//WebUI.navigateToUrl(urlProfile)
//WebUI.mouseOver(findTestObject('Object Repository/Page_KatOne/Profile/Menu Heder/Products/div_Product'))
//WebUI.click(findTestObject('Object Repository/Page_KatOne/Profile/Menu Heder/Products/h6_Integrations'), FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.waitForPageLoad(30)
//urlResult = WebUI.getUrl()
//println("Current url is": urlResult)
//WebUI.verifyMatch(urlResult, "https://staging.katalon.com/integrations/", false)

//Verify url after click API Testing on Product header menu
//WebUI.navigateToUrl(urlProfile)
//WebUI.mouseOver(findTestObject('Object Repository/Page_KatOne/Profile/Menu Heder/Products/div_Product'))
//WebUI.click(findTestObject('Object Repository/Page_KatOne/Profile/Menu Heder/Products/h6_API Testing'), FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.waitForPageLoad(30)
//urlResult = WebUI.getUrl()
//println("Current url is": urlResult)
//WebUI.verifyMatch(urlResult, "https://staging.katalon.com/api-testing/", false)

//Verify url after click Desktop Testing on Product header menu
//WebUI.navigateToUrl(urlProfile)
//WebUI.mouseOver(findTestObject('Object Repository/Page_KatOne/Profile/Menu Heder/Products/div_Product'))
//WebUI.click(findTestObject('Object Repository/Page_KatOne/Profile/Menu Heder/Products/h6_Desktop Testing'), FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.waitForPageLoad(30)
//urlResult = WebUI.getUrl()
//println("Current url is": urlResult)
//WebUI.verifyMatch(urlResult, "https://staging.katalon.com/desktop-testing/", false)

//Verify url after click Methodologies on Product header menu
//WebUI.navigateToUrl(urlProfile)
//WebUI.mouseOver(findTestObject('Object Repository/Page_KatOne/Profile/Menu Heder/Products/div_Product'))
//WebUI.click(findTestObject('Object Repository/Page_KatOne/Profile/Menu Heder/Products/h6_Methodologies'), FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.waitForPageLoad(30)
//urlResult = WebUI.getUrl()
//println("Current url is": urlResult)
//WebUI.verifyMatch(urlResult, "https://staging.katalon.com/methodologies/", false)

//Verify url after click Methodologies on Product header menu
//WebUI.navigateToUrl(urlProfile)
//WebUI.click(findTestObject('Page_KatOne/Profile/Start for free'))
//WebUI.waitForPageLoad(30)
//urlResult = WebUI.getUrl()
//println("Current url is": urlResult)
//WebUI.verifyMatch(urlResult, "https://staging.katalon.com/download/", false)

//Verify url after update name user successfully
//WebUI.navigateToUrl(urlProfile)
//name = "Thuy Truong"
//WebUI.setText(findTestObject('Object Repository/Page_KatOne/Profile/Basic Information/Name Input'), name)
//println("Current Name is": name)
//WebUI.click(findTestObject('Object Repository/Page_KatOne/Profile/Basic Information/Email'))
//message = WebUI.getText(findTestObject('Object Repository/Page_KatOne/Profile/Basic Information/Message/Update name successfully'), FailureHandling.CONTINUE_ON_FAILURE)
//println("Current message is": message)
//WebUI.verifyMatch(message, "Name has been updated.", false)

//Verify updated Job title successfully
//WebUI.navigateToUrl(urlProfile)
//WebUI.click(findTestObject('Page_KatOne/Profile/Basic Information/Job title Dropdown'))
////WebUI.delay(2)
//WebUI.click(findTestObject('Object Repository/Page_KatOne/Profile/Basic Information/JobTitle List'),FailureHandling.CONTINUE_ON_FAILURE)
//messageJobtitle = WebUI.getText(findTestObject('Object Repository/Page_KatOne/Profile/Basic Information/Message/Job title updated successfully'), FailureHandling.CONTINUE_ON_FAILURE)
//println("Current message is": messageJobtitle)
//WebUI.verifyMatch(messageJobtitle, "Job title has been updated.", false)

//Verify updated Product Interests successfully
//WebUI.click(findTestObject('Object Repository/Page_KatOne/Profile/checkbox_Katalon'))
//WebUI.click(findTestObject('Object Repository/Page_KatOne/Profile/checkbox_Katalon Studio Enterprise'))
//WebUI.click(findTestObject('Object Repository/Page_KatOne/Profile/checkbox_Katalon Recorder'))
//WebUI.click(findTestObject('Object Repository/Page_KatOne/Profile/checkbox_Katalium'))
//WebUI.click(findTestObject('Object Repository/Page_KatOne/Profile/checkbox_Katalon Runtime Engine'))
//WebUI.click(findTestObject('Object Repository/Page_KatOne/Profile/checkbox_Katalon TestOps'))

//Verify url after click Katalon Studio on Product bottom menu
//WebUI.navigateToUrl(urlProfile)
//WebUI.click(findTestObject('Page_KatOne/Profile/Products bottom menu/a_Katalon Studio'))
//WebUI.waitForPageLoad(30)
//urlResult = WebUI.getUrl()
//println("Current url is": urlResult)
//WebUI.verifyMatch(urlResult, "https://staging.katalon.com/katalon-studio/", false)

//Verify url after click Katalon TestOps on Product bottom menu
//WebUI.navigateToUrl(urlProfile)
//WebUI.click(findTestObject('Page_KatOne/Profile/Products bottom menu/a_Katalon TestOps'))
//WebUI.waitForPageLoad(30)
//urlResult = WebUI.getUrl()
//println("Current url is": urlResult)
//WebUI.verifyMatch(urlResult, "https://staging.katalon.com/testops/", false)

//Verify url after click Katalon Recorder on Product bottom menu
//WebUI.navigateToUrl(urlProfile)
//WebUI.click(findTestObject('Page_KatOne/Profile/Products bottom menu/a_Katalon Recorder'))
//WebUI.waitForPageLoad(30)
//urlResult = WebUI.getUrl()
//println("Current url is": urlResult)
//WebUI.verifyMatch(urlResult, "https://staging.katalon.com/katalon-recorder-ide/", false)

//Verify url after click Katalon Katalium on Product bottom menu
//WebUI.navigateToUrl(urlProfile)
//WebUI.click(findTestObject('Page_KatOne/Profile/Products bottom menu/a_Katalium'))
//WebUI.waitForPageLoad(30)
//urlResult = WebUI.getUrl()
//println("Current url is": urlResult)
//WebUI.verifyMatch(urlResult, "https://staging.katalon.com/", false)