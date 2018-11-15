package com.crossover.e2e;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crossover.businessfunctions.GMailBusinessFunctions;

import junit.framework.TestCase;

public class GMailTest extends TestCase {

	private WebDriver driver;
	private Properties properties = new Properties();
	private String URL = null;
	private String username = null;
	private String password = null;
	private String mailSubject = "APPLYING FOR CROSSOVER QA ENGINEER";
	private String mailBody = "Thanks for considering me for this position";

	GMailBusinessFunctions gmailBusinessFunctions = new GMailBusinessFunctions();

	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		properties.load(new FileReader(new File("test.properties")));
		URL = properties.getProperty("url");
		username = properties.getProperty("username");
		password = properties.getProperty("password");
	}

	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testSendEmail() throws Exception {
		gmailBusinessFunctions.openURL(driver, URL);
		gmailBusinessFunctions.enterEmailAddress(driver, username);
		gmailBusinessFunctions.clickNextAfterEnteringEmail(driver);
		gmailBusinessFunctions.enterPassword(driver, password);
		gmailBusinessFunctions.clickNextAfterEnteringPassword(driver);
		gmailBusinessFunctions.composeEmailAndSend(driver, username, mailSubject, mailBody);
		gmailBusinessFunctions.clickEmail(driver);

		assertTrue("Verifying Email Subject", gmailBusinessFunctions.verifyEmailSubject(driver, mailSubject));
		assertTrue("Verifying Email Content", gmailBusinessFunctions.verifyEmailBody(driver, mailBody));
		assertTrue("Verifying Social Tag", gmailBusinessFunctions.verifySocialEmailTag(driver));
	}
}