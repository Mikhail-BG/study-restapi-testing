package com.study.restapi.config.property.weather;

import com.study.restapi.config.LocalJasyptEncryptor;
import com.study.restapi.config.property.BasicParameterProvider;

public final class WeatherParameter extends BasicParameterProvider
{
    private static WeatherParameter instance;
    private BasicParameter appid;

    private WeatherParameter()
    {
        super(WeatherProperty.getInstance());
        this.appid = new BasicParameter("APPID", LocalJasyptEncryptor.stringEncryptor()
                .decrypt(getAbstractPropertyHolder().getProperties().getProperty("appid")));
        updateLookup(appid);
    }

    public static synchronized WeatherParameter getInstance()
    {
        if (instance == null)
        {
            synchronized (WeatherParameter.class)
            {
                if (instance == null)
                {
                    instance = new WeatherParameter();
                }
            }
        }
        return instance;
    }

    public BasicParameter getAppid()
    {
        return appid;
    }
}
