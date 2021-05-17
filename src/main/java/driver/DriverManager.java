package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final InheritableThreadLocal<WebDriver> dr = new InheritableThreadLocal<WebDriver>();
    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setDriver(WebDriver driver) {
        dr.set(driver);
    }

    public static void removeDriver() {
        if (getDriver() != null) {
            try {
                getDriver().quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        setDriver(null);
        dr.remove();

    }


}
