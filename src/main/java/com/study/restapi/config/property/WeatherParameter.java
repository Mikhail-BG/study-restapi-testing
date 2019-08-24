package com.study.restapi.config.property;

import java.util.HashMap;
import java.util.Map;

import com.study.restapi.config.LocalJasyptEncryptor;

public enum WeatherParameter
{
    APPID("APPID",
            LocalJasyptEncryptor.stringEncryptor()
                    .decrypt(WeatherProperty.getWeatherProperties().getProperty("appid"))),
    ID("id", WeatherProperty.getWeatherProperties().getProperty("id"));

    private static final Map<String, WeatherParameter> LOOKUP = new HashMap<>();

    static
    {
        for (WeatherParameter weatherParameter : WeatherParameter.values())
        {
            LOOKUP.put(weatherParameter.getParameter(), weatherParameter);
        }
    }

    private String parameter;
    private String value;

    WeatherParameter(String parameter, String value)
    {
        this.parameter = parameter;
        this.value = value;
    }

    public String getParameter()
    {
        return parameter;
    }

    public String getValue()
    {
        return value;
    }

    public WeatherParameter getByParameter(String parameterName)
    {
        return LOOKUP.get(parameterName);
    }
}
