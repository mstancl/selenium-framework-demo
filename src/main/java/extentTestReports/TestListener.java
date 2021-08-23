package extentTestReports;

import com.aventstack.extentreports.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static driver.DriverManager.getDriver;
import static properties.PropertiesManager.getProperty;


/**
 * @author martin.stancl
 * @since 01/02/2019
 */

public class TestListener extends TestListenerAdapter implements ITestListener, IInvokedMethodListener {


    private static final ExtentReports extent = ExtentManager.getInstance();
    private static final ThreadLocal<ExtentTest> classTest = new ThreadLocal<>();
    private static final ThreadLocal<ExtentTest> suiteTest = new ThreadLocal<>();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss_SSS");


    @Override
    public synchronized void onStart(ITestContext context) {

        suiteTest.set(extent.createTest(context.getName()));
        suiteTest.get().assignCategory(getProperty("environment"));
        suiteTest.get().assignDevice(getProperty("browser.name") + "." + getProperty("browser.location"));

    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        extent.config().statusConfigurator().setStatusHierarchy(ExtentManager.statusHierarchy);
        updateReport();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {

        if (test.get() != null && test.get().getModel().getName().equals(result.getMethod().getMethodName())) {
            test.set(test.get());
        } else {
            test.set(classTest.get().createNode(result.getName()));
        }

    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        String screenshotPath;
        try {
            screenshotPath = takeScreenshot("passed", result).getMedia().getPath();
        } catch (Exception e) {
            screenshotPath = null;
        }

        super.onTestSuccess(result);

        reportResultLogScreenshot("..\\extent\\" + screenshotPath, "passed");
        test.get().log(Status.PASS, "<a href=\"" + screenshotPath + "\"><img src=\"" + screenshotPath + "\" width=\"800\"></a>");

        updateReport();

    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        String screenshotPath;
        try {
            screenshotPath = takeScreenshot("fail", result).getMedia().getPath();
        } catch (Exception e) {
            screenshotPath = null;
        }

        super.onTestFailure(result);
        if (screenshotPath != null) {
            reportResultLogScreenshot("..\\extent\\" + screenshotPath, "fail");
            reportTest(result, screenshotPath);
        }

        updateReport();
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {

        super.onTestSkipped(result);

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }


    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {


        if (iInvokedMethod.getTestMethod().isBeforeClassConfiguration() && (iInvokedMethod.getTestMethod().getTestClass().getBeforeClassMethods()[0].getRealClass() == iInvokedMethod.getTestMethod().getRealClass())) {
            String className = iInvokedMethod.getTestMethod().getTestClass().getName().split("\\.")[iInvokedMethod.getTestMethod().getTestClass().getName().split("\\.").length - 1];
            classTest.set(suiteTest.get().createNode(className));
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
    }

    private void reportTest(ITestResult result, String screenshotPath) {
        ArrayList<String> stackTrace = new ArrayList<>();
        stackTrace.add(result.getThrowable().toString() + "\n");
        for (StackTraceElement element : result.getThrowable().getStackTrace()) {
            stackTrace.add(element.getClassName() + "." + element.getMethodName() + "(" + element.getFileName() + ":" + element.getLineNumber() + ")\n");

        }
        String replace = stackTrace.toString().replace(",", "").replace("[", "").replace("]", "");
        if (screenshotPath != null) {
            test.get().log(Status.FAIL, "<textarea class=\"code-block\" disabled=\"\" style=\"height: 100px;\">" + replace + "</textarea><a href=\"" + screenshotPath + "\"><img src=\"" + screenshotPath + "\" width=\"800\"></a>");
        } else {
            test.get().log(Status.FAIL, "<textarea class=\"code-block\" disabled=\"\" style=\"height: 100px;\">" + replace + "</textarea>");

        }
    }

    private void updateReport() {
        extent.flush();
    }


    private void reportResultLogScreenshot(String filename, String type) {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        final LocalDateTime timestamp = LocalDateTime.now();
        Reporter.log("<a href=\"" + filename + "\"><p align=\"left\">Test " + type + " screenshot at " + timestamp.format(formatter) + "</p>");
        Reporter.log("<p><img width=\"600\" src=\"" + filename + "\" alt=\"Screenshot at " + timestamp.format(formatter) + "\"/></p></a><br />");

    }


    private MediaEntityModelProvider takeScreenshot(String type, ITestResult iTestResult) {

        final String saveBeginPath = "test-output" + System.getProperty("file.separator")
                + "extent" + System.getProperty("file.separator");

        final String saveRestPath = "img" + System.getProperty("file.separator");

        final String fileName = type + "_" + iTestResult.getMethod().getMethodName() + "_" + iTestResult.getEndMillis() + ".png";
        try {
            getDriver().switchTo().defaultContent();
        } catch (NullPointerException e) {
            //
        }
        final File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        final String path = saveBeginPath + saveRestPath + fileName;

        try {
            FileUtils.copyFile(file, new File(path));
            return MediaEntityBuilder
                    .createScreenCaptureFromPath(saveRestPath + fileName, "Test: " + iTestResult.getMethod().getMethodName())
                    .build();
        } catch (IOException e) {
            //
        }

        throw new NullPointerException("Could not take screenshot!");
    }


}



