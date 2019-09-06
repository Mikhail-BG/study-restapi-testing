package com.study.restapi.config.model.jsonserver;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.study.restapi.config.model.AbstactModel;

public class Comment extends AbstactModel
{
    private Integer id;
    private String body;
    private Integer wineId;

    public Comment()
    {
    }

    public Comment(Integer id, String body, Integer wineId)
    {
        this.id = id;
        this.body = body;
        this.wineId = wineId;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public Integer getWineId()
    {
        return wineId;
    }

    public void setWineId(Integer wineId)
    {
        this.wineId = wineId;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
