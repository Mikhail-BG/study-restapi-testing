package com.study.restapi.weather;

import org.testng.annotations.Test;

import com.study.restapi.config.property.WeatherProperty;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WeatherTest
{

    @Test
    public void Test()
    {
        Response response = RestAssured
                .when()
                .get("http://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=" + WeatherProperty.API_KEY);

        response.getStatusCode();
    }
}
