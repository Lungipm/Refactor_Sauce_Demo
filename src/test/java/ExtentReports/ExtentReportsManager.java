package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReportsManager {

    private static ExtentReports extentsReports;
    private  static ExtentSparkReporter sparkReporter;
    private static String reportPath = System.getProperty("user.dir");

    public static ExtentReports reportSetup() {
        extentsReports = new ExtentReports();
        sparkReporter = new ExtentSparkReporter(new File(reportPath + "/src/main/Report/ExtentReport.html"));
        extentsReports.attachReporter(sparkReporter);

        sparkReporter.config().setDocumentTitle("Regression Testing Results");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Sauce Demo report");

        extentsReports.setSystemInfo("Browser", "Chrome");
        extentsReports.setSystemInfo("OS", "os name");
        extentsReports.setSystemInfo("Url", "https://www.saucedemo.com");
        extentsReports.setSystemInfo("Machine", "user.name");

        return extentsReports;
    }


}
