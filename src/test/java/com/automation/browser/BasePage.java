package com.automation.browser;


import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.*;




public class BasePage {

    final static Logger logger = Logger.getLogger(BasePage.class);

    public static WebDriver driver = null;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public static WebDriver getConnection(String browser) throws InterruptedException {
        if (browser.equals("chrome")) {
            String exePath = "C:\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", exePath);
            driver = new ChromeDriver();
        } else if (browser.equals("ie")) {
            String service = "C:\\IEDriverServer.exe";
            System.setProperty("webdriver.ie.driver", service);
            driver = new InternetExplorerDriver();
        } else {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//        driver.get("http://10.101.15.21:8080/ui-training-app/");
        driver.get("http://toolsqa.com/iframe-practice-page/");
//        Assert.assertEquals("Directory Listing For /", driver.getTitle());
        Assert.assertEquals("TOOLSQA | IFrame practice page", driver.getTitle());
        logger.info("*************** Test Started ********************");
        return driver;
    }

    public static void closeConnection(){
        driver.close();
        driver.quit();
        logger.info("*************** Test Completed ********************");
    }

}
