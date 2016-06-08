package com.org.test.project;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

/**
 * Base Test for all functions common to all testcases.
 *
 */
public class BaseTest 
{
	public static WebDriver webDriver;
	enum Type {
        firefox, chrome, ie, safari, htmlunit, phantomjs
    }
   
	@BeforeSuite(alwaysRun = true)
	@Parameters({"url", "browser"})
	public void setupBeforeSuite(String url, String browser) {
		File basedir = new File(System.getProperty("basedir", "."));
        File dir = new File(basedir, ".external-resources");
        String exeName = "chromedriver-windows-32bit.exe";
        if (OS.isFamilyMac()) {
            exeName = "chromedriver-mac-32bit";
        } else if (OS.isFamilyUnix()) {
            exeName = "chromedriver-linux-64bit";
        }
       File path=  new File(dir, "webdrivers/" + exeName);
      
       switch (BaseTest.Type.valueOf(browser)) {

       case chrome:
           System.setProperty("webdriver.chrome.driver", path.getAbsolutePath());
           webDriver = new ChromeDriver();
           break;
       case firefox:
           webDriver = new FirefoxDriver();
           break;
       case htmlunit:
           webDriver = new HtmlUnitDriver(true);
           break;
       case ie:
           System.setProperty("webdriver.ie.driver", path.getAbsolutePath());
           webDriver = new InternetExplorerDriver();
           break;
       case phantomjs:
           // webDriver = new PhantomJSDriver();
           break;
       default:
           throw new RuntimeException("Unsupported browser under test:");

       }
       //implict time
       webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       String currentUrl = webDriver.getCurrentUrl();
       if(!currentUrl.equalsIgnoreCase(url)){
    	   webDriver.get(url);
       }
	}
	
	@AfterSuite
	public void cleanup(){
		webDriver.close();
	}
	
	
	
}
