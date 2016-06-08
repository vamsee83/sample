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
 * PageObject for MakeSelectionPage
 *
 */
public class MakeSelectionPage {
	
	@FindBy(xpath = "//*[@id='homepage']/div[1]/div[3]/h1")
    private WebElement welcomeMessage;
	
    private WebElement make_model;
    
    @FindBy(id = "home_select_make")
    private WebElement makeDropdown;
    
    protected WebDriverWait wait;
    
    @FindBy(xpath = "//*[@id='s2id_home_select_model']/a")
    private WebElement modeldropdown;
    
    @FindBy(xpath = "//*[@id='select2-drop']/div/input")
    private WebElement modelSearch;
    
    @FindBy(xpath = "//*[@id='select2-drop']/ul/li/ul/li")
    private WebElement selectFirstSearch;
    
    @FindBy(id = "home_zip")
    private WebElement zipInput;
    
    @FindBy(id = "home_cta")
    private WebElement goButton;

	
	public void checkPage(){
		String message = welcomeMessage.getText();
		Assert.assertEquals("Welcome to the AutoBlog Smart Buy Program", message, "Welcome message not present in the page.");
	    Assert.assertTrue(make_model.isDisplayed(),"Make and Model is not displayed");
	}
	
	public void selectMake(String make){
		Select dropdown = new Select(makeDropdown);
		dropdown.selectByVisibleText(make);
	}
	
	public void selectModel(String model){
		modeldropdown.click();
		wait = new WebDriverWait(BaseTest.webDriver,60);
		wait.until(ExpectedConditions.visibilityOf(modelSearch));
		modelSearch.sendKeys(model);
		wait.until(ExpectedConditions.visibilityOf(selectFirstSearch));
		selectFirstSearch.click();
	}
	
	public void enterZip(String zip){
		zipInput.clear();
		zipInput.sendKeys(zip);
	}
	
	public void clickGO(){
		goButton.click();
	}

}
