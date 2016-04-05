package com.automation.testcases;

import com.automation.browser.BaseTest;
import com.automation.pageobjects.AlertsPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by RashmiM on 4/4/2016.
 */

@Listeners(com.automation.utils.Listener.class)

public class AlertsTest extends BaseTest {

    @Test(groups = {"BAT"} )
    public void test_Successful_Navigation_To_Alerts_Page() throws InterruptedException {
        new AlertsPage(getDriver()).
                click_On_Alerts_Link().
                verify_Alerts_Link_Navigation("Testing Alerts and Stuff");
    }

    @Test(groups = {"BAT"})
    public void test_Alerts_Pop_Up() throws InterruptedException {
        new AlertsPage(getDriver()).
                click_On_Alerts_Link().
                verify_Alerts_Link_Navigation("Testing Alerts and Stuff").
                click_Alerts_Pop_Up_Link();
    }

    @Test(groups = {"BAT"})
    public void test_Verify_Alerts_Pop_Up() throws InterruptedException {
        new AlertsPage(getDriver()).
                click_On_Alerts_Link().
                verify_Alerts_Link_Navigation("Testing Alerts and Stuff").
                click_Alerts_Pop_Up_Link().
                verify_Alerts_Pop_Up();
    }



}
