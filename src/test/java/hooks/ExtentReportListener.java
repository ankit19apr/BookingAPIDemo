package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

public class ExtentReportListener implements ConcurrentEventListener {

    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
        publisher.registerHandlerFor(TestCaseFinished.class, this::onTestCaseFinished);
    }

    private void onTestCaseStarted(TestCaseStarted event) {
        if (extentReports == null) {
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("src/test/java/reports/ExtentReport.html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(htmlReporter);
        }
        extentTest = extentReports.createTest(event.getTestCase().getName());
    }

    private void onTestCaseFinished(TestCaseFinished event) {
        if (event.getResult().getStatus().is(Status.PASSED)) {
            extentTest.pass("Test Passed");
        } else {
            extentTest.fail("Test Failed");
        }
        extentReports.flush();
    }
}
