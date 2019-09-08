package com.study.restapi.config.property.properties;

import java.util.HashMap;
import java.util.Map;

final class BasicParameterHolder
{
    private static final Map<String, BasicParameter> LOOKUP = new HashMap<>();

    private BasicParameterHolder()
    {
    }

    public static BasicParameter findParameterByName(String parameterName)
    {
        return LOOKUP.get(parameterName);
    }

    static void updateLookup(BasicParameter... basicParameters)
    {
        for (BasicParameter basicParameter : basicParameters)
        {
            LOOKUP.put(basicParameter.getParameter(), basicParameter);
        }
    }

    public static class BasicParameter
    {
        private String parameter;
        private String value;

        BasicParameter(String parameter, String value)
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
