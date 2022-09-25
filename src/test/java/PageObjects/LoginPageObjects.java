
package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {

    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement user_login;

    @FindBy(id = "password")
    private WebElement user_password;

    @FindBy(id = "login-button")
    private WebElement login_button;

    @FindBy(xpath = "//h3[@data-test='error'][contains(.,'Epic sadface: Username and password do not match any user in this service')]")
    private WebElement invalidLogin;

    public LoginPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageObjects enterUsername(String username) {
        user_login.sendKeys(username);
        return  this;
    }

    public LoginPageObjects enterPassword(String password) {
        user_password.sendKeys(password);
        return this;
    }

    public LoginPageObjects clickLoginButton() {
        login_button.click();
        return  this;
    }

}


    //public void verify_incorrect_Logins() {
      //  new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(xpath_FailedLogin_Message));
     //   Assert.assertEquals(xpath_FailedLogin_Message, "Username and password do not match any user in this service");
