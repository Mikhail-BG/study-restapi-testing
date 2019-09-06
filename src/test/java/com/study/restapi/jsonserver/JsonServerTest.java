package com.study.restapi.jsonserver;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import com.study.restapi.config.property.jsonserver.JsonServerProperty;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class JsonServerTest
{
    @Test
    public void test()
    {
        JsonServerProperty jsonServerProperty = new JsonServerProperty();

        Response response = RestAssured
                .given()
                .when()
                .get(jsonServerProperty.getJsonServerUrl() + jsonServerProperty.getCommentsUrl());

        response.then().assertThat().statusCode(HttpStatus.SC_OK);

        ResponseBody responseBody = response.then().contentType(ContentType.JSON).extract().response();
        System.out.println(responseBody.prettyPrint());
    }

}
