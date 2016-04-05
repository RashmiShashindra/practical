package com.automation.pageobjects;

import com.automation.browser.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

/**
 * Created by RashmiM on 4/4/2016.
 */
public class AlertsPage extends BasePage {

    final static Logger logger = Logger.getLogger(LoginPage.class);

    @FindBy(xpath = "html/body/table/tbody/tr[12]/td[1]/a/tt")
    WebElement lnkAlerts;

    @FindBy(xpath = "html/body/h1")
    WebElement lblAlertsPageHeader;

    @FindBy(xpath = "html/body/p[1]/a")
    WebElement lnkAlertsPopUp;


    public AlertsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        logger.info("Initialize Page");
        Reporter.log("Initialize Page");
    }


    public AlertsPage click_On_Alerts_Link () throws InterruptedException {
        lnkAlerts.click();
        logger.info("Clicked Alerts Link succesfully...");
        return this;
    }

    public AlertsPage verify_Alerts_Link_Navigation(String alertsPageName){
        Assert.assertEquals(lblAlertsPageHeader.getText(), alertsPageName);
        logger.info("Verified Alerts Page header successfully...");
        return this;
    }

    public AlertsPage click_Alerts_Pop_Up_Link(){
        lnkAlertsPopUp.click();
        logger.info("Clicked Alerets Pop Up Link Successfully...");
        return this;
    }

    public AlertsPage verify_Alerts_Pop_Up() throws InterruptedException {
        Alert simpleAlert = driver.switchTo().alert();
        String alertText = simpleAlert.getText();
        logger.info("Alert text is " + alertText);
        Thread.sleep(5000);
        simpleAlert.accept();
        return this;
    }



}
