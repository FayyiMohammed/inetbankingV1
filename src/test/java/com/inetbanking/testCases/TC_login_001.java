package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_login_001 extends BaseClass {
	@Test

	public void logintest() throws IOException {
		driver.get(BaseUrl);

		logger.info("URL is opened");

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered UN");

		lp.setpassword(password);
		logger.info("Entered PW");
		lp.setlgnbtn();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login is Successfull ");

		} else {

			captureScreen(driver, "logintest");
			Assert.assertTrue(false);
			logger.info("Login is failed ");
		}

	}

}
