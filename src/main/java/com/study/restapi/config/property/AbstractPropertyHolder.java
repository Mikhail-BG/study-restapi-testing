package com.study.restapi.config.property;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public abstract class AbstractPropertyHolder
{
    private String propertyFileName;

    protected AbstractPropertyHolder(String propertyFileName)
    {
        this.propertyFileName = propertyFileName;
    }

    public Properties getProperties()
    {
        if (StringUtils.isEmpty(propertyFileName))
        {
            throw new RuntimeException("Property file name is not set.");
        }
        return PropertyLoader.getProperties(propertyFileName);
    }

    public String getPropertyFileName()
    {
        return propertyFileName;
    }

    public void setPropertyFileName(String propertyFileName)
    {
        this.propertyFileName = propertyFileName;
    }
}
