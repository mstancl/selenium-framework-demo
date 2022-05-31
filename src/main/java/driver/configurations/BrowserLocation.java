package driver.configurations;

import java.util.Arrays;

public enum BrowserLocation {

    LOCAL,
    GRID;

    BrowserLocation() {
    }

    public static BrowserLocation getBrowserLocation(String browserLocation) {
        return Arrays.stream(values())
                .filter(x -> x.name().equalsIgnoreCase(browserLocation))
                .findFirst()
                .orElse(null);
    }

}
