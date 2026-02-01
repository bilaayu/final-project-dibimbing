package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            InputStream input = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config/config.properties");
            if (input != null) {
                properties.load(input);
            } else {
                System.out.println("config.properties tidak ditemukan, gunakan system properties.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        String value = System.getProperty(key); // Ambil dari -Dkey=value dulu
        if (value != null && !value.isEmpty()) return value;

        return properties.getProperty(key); // fallback ke file lokal
    }
}
