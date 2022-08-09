
package com.lunna.insight.Core.commons.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * <p/>
 * Global system settings, later on to be tied to a secured directory watch to read the configs from an encrypted properties file
 */
public class SystemSettings {

    private static SystemSettings systemSettings;

    private Logger logger;

    private SystemSettings() {
        this.logger = Logger.getLogger(getClass().getName());
    }

    public static SystemSettings getInstance() {
        if (systemSettings == null) {
            systemSettings = new SystemSettings();
        }
        return systemSettings;
    }

    public void setSystemProps(String key, String value) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = getFilePath().openStream();
            prop.load(input);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error Locating the properties file", e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception e) {
                    logger.log(Level.SEVERE, "Error Releasing Input Stream", e);
                }
            }
        }
        try {
            prop.put(key, value);
            File file = new File(getFilePath().toURI());
            FileOutputStream fileOut = new FileOutputStream(file, false);
            prop.store(fileOut, "Amending property Value For Key: " + key);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error Saving Properties", ex);
        }
    }

    public String getPropertyValue(String propKey) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = getFilePath().openStream();
            prop.load(input);
            return prop.getProperty(propKey);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error Loading Properties File", ex);
            return "";
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception e) {
                    logger.log(Level.SEVERE, "Error Closing Read File input stream", e);
                }
            }
        }
    }

    public boolean propertyExists(String propKey) {
        String propValue = getPropertyValue(propKey);
        return propValue != null && !propValue.equalsIgnoreCase("");
    }

    private URL getFilePath() throws Exception {
        URL url = getClass().getClassLoader().getResource("/");
        if (url != null) {
            return new URL(url.toString() + "NexxServer.properties");
        }
        return new URL(System.getProperty("user.home") + System.getProperty("file.separator") + "NexxServer.properties");
    }
}
