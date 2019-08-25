package com.study.restapi.weather;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import com.study.restapi.config.property.weather.WeatherParameter;
import com.study.restapi.config.property.weather.WeatherProperty;
import io.restassured.RestAssured;

public class WeatherTest
{

    @Test
    public void Test()
    {
        WeatherParameter weatherParameter = WeatherParameter.getInstance();
        WeatherProperty weatherProperty = WeatherProperty.getInstance();
        RestAssured
                .given()
                .param(weatherParameter.getId().getParameter(), weatherParameter.getId().getValue())
                .param(weatherParameter.getAppid().getParameter(), weatherParameter.getAppid().getValue())
                .when()
                .get(weatherProperty.getWeatherForecastUrl())
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
