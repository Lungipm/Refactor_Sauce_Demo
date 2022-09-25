package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class Actions {

    protected WebDriver objDriver;

    public Actions(WebDriver driver) {objDriver = driver;
    }

    public void takeSnapshot(WebDriver driver, String screenShotname) {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs((OutputType.FILE));

        String path =  System.getProperty("user.dir") + "/PROJECT_SAUCE_DEMO/src/main/Screenshots/" + screenShotname + ".png";
        File destination = new File(path);

        try {
            FileUtils.copyFile(src, destination);

        } catch (IOException e) {
            System.out.println("Screenshot capture failed" + e.getMessage());
        }
    }
}

