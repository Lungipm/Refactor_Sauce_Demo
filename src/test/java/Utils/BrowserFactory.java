package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BrowserFactory {

    //Configure browsers that will be used for execution

    static WebDriver driver=null;


    @BeforeTest
    public static WebDriver startBrowser(String browserChoice, String url) {

        if ("chrome".equalsIgnoreCase(browserChoice)) {

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("disable-infobars");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);

        } else if ("firefox". equalsIgnoreCase(browserChoice)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        else if ("edge".equalsIgnoreCase(browserChoice)) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
