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
 * PageObject for Price Report Page
 *
 */
public class PriceReportPage {
	
	@FindBy(id = "config-header")
    private WebElement header;
	
	@FindBy(xpath = "//*[@id='config-header']/h1")
    private WebElement headerText;
	
	@FindBy(xpath = "//*[@id='update_zip']/div[1]/strong")
    private WebElement zip;
    
	@FindBy(xpath = "//*[@id='s2id_select_style']/a")
    private WebElement select_style;
    
    protected WebDriverWait wait;
    
    @FindBy(xpath = "//*[@id='price-summary']/div[2]/a")
    private WebElement dealerPricing;
    
    @FindBy(xpath = "//*[@id='select2-drop']/div/input")
    private WebElement searchStyle;
    
    @FindBy(xpath = "//*[@id='select2-drop']/ul/li")
    private WebElement selectFirstSearch;

	
	public void checkPage(){
		wait = new WebDriverWait(BaseTest.webDriver,60);
		wait.until(ExpectedConditions.titleContains("Price Report"));
	    Assert.assertTrue(header.isDisplayed(),"header is not displayed");
	}
	
	public void checkHeader(String selection){
		String text = headerText.getText();
		Assert.assertEquals(selection, text, "Make and model didn't match");
	}
	
	public void checkZip(String zipcode){
		String text = zip.getText();
		Assert.assertEquals(zipcode, text, "Zip didn't match");
	}
	
	public void selectStyle(String style){
		select_style.click();
		wait = new WebDriverWait(BaseTest.webDriver,60);
		wait.until(ExpectedConditions.visibilityOf(searchStyle));
		searchStyle.sendKeys(style);
		wait.until(ExpectedConditions.visibilityOf(selectFirstSearch));
		selectFirstSearch.click();
		
	}
	
	public void clickDealerPricing(){
	   dealerPricing.click();
	}

}
