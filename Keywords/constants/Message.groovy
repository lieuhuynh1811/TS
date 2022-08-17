package constants

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public final class Message {
	public static final Empty_CurrentPassword_ErrorMsg = "Please fill in CURRENT PASSWORD"
	public static final Empty_NewPassword_ErrorMsg = "Please fill in NEW PASSWORD"
	public static final Empty_ConfirmPassword_ErrorMsg = "Please fill in CONFIRM PASSWORD"
	public static final Incorrect_CurrentPassword_ErrorMsg = "Incorrect password."
	public static final DonotMatch_ConfirmPassword_ErrorMsg = "Passwords do not match"
	public static final WrongRules_ErrorMsg = "Password must be a minimum of 8 characters, maximum of 255 characters, contain at least 1 upper case, 1 lower case, 1 special character, 1 number and must not start or end with a space"
	public static final CP001_ErrorMsg = "Please enter no more than 255 characters"
	public static final CP002_ErrorMsg = "Minimum is 8 characters"
}
