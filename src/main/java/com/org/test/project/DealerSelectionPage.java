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
 * PageObject for dealer selectionPage
 *
 */
public class DealerSelectionPage {
	
	@FindBy(id = "reg_form")
    private WebElement header;
	
	@FindBy(id = "maap_cta_btn")
    private WebElement nextButton;
	
	protected WebDriverWait wait;

	
	public void checkPage(){
		wait = new WebDriverWait(BaseTest.webDriver,60);
		wait.until(ExpectedConditions.titleContains("Dealer Selection"));
	    Assert.assertTrue(header.isDisplayed(),"header is not displayed");
	}

	
	public void clickNext(){
		nextButton.click();
	}

}
