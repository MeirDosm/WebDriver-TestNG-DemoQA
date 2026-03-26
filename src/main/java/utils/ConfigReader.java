package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    public static void load(String env) {
        try {
            FileInputStream fis = new FileInputStream(
                    "src/main/resources/config/env-" + env + ".properties"
            );
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config file for env: " + env);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}