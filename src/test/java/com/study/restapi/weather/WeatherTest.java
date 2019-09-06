package com.study.restapi.weather;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import com.study.restapi.config.property.weather.WeatherProperty;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class WeatherTest
{
    @Test
    public void test()
    {
        WeatherProperty weatherProperty = new WeatherProperty();

        Response response = RestAssured
                .given()
                .param(weatherProperty.getParameters().getId().getParameter(),
                        weatherProperty.getParameters().getId().getValue())
                .param(weatherProperty.getParameters().getAppid().getParameter(),
                        weatherProperty.getParameters().getAppid().getValue())
                .when()
                .get(weatherProperty.getWeatherForecastUrl());

        response.then().assertThat().statusCode(HttpStatus.SC_OK);

        ResponseBody responseBody = response.then().contentType(ContentType.JSON).extract().response();
        System.out.println(responseBody.prettyPrint());
    }
}
