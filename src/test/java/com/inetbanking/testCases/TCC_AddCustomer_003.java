package com.inetbanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TCC_AddCustomer_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("user name given");
		lp.setpassword(password);
		logger.info("password given");
		lp.setlgnbtn();

		Thread.sleep(1000);

		AddCustomerPage cp = new AddCustomerPage(driver);
		cp.clickAddCustomer();

		logger.info("providing customer details");
		cp.custname("fayaz");
		cp.dob("10", "08", "1992");
		Thread.sleep(3000);
		cp.adrs("india");
		cp.city("karimnagar");
		cp.state("ts");
		cp.pno("9676516562");
		cp.pinno("505001");

		String mail = randomString() + "@gmail.com";
		cp.email(mail);
		cp.password("password");
		cp.submit();
		Thread.sleep(3000);
		logger.info("validation started...");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed");

		} else {
			logger.info("test case failed");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);

		}
	}

}