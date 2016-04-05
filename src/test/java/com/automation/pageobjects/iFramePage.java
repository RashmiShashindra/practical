package com.automation.pageobjects;

import com.automation.browser.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Created by RashmiM on 4/5/2016.
 */

public class iFramePage extends BasePage{

    final static Logger logger = Logger.getLogger(iFramePage.class);

    @FindBy(xpath = "html/body/div[1]/div[2]/div/div/div[1]/h1")
    WebElement lbliFrameHeader;

    @FindBy(xpath = "html/body/div[1]/div[3]/div[2]/div/div/form/fieldset/div[2]/input[1]")
    WebElement rdoBtnMale;

    @FindBy(xpath = "html/body/div[1]/div[3]/div[2]/div/div/form/fieldset/div[2]/input[2]")
    WebElement getRdoBtnFemale;

    public iFramePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        logger.info("Initialize Page");
        Reporter.log("Initialize Page");
    }

    public iFramePage verify_iFrame_Practice_Page_Header(String header) throws InterruptedException {
        Assert.assertEquals(lbliFrameHeader.getText(),header);
        logger.info("Validated iFrame site header...");
        return this;
    }

    public iFramePage select_1st_IFrame (){
        driver.switchTo().frame("IF1");
        return this;
    }

    public iFramePage click_Male_Radio_Button() throws InterruptedException {
//        rdoBtnMale.click();
//        logger.info("Clicked Male Radio Button...");
//        Thread.sleep(2000);
        WebElement iframeElement = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div/div/form/fieldset/div[2]/input[1]\""));

        //now use the switch command
        driver.switchTo().frame(iframeElement);
        Thread.sleep(2000);
        return this;
    }

}
