package com.study.restapi.config.property.weather;

import com.study.restapi.config.LocalJasyptEncryptor;
import com.study.restapi.config.property.AbstractPropertyHolder;

public final class WeatherProperty extends AbstractPropertyHolder<WeatherParameter>
{
    private String weatherForecastUrl;
    private String user;
    private String password;

    public WeatherProperty()
    {
        super("/server/weather.properties");
        this.weatherForecastUrl = getProperties().getProperty("weather_forecast_url");
        this.user = LocalJasyptEncryptor.stringEncryptor().decrypt(getProperties().getProperty("user"));
        this.password = LocalJasyptEncryptor.stringEncryptor().decrypt(getProperties().getProperty("password"));
    }

    @Override
    public WeatherParameter loadParameters()
    {
        return new WeatherParameter(getPropertyHolder());
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
