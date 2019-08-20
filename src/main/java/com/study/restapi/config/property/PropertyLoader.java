package com.study.restapi.config.property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.study.restapi.config.logger.LocaleLog;

/**
 * Utils to load property from property file.
 */
public final class PropertyLoader
{
    private PropertyLoader()
    {
    }

    /**
     * Loads properties from file.
     *
     * @param propertyFileName filename of property file.
     * @return loaded properties from file.
     */
    public static Properties getProperties(String propertyFileName)
    {
        final Properties properties = new Properties();
        final InputStream inputStream = PropertyLoader.class.getResourceAsStream(propertyFileName);
        try
        {
            properties.load(inputStream);
        }
        catch (IOException ex)
        {
            LocaleLog.info(ex.getMessage());
        }

        return properties;
    }
}
