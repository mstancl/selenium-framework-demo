package driver;

public class BrowserInstance {

    public BrowserInstance(String browserName, String browserLocation) {
        this.browserName = browserName;
        this.browserLocation = browserLocation;
    }

    private String browserName;
    private String browserLocation;


    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserLocation() {
        return browserLocation;
    }

    public void setBrowserLocation(String browserLocation) {
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
