package driver.configurations;

public class BrowserInstance {

    private BrowserName browserName;

    public BrowserInstance(BrowserName browserName) {
        this.browserName = browserName;
    }

    public BrowserName getBrowserName() {
        return browserName;
    }

    public void setBrowserName(BrowserName browserName) {
        this.browserName = browserName;
    }


    @Override
    public String toString() {
        return "BrowserInstance{" +
                "browserName='" + browserName + '\'' +
                '}';
    }
}
