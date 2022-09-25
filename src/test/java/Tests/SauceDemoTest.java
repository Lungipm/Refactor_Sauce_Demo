package Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class SauceDemoTest extends BaseTest{

    public void InvalidLogin() {

        actions.takeSnapshot(driver, "Login");
        myloginPageObjects
                .enterUsername("userAdmin")
                .enterPassword("adnim")
                .clickLoginButton();
        actions.takeSnapshot(driver, "Error Message");

    }

    public void validLogin() {

        actions.takeSnapshot(driver, "Login");
        myloginPageObjects
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton();
        actions.takeSnapshot(driver, "Successful Login");

    }

    //annotation is no longer required. Taken care of in testng xml file
    @AfterTest
    public void closeBrowser() {
        browserFactory.teardown();
    }
}

