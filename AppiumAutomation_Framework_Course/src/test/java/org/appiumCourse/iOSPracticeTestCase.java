package org.appiumCourse;

import TestUtilities.iOSBaseTest;
import org.appiumCourse.pageObjects.iOS.AlertViewsPage;
import org.testng.annotations.Test;

public class iOSPracticeTestCase extends iOSBaseTest {

    @Test
    public void TestAutomation() {
        AlertViewsPage alertViewsPage = homePage.selectAlertViews();
        alertViewsPage.fillTextEntry("iOS test page object model");
    }
}
