package com.inetbanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String username, String pwd) throws InterruptedException {

		System.setProperty("org.freemarker.loggerLibrary", "none");
		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);
		logger.info("user name provided");
		lp.setpassword(pwd);
		logger.info("pw  provided");
		lp.setlgnbtn();
		Thread.sleep(1000);
		if (isAlerPresent() == true) {
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		} else {
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clicklogout();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();// close log out alert
			driver.switchTo().defaultContent();

		}

	}

	public boolean isAlerPresent() {// user defined method created to check alert

		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {

			return false;
		}
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {

		logger.info("XL started here");
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");

		int colnum = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colnum];

		for (int i = 1; i <= rownum; i++) {

			for (int j = 0; j < colnum; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1 , 0
			}
		}

		return logindata;

	}

}
