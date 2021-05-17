package properties;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertiesManager {

    private static final InheritableThreadLocal<Properties> properties = new InheritableThreadLocal<>();

    public static Properties getProperties() {
        return properties.get();
    }

    public static void setProperties(Properties props) {
        properties.set(props);
    }

    public static Properties readProperties(String filePath) throws IOException {
        if (getProperties() == null) {
            setProperties(new Properties());
        }
        getProperties().load(Objects.requireNonNull(PropertiesManager.class.getClassLoader().getResourceAsStream(filePath)));
        return getProperties();
    }

    public static String getProperty(String key) {
        String value = System.getProperty(key);

        if (value == null) {
            value = getProperties().getProperty(key);
        }

        return value;
    }


}
