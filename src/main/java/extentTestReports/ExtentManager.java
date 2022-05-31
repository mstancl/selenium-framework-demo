package extentTestReports;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;


class ExtentManager {
    public static final List<Status> statusHierarchy = Arrays.asList(
            Status.FATAL,
            Status.FAIL,
            Status.ERROR,
            Status.WARNING,
            Status.SKIP,
            Status.PASS,
            Status.DEBUG,
            Status.INFO
    );
    private static final String REPORT_FOLDER = "test-output" + System.getProperty("file.separator") + "extent" + System.getProperty("file.separator");
    private static final String REPORT_CONFIG = "extent.xml";
    private static final String REPORT_NAME = "extent.html";
    private static ExtentReports extent;

    static ExtentReports getInstance() {
        if (extent == null) {
            createInstance(REPORT_FOLDER + REPORT_NAME);
        }
        return extent;
    }

    private static ExtentReports createInstance(String fileName) {
        extent = new ExtentReports();
        extent.setAnalysisStrategy(AnalysisStrategy.SUITE);

        extent.config().statusConfigurator().setStatusHierarchy(statusHierarchy);

        extent.setSystemInfo("Username", System.getProperty("user.name"));
        extent.setSystemInfo("Platform", System.getProperty("os.name")
                + " (v: " + System.getProperty("os.version")
                + ") arch: " + System.getProperty("os.arch"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));

        extent.attachReporter(getHtmlReporter(fileName, REPORT_FOLDER, REPORT_CONFIG));


        return extent;
    }

    private static ExtentHtmlReporter getHtmlReporter(String fileName, String reportPath, String configFile) {

        final ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);

        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Test report");
        htmlReporter.config().setDocumentTitle("Test report");
        htmlReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss a");

        final URL inputUrl = ExtentManager.class.getClassLoader().getResource(configFile);
        final File dest = new File(reportPath + configFile);

        try {
            if (inputUrl != null && !inputUrl.toString().isEmpty()) {
                FileUtils.copyURLToFile(inputUrl, dest);
                htmlReporter.loadXMLConfig(reportPath + configFile);
            }
        } catch (IOException e) {
            // log.error("Exception while copying report config file: {}", e.getLocalizedMessage(), e);
        }

        return htmlReporter;
    }

}
