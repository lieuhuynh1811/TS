package utilities
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.SelectorMethod

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import java.util.stream.Collectors as Collectors

class TableHandler {

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	public static def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName = "") {

		WebElement tableElement = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = tableElement.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}

	/**
	 * Select some rows in HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	public static int selectRowsInTable(TestObject table, int targetIndex, List<String> compareList, String outerTagName = "") {
		KeywordUtil.logInfo("Get all rows")

		List<WebElement> rows_table = getHtmlTableRows(table, outerTagName)

		int rows_count = rows_table.size()

		int selected = 0

		println('#Row ' + rows_count)

		for (int index : (0..rows_count - 1)) {
			println('=Row ' + index)

			List<WebElement> Columns_row = rows_table.get(index).findElements(By.tagName('td'))

			//printDataCell(Columns_row)

			String targetText = Columns_row.get(targetIndex).getText()

			if (compareList.contains(targetText)) {

				TestObject e = findTestObject('Page_KatOne/User Management/tr', ['index' : index + 1])

				WebUiBuiltInKeywords.scrollToElement(e, 10)

				Columns_row.get(0).findElement(By.tagName('input')).click()

				selected++
			}
		}
		return selected
	}

	@Keyword
	public static boolean verifyTextsInTable(TestObject table, int targetIndex, List<String> textList, String outerTagName = "") {
		List<WebElement> rows_table =  getHtmlTableRows(table, outerTagName)

		int rows_count = rows_table.size()

		int counted = 0

		println('Verifying... ')

		for (int index : (0..rows_count - 1)) {

			List<WebElement> Columns_row = rows_table.get(index).findElements(By.tagName('td'))

			String email = Columns_row.get(targetIndex).getText()

			if (textList.contains(email)) {

				counted++

				println(email)

				//textList.remove(textList.indexOf(email))
			}
		}

		println(counted + " texts verified")

		return counted == textList.size();
	}

	@Keyword
	public static List<String> getColumnValues(TestObject table, int columnIndex){
		List<WebElement> rows_table =  getHtmlTableRows(table, "")

		int rows_count = rows_table.size()

		List<String> result = getHtmlTableRows(table, "").stream().map({ def data ->
			data.findElements(By.tagName('td')).get(columnIndex).getText()
		}).collect(Collectors.toList())

		return result;

	}


	public static WebElement getRowByColumnIndex(TestObject table, int columnIndex, String textCompared){
		List<WebElement> rows_table =  getHtmlTableRows(table)

		int rows_count = rows_table.size()

		for (int index : (0..rows_count - 1)) {

			List<WebElement> Columns_row = rows_table.get(index).findElements(By.tagName('td'))

			String textData = Columns_row.get(columnIndex).getText()

			if(textData.equals(textCompared))
				return rows_table.get(index)
		}
	}

	def printDataCell(List<WebElement> Columns_row) {
		int columns_count = Columns_row.size()
		for (def col : (0..columns_count - 1)) {
			String colText = Columns_row.get(col).getText()
			println("#Col $col: $colText")
		}
	}

}