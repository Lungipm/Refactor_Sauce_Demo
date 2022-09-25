package Tests;

import PageObjects.LoginPageObjects;
import Utils.Actions;
import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseTest {


    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.saucedemo.com/");

    Actions actions = new Actions(driver);
    LoginPageObjects myloginPageObjects = PageFactory.initElements(driver, LoginPageObjects.class);




}
