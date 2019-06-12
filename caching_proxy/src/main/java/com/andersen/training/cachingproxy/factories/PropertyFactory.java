package com.andersen.training.cachingproxy.factories;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyFactory {
    private static final Logger LOGGER = Logger.getLogger(PropertyFactory.class.getName());
    public static Properties getProperty(String fileName) {
        Properties property = new Properties();
        try {
            property.load(ClassLoader.getSystemResourceAsStream(fileName));
            return property;
        } catch (IOException e) {
            LOGGER.log(Level.INFO, e.getMessage(), e);
            return property;
        }
    }
}
