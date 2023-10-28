package TestUtilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;

public class ExtentReporterNG {
    static ExtentReports extent;

    public static ExtentReports getReporter() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/index.html");
        reporter.config().setReportName("Practice test report");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports(); //creates reports
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Nitesh");
        return extent;
    }
}
