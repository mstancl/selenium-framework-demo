package driver.configurations;

import java.util.Arrays;

public enum BrowserName {

    CHROME("chrome"),
    FIREFOX("firefox"),
    KOBITON("kobiton"),
    EDGE("microsoftEdge");


    private String name;

    BrowserName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static BrowserName getBrowserName(String browserName) {
        return Arrays.stream(values())
                .filter(x -> x.getName().equalsIgnoreCase(browserName))
                .findFirst().orElse(null);
    }
}
