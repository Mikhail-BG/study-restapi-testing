package com.study.restapi.config.property.properties;

import java.util.Properties;

import com.study.restapi.config.LocalJasyptEncryptor;
import com.study.restapi.config.property.PropertyLoader;

public final class WeatherProperty
{
    public static final String URL;
    public static final String USER;
    public static final String PASSWORD;
    public static final BasicParameterHolder.BasicParameter APPID;
    public static final BasicParameterHolder.BasicParameter ID;
    private static final String FILE_NAME = "/server/weather.properties";

    static
    {
        final Properties properties = PropertyLoader.getProperties(FILE_NAME);
        URL = properties.getProperty("weather_forecast_url");
        USER = LocalJasyptEncryptor.stringEncryptor().decrypt(properties.getProperty("user"));
        PASSWORD = LocalJasyptEncryptor.stringEncryptor().decrypt(properties.getProperty("password"));
        APPID = new BasicParameterHolder.BasicParameter("appid",
                LocalJasyptEncryptor.stringEncryptor().decrypt(properties.getProperty("appid")));
        ID = new BasicParameterHolder.BasicParameter("id", properties.getProperty("id"));
        BasicParameterHolder.updateLookup(APPID, ID);
    }

    private String weatherForecastUrl;
    private String user;
    private String password;

    private WeatherProperty()
    {
    }
}
