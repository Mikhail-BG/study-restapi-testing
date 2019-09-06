package com.study.restapi.config.property;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public abstract class AbstractPropertyHolder<T>
{
    private String propertyFileName;
    private T parameters;

    protected AbstractPropertyHolder(String propertyFileName)
    {
        this.propertyFileName = propertyFileName;
        this.parameters = loadParameters();
    }

    /**
     * Load parameters from the file.
     *
     * @return all parameters.
     * */
    public abstract T loadParameters();

    /**
     * Returns loaded properties from the file.
     * @return loaded properties
     * */
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

    public T getParameters()
    {
        return parameters;
    }

    protected AbstractPropertyHolder getPropertyHolder()
    {
        return this;
    }
}
