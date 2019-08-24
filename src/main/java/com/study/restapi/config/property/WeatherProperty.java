package com.study.restapi.config.property;

import java.util.Properties;

import com.study.restapi.config.LocalJasyptEncryptor;

public final class WeatherProperty
{
    public static final String WEATHER_FORECAST_URL;
    public static final String USER;
    public static final String PASSWORD;
    private static final String PROPERTY_FILE_NAME = "/weather.properties";
    private static final Properties PROPERTIES;

    static
    {
        PROPERTIES = PropertyLoader.getProperties(PROPERTY_FILE_NAME);
        WEATHER_FORECAST_URL = PROPERTIES.getProperty("weather_forecast_url");
        USER = LocalJasyptEncryptor.stringEncryptor().decrypt(PROPERTIES.getProperty("user"));
        PASSWORD = LocalJasyptEncryptor.stringEncryptor().decrypt(PROPERTIES.getProperty("password"));
    }

    private WeatherProperty()
    {
    }

    static Properties getWeatherProperties()
    {
        return PROPERTIES;
    }
}
