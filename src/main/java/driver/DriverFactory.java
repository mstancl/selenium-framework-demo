package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import properties.PropertiesManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverFactory {

    public static WebDriver createInstance() throws MalformedURLException {

        String browserName = PropertiesManager.getProperty("browser.name");
        String browserLocation = PropertiesManager.getProperty("browser.location");

        BrowserInstance browserInstance = new BrowserInstance(browserName, browserLocation);
        return createInstance(browserInstance);
    }

    public static WebDriver createInstance(BrowserInstance browserInstance) throws MalformedURLException {
        Logger logger = Logger.getLogger("org.openqa.selenium.remote");
        logger.setLevel(Level.OFF);
        switch (browserInstance.getBrowserName()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("useAutomationExtension", false);
                chromeOptions.addArguments("disable-infobars");
                chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                if (browserInstance.getBrowserLocation().toLowerCase().equals("local")) {
                    return new ChromeDriver(chromeOptions);
                } else if (browserInstance.getBrowserLocation().toLowerCase().equals("grid")) {
                    return new RemoteWebDriver(new URL(PropertiesManager.getProperty("grid.hub.url")), chromeOptions);
                }
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "webdriver/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (browserInstance.getBrowserLocation().toLowerCase().equals("local")) {
                    return new FirefoxDriver(firefoxOptions);
                } else if (browserInstance.getBrowserLocation().toLowerCase().equals("grid")) {
                    return new RemoteWebDriver(new URL(PropertiesManager.getProperty("grid.hub.url")), firefoxOptions);
                }
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                System.setProperty("webdriver.edge.driver", "webdriver/msedgedriver.exe");
                if (browserInstance.getBrowserLocation().toLowerCase().equals("local")) {
                    return new EdgeDriver(edgeOptions);
                } else {
                    return new RemoteWebDriver(new URL(PropertiesManager.getProperty("grid.hub.url")), edgeOptions);
                }

        }
        throw new UnsupportedOperationException("Unsupported browser! " + browserInstance.toString());

    }


}
