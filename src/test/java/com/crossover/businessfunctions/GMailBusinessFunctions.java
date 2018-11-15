package com.crossover.businessfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.crossover.common.GMailCommonActions;
import com.crossover.pageobjects.GMailPageObjects;

public class GMailBusinessFunctions {

	GMailCommonActions commonActions = new GMailCommonActions();

	public void openURL(WebDriver driver, String url) {
		commonActions.openURL(driver, url);
	}

	public void enterEmailAddress(WebDriver driver, String email) {
		commonActions.sendKeys(driver, By.id(GMailPageObjects.UserName_TextBox), email);
	}

	public void clickNextAfterEnteringEmail(WebDriver driver) {
		commonActions.click(driver, By.id(GMailPageObjects.UserName_Next));
	}

	public void enterPassword(WebDriver driver, String password) {
		commonActions.sendKeys(driver, By.name(GMailPageObjects.Password_TextBox), password);
	}

	public void clickNextAfterEnteringPassword(WebDriver driver) {
		commonActions.click(driver, By.id(GMailPageObjects.Password_Next));
	}

	public void composeEmailAndSend(WebDriver driver, String to, String subject, String body) {
		commonActions.click(driver, By.xpath(GMailPageObjects.Compose_Button));
		commonActions.sendKeys(driver, By.name(GMailPageObjects.Mail_TO), String.format("%s@gmail.com", to));
		commonActions.sendKeys(driver, By.name(GMailPageObjects.Mail_TO), Keys.ENTER);
		commonActions.sendKeys(driver, By.name(GMailPageObjects.Mail_Subject), subject);
		commonActions.buildActions(driver, By.xpath(GMailPageObjects.Mail_Body), body);
		commonActions.click(driver, By.xpath(GMailPageObjects.More_Options));
		commonActions.click(driver, By.xpath(GMailPageObjects.Label_Selector));
		commonActions.sendKeys(driver, By.xpath(GMailPageObjects.Enter_Label), "Social");
		commonActions.sendKeys(driver, By.xpath(GMailPageObjects.Enter_Label), Keys.ENTER);
		commonActions.click(driver, By.xpath(GMailPageObjects.Mail_Send));
		commonActions.click(driver, By.xpath(GMailPageObjects.Gmail_Inbox));
		commonActions.click(driver, By.xpath(GMailPageObjects.Mail_Refresh));
	}

	public void clickEmail(WebDriver driver) {
		commonActions.click(driver, By.xpath(GMailPageObjects.Starred_Email));
		commonActions.click(driver, By.name(GMailPageObjects.Click_Email));
	}

	public boolean verifySocialEmailTag(WebDriver driver) {
		if (commonActions.checkElementIsDisplayed(driver, By.name(GMailPageObjects.Smart_Social_Label)))
			return true;
		else
			return false;
	}

	public boolean verifyEmailSubject(WebDriver driver, String subject) {
		if (commonActions.checkElementIsDisplayed(driver,
				By.xpath(GMailPageObjects.Check_Mail_Subject.replaceAll("replacethissubject", subject))))
			return true;
		else
			return false;
	}

	public boolean verifyEmailBody(WebDriver driver, String body) {
		if (commonActions.checkElementContainsText(driver, By.xpath(GMailPageObjects.Mail_Body), body))
			return true;
		else
			return false;
	}
}