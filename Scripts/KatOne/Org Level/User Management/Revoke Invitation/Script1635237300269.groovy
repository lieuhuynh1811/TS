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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.util.stream.Collectors as Collectors

TestData td = findTestData(fileName)

List<String> emailList = td.getAllData().stream().map({ def data ->
        data[0]
    }).collect(Collectors.toList())

CustomKeywords.'utilities.TableHandler.selectRowsInTable'(findTestObject('Page_KatOne/User Management/table'), 2, emails)

WebUI.click(findTestObject('Page_KatOne/User Management/Pending Invitation/btnRevoke'))

WebUI.click(findTestObject('Page_KatOne/User Management/Pending Invitation/btnConfirm'))

WebUI.delay(3)

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser(GlobalVariable.k1_url)
	
	WebUI.maximizeWindow()

    WebUI.callTestCase(findTestCase('Common Test Cases/Go To User Management'), [('username') : username, ('password') : password
            , ('orgId') : orgId, ('tab'): 2], FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {

	WebUI.closeBrowser()
}

