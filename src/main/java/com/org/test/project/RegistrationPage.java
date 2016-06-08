package com.org.test.project;


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
 * PageObject for RegistrationPage
 *
 */
public class RegistrationPage {
	
	@FindBy(id = "reg_vehicle_top")
    private WebElement header;
	
    private WebElement given_name;
	
    private WebElement family_name;
    
    private WebElement street_address;
    
    protected WebDriverWait wait;
    
    private WebElement city;
    
    private WebElement state;
    
    private WebElement postal_code;
    
    private WebElement phone_number;
    
    private WebElement email_address;
    
    @FindBy(xpath = "//*[@id='contact_fields']/button")
    private WebElement viewDealerPricing;

	
	public void checkPage(){
		wait = new WebDriverWait(BaseTest.webDriver,60);
		wait.until(ExpectedConditions.titleContains("Registration"));
	    Assert.assertTrue(header.isDisplayed(),"header is not displayed");
	}
	
	public void enterContactInfo(String givenname,String familyname, String streetaddress, String phonenumber, String emailadress){
		given_name.sendKeys(givenname);
		family_name.sendKeys(familyname);
		street_address.sendKeys(streetaddress);
		phone_number.sendKeys(phonenumber);
		email_address.sendKeys(emailadress);
		
	}
	
	public void clickDealerPricing(){
		viewDealerPricing.click();
	}

}
