package com.org.test.project;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AutoBlogTest extends BaseTest {
	
	
	/**
	 * This method will enter the car info and check the price
	 * @param make
	 * @param model
	 * @param zip
	 * @param completeName
	 * @param state_zip
	 */
	@Test
	@Parameters({"make","model","zip","completeName","state_zip"})
	public void welcomePageToReportPage(String make, String model, String zip, String completeName, String state_zip){
		MakeSelectionPage welcomepage = PageFactory.initElements(BaseTest.webDriver, MakeSelectionPage.class);
		welcomepage.checkPage();
		welcomepage.selectMake(make);
		welcomepage.selectModel(model);
		welcomepage.enterZip(zip);
		welcomepage.clickGO();
		PriceReportPage reportPage = PageFactory.initElements(BaseTest.webDriver, PriceReportPage.class);
		reportPage.checkPage();
		reportPage.checkHeader(completeName);
		reportPage.checkZip(state_zip);
	}
	
	/**
	 * This method will select style and register for dealer info and print out dealer contact
	 * @param style
	 * @param first_name
	 * @param last_Name
	 * @param street
	 * @param phone
	 * @param email
	 */
	@Test
	@Parameters({"style","firstName","lastName","street","phone","email"})
	public void reportPageToDealerPage(String style, String first_name, String last_Name, String street, String phone, String email){
		PriceReportPage reportPage = PageFactory.initElements(BaseTest.webDriver, PriceReportPage.class);
		reportPage.selectStyle(style);
		reportPage.clickDealerPricing();
		RegistrationPage regPage = PageFactory.initElements(BaseTest.webDriver, RegistrationPage.class);
		regPage.checkPage();
		regPage.enterContactInfo(first_name, last_Name, street, phone, email);
		regPage.clickDealerPricing();
		DealerSelectionPage dealerPage = PageFactory.initElements(BaseTest.webDriver, DealerSelectionPage.class);
		dealerPage.checkPage();
		dealerPage.clickNext();
		CertificatePage cerPage = PageFactory.initElements(BaseTest.webDriver, CertificatePage.class);
		cerPage.checkPage();
		cerPage.getDealerContact();
	}

}
