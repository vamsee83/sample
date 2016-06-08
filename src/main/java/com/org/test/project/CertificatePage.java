package com.org.test.project;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * 
 * PageObject for certificatePage
 *
 */
public class CertificatePage {
	
	@FindBy(id = "cert_controls")
    private WebElement header;
	
	
	@FindBy(xpath = "//*[@id='dealerships']/li/div[2]/dl/dt")
    private WebElement contactname;
	
	@FindBy(xpath = "//*[@id='dealerships']/li/div[2]/dl/dd[2]")
	private WebElement contact_address;
	
	@FindBy(xpath = "//*[@id='dealerships']/li/div[2]/dl/dd[3]")
	private WebElement contact_address2;
	
	@FindBy(xpath = "//*[@id='dealerships']/li/div[2]/dl/dd[4]")
	private WebElement emailaddress;
	
	@FindBy(xpath = "//*[@id='dealerships']/li/div[2]/dl/dd[5]")
	private WebElement phonenumber;
	
	protected WebDriverWait wait;

	
	public void checkPage(){
		wait = new WebDriverWait(BaseTest.webDriver,60);
		wait.until(ExpectedConditions.titleContains("Certificate"));
	    Assert.assertTrue(header.isDisplayed(),"header is not displayed");
	}

	
	public void getDealerContact(){
		System.out.println("**********Dealer Contact************");
		BaseTest.webDriver.switchTo().frame("ucr_container");
		String contact_name = contactname.getText();
		System.out.println("contact name:"+contact_name);
		System.out.println("contact address: "+contact_address.getText());
		System.out.println("contact address: "+contact_address2.getText());
		System.out.println("email address: "+emailaddress.getText());
		System.out.println("phonenumber: "+phonenumber.getText());
		System.out.println("**********************");
	}

}
