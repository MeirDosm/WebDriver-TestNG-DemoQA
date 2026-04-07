package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static ConfigReader instance;
    private Properties properties;

    private ConfigReader(String env) {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(
                    "src/main/resources/config/env-" + env + ".properties"
            );
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config for env: " + env);
        }
    }

    public static ConfigReader getInstance(String env) {
        if (instance == null) {
            instance = new ConfigReader(env);
        }
        return instance;
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
}