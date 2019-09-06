package com.study.restapi.config.property.weather;

import com.study.restapi.config.LocalJasyptEncryptor;
import com.study.restapi.config.property.AbstractPropertyHolder;
import com.study.restapi.config.property.BasicParameterProvider;

public final class WeatherParameter extends BasicParameterProvider
{
    private BasicParameter appid;

    WeatherParameter(AbstractPropertyHolder abstractPropertyHolder)
    {
        super(abstractPropertyHolder);
        this.appid = new BasicParameter("APPID", LocalJasyptEncryptor.stringEncryptor()
                .decrypt(getAbstractPropertyHolder().getProperties().getProperty("appid")));
        updateLookup(appid);
    }

    public BasicParameter getAppid()
    {
        return appid;
    }
}
