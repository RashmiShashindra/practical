package com.automation.utils;

import org.apache.log4j.Logger;
import org.testng.*;


/**
 * Created by ShiwanthaK on 3/25/2016.
 */
public class Listener  implements ITestListener, ISuiteListener{

    final static Logger logger = Logger.getLogger(Listener.class);

    public void onStart(ISuite iSuite) {

    }

    public void onFinish(ISuite iSuite) {

    }

    public void onTestStart(ITestResult iTestResult) {


    }

    public void onTestSuccess(ITestResult iTestResult) {
        if(iTestResult.SUCCESS == 1){logger.info("Execution Status : Pass");}
    }

    public void onTestFailure(ITestResult iTestResult) {
        if(iTestResult.FAILURE == 1){logger.info("Execution Status : Fail");}
    }

    public void onTestSkipped(ITestResult iTestResult) {
        if(iTestResult.SKIP == 1){logger.info("Execution Status : Skipped");}
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
        logger.info("Starting Execution for Test Case " + iTestContext.getName());
    }

    public void onFinish(ITestContext iTestContext) {
        logger.info("Finishing Execution for Test Case " + iTestContext.getName());
    }

}
