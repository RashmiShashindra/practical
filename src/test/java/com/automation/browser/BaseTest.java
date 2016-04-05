package com.automation.browser;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by ShiwanthaK on 3/18/2016.
 */
public class BaseTest {

    final static Logger logger = Logger.getLogger(BaseTest.class);

    private WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void initialized() throws InterruptedException {
        this.driver = BasePage.getConnection("chrome");
    }

    @AfterMethod(alwaysRun = true)
    public void terminated() {
        BasePage.closeConnection();
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            System.out.println("Screenshot Capturing");
            FileUtils.copyFile(scrFile, new File("E:\\my-automation\\Automation_Screenshots\\"+testResult.getName()+".jpg"));
            System.out.println("Saving Screenshot");
        }

    }

}
