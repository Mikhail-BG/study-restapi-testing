package com.study.restapi.weather;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import com.study.restapi.config.property.properties.WeatherProperty;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class WeatherTest
{
    @Test
    public void test()
    {
        Response response = RestAssured
                .given()
                .param(WeatherProperty.ID.getParameter(), WeatherProperty.ID.getValue())
                .param(WeatherProperty.APPID.getParameter(), WeatherProperty.APPID.getValue())
                .when()
                .get(WeatherProperty.URL);

        response.then().assertThat().statusCode(HttpStatus.SC_OK);

        ResponseBody responseBody = response.then().contentType(ContentType.JSON).extract().response();
        System.out.println(responseBody.prettyPrint());
    }
}
