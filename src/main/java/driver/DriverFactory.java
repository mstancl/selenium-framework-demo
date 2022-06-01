package driver;

import driver.configurations.BrowserInstance;
import driver.configurations.BrowserLocation;
import driver.configurations.BrowserName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import properties.PropertiesManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverFactory {

    public static WebDriver createInstance() throws MalformedURLException {

        BrowserInstance browserInstance = new BrowserInstance(BrowserName.getBrowserName(PropertiesManager.getProperty("browser.name")), BrowserLocation.getBrowserLocation(PropertiesManager.getProperty("browser.location")));
        return createInstance(browserInstance);
    }

    public static WebDriver createInstance(BrowserInstance browserInstance) throws MalformedURLException {
        Logger logger = Logger.getLogger("org.openqa.selenium.remote");
        logger.setLevel(Level.OFF);
        switch (browserInstance.getBrowserName()) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("useAutomationExtension", false);
                chromeOptions.addArguments("disable-infobars");
                chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                if (browserInstance.getBrowserLocation().equals(BrowserLocation.LOCAL)) {
                    return new ChromeDriver(chromeOptions);
                } else if (browserInstance.getBrowserLocation().equals(BrowserLocation.GRID)) {
                    return new RemoteWebDriver(new URL(PropertiesManager.getProperty("grid.hub.url")), chromeOptions);
                }
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "webdriver/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (browserInstance.getBrowserLocation().equals(BrowserLocation.LOCAL)) {
                    return new FirefoxDriver(firefoxOptions);
                } else if (browserInstance.getBrowserLocation().equals(BrowserLocation.GRID)) {
                    return new RemoteWebDriver(new URL(PropertiesManager.getProperty("grid.hub.url")), firefoxOptions);
                }
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                System.setProperty("webdriver.edge.driver", System.getenv("EDGE_WEBDRIVER"));
                edgeOptions.addArguments("InPrivate");
                edgeOptions.addArguments("start-maximized");
                edgeOptions.addArguments("--window-size=1920x1080");

                return new EdgeDriver(edgeOptions);

            case KOBITON:
                String kobitonServerUrl = "https://qhub_poc:d8e45b2f-8bf0-48c5-a160-5b2f658d736b@api.kobiton.com/wd/hub";

                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("sessionName", "Automation test session");
                capabilities.setCapability("sessionDescription", "");
                capabilities.setCapability("deviceOrientation", "portrait");
                capabilities.setCapability("noReset", true);
                capabilities.setCapability("fullReset", false);
                capabilities.setCapability("captureScreenshots", true);
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("deviceGroup", "ORGANIZATION");
                capabilities.setCapability("deviceName", "motorola moto g(9) power");
                capabilities.setCapability("tagName", "");
                capabilities.setCapability("platformVersion", "11");
                capabilities.setCapability("platformName", "Android");
                chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("w3c", false);
                capabilities.setCapability("chromeOptions", chromeOptions);
                return new RemoteWebDriver(new URL(kobitonServerUrl), capabilities);

        }
        throw new UnsupportedOperationException("Unsuported browser! " + browserInstance.toString());

    }


}
