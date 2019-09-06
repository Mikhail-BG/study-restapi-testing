package com.study.restapi.config.property.jsonserver;

import com.study.restapi.config.property.AbstractPropertyHolder;

public final class JsonServerProperty extends AbstractPropertyHolder
{
    private String jsonServerUrl;
    private String commentsUrl;

    public JsonServerProperty()
    {
        super("/server/json-server.properties");
        this.jsonServerUrl = getProperties().getProperty("json-server_url");
        this.commentsUrl = getProperties().getProperty("json-server_comments");
    }

    @Override
    public Object loadParameters()
    {
        return null;
    }

    public String getJsonServerUrl()
    {
        return jsonServerUrl;
    }

    public String getCommentsUrl()
    {
        return commentsUrl;
    }
}
