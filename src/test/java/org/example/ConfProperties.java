package org.example;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties properties;

    static {
    }

    public static Properties initProperties() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/test/sources/conf.properties")) {
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.out.println("Can't read properties");
            e.printStackTrace();
        }
        System.out.println(properties.toString());
        return properties;
    }

    public static String getProperty(String key) {
        if (properties == null) {
            properties = initProperties();
        }
        return properties.getProperty(key);
    }
}