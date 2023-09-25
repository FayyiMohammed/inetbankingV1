package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver Idriver;

	public AddCustomerPage(WebDriver rdriver) {
		Idriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomet;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender;

	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtdob;

	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtaddr;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtcity;

	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtstate;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtpinno;

	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtphno;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtemailid;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtpwd;

	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement clicksubmit;

	public void clickAddCustomer() {
		lnkAddNewCustomet.click();
	}

	public void custname(String name) {
		txtCustomerName.sendKeys(name);
	}

	public void dob(String mm, String dd, String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}

	public void adrs(String adr) {
		txtaddr.sendKeys(adr);
	}

	public void city(String city) {
		txtcity.sendKeys(city);
	}

	public void state(String st) {
		txtstate.sendKeys(st);
	}

	public void pinno(String pinno) {
		txtpinno.sendKeys(pinno);
	}

	public void pno(String pno) {
		txtphno.sendKeys(pno);
	}

	public void email(String mail) {
		txtemailid.sendKeys(mail);
	}

	public void password(String pwd) {
		txtpwd.sendKeys(pwd);
	}

	public void submit() {
		clicksubmit.click();
	}

}
