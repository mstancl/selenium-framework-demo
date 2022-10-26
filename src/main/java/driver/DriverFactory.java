package driver;

import driver.configurations.BrowserInstance;
import driver.configurations.BrowserLocation;
import driver.configurations.BrowserName;
import io.appium.java_client.android.AndroidDriver;
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

import java.io.File;
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
                if (System.getProperty("os.name").equals("Mac OS X")) {
                    System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver");
                } else {
                    System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
                }
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addExtensions(new File("extension_5_3_0_0.crx"));
                //chromeOptions.addArguments("load-extension=/Users/je95959/Library/Application Support/Google/Chrome/Default/Extensions/gighmmpiobklfepjocnamgkkbiglidom/5.3.0_0");
                chromeOptions.addArguments("disable-infobars");
                chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("--window-size=1920x1111");
                chromeOptions.addArguments("--ignore-certificate-errors"); //Required for remote
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                if (browserInstance.getBrowserLocation().equals(BrowserLocation.LOCAL)) {
                    return new ChromeDriver(chromeOptions);
                } else if (browserInstance.getBrowserLocation().equals(BrowserLocation.GRID)) {
                    return new RemoteWebDriver(new URL(PropertiesManager.getProperty("grid.hub.url")), chromeOptions);
                }
                break;
            case FIREFOX:
                if (System.getProperty("os.name").equals("Mac OS X")) {
                    System.setProperty("webdriver.gecko.driver", "webdriver/geckodriver");
                } else {
                    System.setProperty("webdriver.gecko.driver", "webdriver/geckodriver.exe");
                }
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (browserInstance.getBrowserLocation().equals(BrowserLocation.LOCAL)) {
                    return new FirefoxDriver(firefoxOptions);
                } else if (browserInstance.getBrowserLocation().equals(BrowserLocation.GRID)) {
                    return new RemoteWebDriver(new URL(PropertiesManager.getProperty("grid.hub.url")), firefoxOptions);
                }
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                System.setProperty("webdriver.edge.driver", "webdriver/msedgedriver.exe");
                edgeOptions.addArguments("InPrivate");
                edgeOptions.addArguments("start-maximized");
                edgeOptions.addArguments("--window-size=1920x1080");

                return new EdgeDriver(edgeOptions);
        }
        throw new UnsupportedOperationException("Unsuported browser! " + browserInstance);

    }


}
