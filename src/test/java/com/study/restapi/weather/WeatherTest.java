package com.study.restapi.weather;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import com.study.restapi.config.property.WeatherParameter;
import com.study.restapi.config.property.WeatherProperty;
import io.restassured.RestAssured;

public class WeatherTest
{

    @Test
    public void Test()
    {
        RestAssured
                .given()
                .param(WeatherParameter.ID.getParameter(), WeatherParameter.ID.getValue())
                .param(WeatherParameter.APPID.getParameter(), WeatherParameter.APPID.getValue())
                .when()
                .get(WeatherProperty.WEATHER_FORECAST_URL)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
