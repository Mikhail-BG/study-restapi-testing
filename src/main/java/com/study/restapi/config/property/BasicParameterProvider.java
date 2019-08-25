package com.study.restapi.config.property;

import java.util.HashMap;
import java.util.Map;

public class BasicParameterProvider
{
    private static final Map<String, BasicParameter> LOOKUP = new HashMap<>();

    private AbstractPropertyHolder abstractPropertyHolder;
    private BasicParameter id;

    protected BasicParameterProvider(AbstractPropertyHolder abstractPropertyHolder)
    {
        this.abstractPropertyHolder = abstractPropertyHolder;
        this.id = new BasicParameter("id", abstractPropertyHolder.getProperties().getProperty("id"));
        updateLookup(id);
    }

    protected static void updateLookup(BasicParameter... basicParameters)
    {
        for (BasicParameter basicParameter : basicParameters)
        {
            LOOKUP.put(basicParameter.getParameter(), basicParameter);
        }
    }

    public BasicParameter findParameterByName(String parameterName)
    {
        return LOOKUP.get(parameterName);
    }

    protected AbstractPropertyHolder getAbstractPropertyHolder()
    {
        return abstractPropertyHolder;
    }

    public BasicParameter getId()
    {
        return id;
    }

    public static class BasicParameter
    {
        private String parameter;
        private String value;

        public BasicParameter(String parameter, String value)
        {
            this.parameter = parameter;
            this.value = value;
        }

        public String getParameter()
        {
            return parameter;
        }

        public void setParameter(String parameter)
        {
            this.parameter = parameter;
        }

        public String getValue()
        {
            return value;
        }

        public void setValue(String value)
        {
            this.value = value;
        }
    }
}
