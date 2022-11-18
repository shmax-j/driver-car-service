package taxi.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Set;

public class ConnectionUtil {
    private static final String propertiesPath = "/app.properties";
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
    private static final String JDBC_DRIVER;
    private static final Properties appProperties;

    static {
        appProperties = new Properties();
        try (InputStream inputStream
                     = ConnectionUtil.class.getResourceAsStream(propertiesPath)) {
            appProperties.load(inputStream);
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("Can't load "
                    + "application properties", e);
        }
        if (!appProperties.keySet().containsAll(Set.of(
                "db.url", "db.username", "db.password", "db.driver-path"
        ))) {
            throw new RuntimeException("Some properties for"
                    + " db connection is missing!");
        }
        URL = appProperties.getProperty("db.url");
        USERNAME = appProperties.getProperty("db.username");
        PASSWORD = appProperties.getProperty("db.password");
        JDBC_DRIVER = appProperties.getProperty("db.driver-path");
    }

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find SQL Driver", e);
        }
    }

    public static Connection getConnection() {
        Properties dbProperties = new Properties();
        dbProperties.setProperty("user", USERNAME);
        dbProperties.setProperty("password", PASSWORD);
        try {
            return DriverManager.getConnection(URL, dbProperties);
        } catch (SQLException e) {
            throw new RuntimeException("Can't create connection to DB ", e);
        }
    }
}
