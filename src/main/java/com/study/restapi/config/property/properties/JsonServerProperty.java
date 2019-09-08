package com.study.restapi.config.property.properties;

import java.util.Properties;

import com.study.restapi.config.property.PropertyLoader;

public final class JsonServerProperty
{
    public static final String URL;
    public static final String URL_COMMENT;
    private static final String FILE_NAME = "/server/json-server.properties";

    static
    {
        final Properties properties = PropertyLoader.getProperties(FILE_NAME);
        URL = properties.getProperty("json-server_url");
        URL_COMMENT = properties.getProperty("json-server_comments");
    }

    private JsonServerProperty()
    {
    }
}
