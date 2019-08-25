package com.study.restapi.config.property.weather;

import com.study.restapi.config.LocalJasyptEncryptor;
import com.study.restapi.config.property.AbstractPropertyHolder;

public final class WeatherProperty extends AbstractPropertyHolder
{
    private static WeatherProperty instance;

    private String weatherForecastUrl;
    private String user;
    private String password;

    private WeatherProperty()
    {
        super("/weather.properties");
        this.weatherForecastUrl = getProperties().getProperty("weather_forecast_url");
        this.user = LocalJasyptEncryptor.stringEncryptor().decrypt(getProperties().getProperty("user"));
        this.password = LocalJasyptEncryptor.stringEncryptor().decrypt(getProperties().getProperty("password"));
    }

    public static synchronized WeatherProperty getInstance()
    {
        if (instance == null)
        {
            synchronized (WeatherProperty.class)
            {
                if (instance == null)
                {
                    instance = new WeatherProperty();
                }
            }
        }
        return instance;
    }

    public String getWeatherForecastUrl()
    {
        return weatherForecastUrl;
    }

    public String getUser()
    {
        return user;
    }

    public String getPassword()
    {
        return password;
    }
}
