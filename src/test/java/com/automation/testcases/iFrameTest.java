package com.automation.testcases;

import com.automation.browser.BaseTest;
import com.automation.pageobjects.iFramePage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by RashmiM on 4/5/2016.
 */

@Listeners(com.automation.utils.Listener.class)

public class iFrameTest extends BaseTest{

    @Test(groups = {"BAT"})
    public void test_Validate_Page_Header_For_IFrame_Test() throws InterruptedException {
        new iFramePage(getDriver()).
                verify_iFrame_Practice_Page_Header("IFrame practice page");
    }

    @Test(groups = {"BAT"})
    public void test_Click_Male_Radio_Button() throws InterruptedException {
        new iFramePage(getDriver()).
                verify_iFrame_Practice_Page_Header("IFrame practice page").
//                select_1st_IFrame().
                click_Male_Radio_Button();
    }

}
