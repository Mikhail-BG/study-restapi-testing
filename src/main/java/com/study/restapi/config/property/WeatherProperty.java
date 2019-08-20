package com.study.restapi.config.property;

import java.util.Properties;

import com.study.restapi.config.LocalJasyptEncryptor;

public final class WeatherProperty
{
    public static final String USER;
    public static final String PASSWORD;
    public static final String API_KEY;

    static
    {
        final Properties properties = PropertyLoader.getProperties("/weather.properties");
        USER = LocalJasyptEncryptor.stringEncryptor().decrypt(properties.getProperty("user"));
        PASSWORD = LocalJasyptEncryptor.stringEncryptor().decrypt(properties.getProperty("password"));
        API_KEY = LocalJasyptEncryptor.stringEncryptor().decrypt(properties.getProperty("api_key"));
    }

    private WeatherProperty()
    {
    }
}
