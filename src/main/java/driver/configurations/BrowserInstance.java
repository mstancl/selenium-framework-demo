package driver.configurations;

import driver.configurations.BrowserName;

public class BrowserInstance {

    private BrowserName browserName;
    private BrowserLocation browserLocation;

    public BrowserInstance(BrowserName browserName, BrowserLocation browserLocation) {
        this.browserName = browserName;
        this.browserLocation = browserLocation;
    }

    public BrowserName getBrowserName() {
        return browserName;
    }

    public void setBrowserName(BrowserName browserName) {
        this.browserName = browserName;
    }

    public BrowserLocation getBrowserLocation() {
        return browserLocation;
    }

    public void setBrowserLocation(BrowserLocation browserLocation) {
        this.browserLocation = browserLocation;
    }

    @Override
    public String toString() {
        return "BrowserInstance{" +
                "browserName='" + browserName + '\'' +
                ", browserLocation='" + browserLocation + '\'' +
                '}';
    }
}
