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


WebElement Table = driver.findElement(By.xpath(xPathTable))

// Get all rows
List<WebElement> rows_table = Table.findElements(By.tagName('tr'))

int rows_count = rows_table.size()

println("#Row "+rows_count)

for (int index : (0..rows_count-1)) {
	
	println("=Row "+index)
	
	List<WebElement> Columns_row = rows_table.get(index).findElements(By.tagName('td'))
	
	int columns_count = Columns_row.size()
	
	for (def col : (0..columns_count-1)) {
		println("#Col ${col}: ${Columns_row.get(col).getText()}")
	}
	
	String pending_email = Columns_row.get(2).getText();
	
	if(email_list.contains(pending_email)) {
	
		Columns_row.get(0).findElement(By.tagName('input')).click()
		
	}
	
}