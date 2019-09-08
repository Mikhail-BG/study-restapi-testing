package com.study.restapi.jsonserver;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import com.study.restapi.config.model.jsonserver.Comment;
import com.study.restapi.config.property.properties.JsonServerProperty;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class JsonServerTest
{
    @Test
    public void getRecordsTest()
    {
        Response response = RestAssured
                .given()
                .when()
                .get(JsonServerProperty.URL + JsonServerProperty.URL_COMMENT);

        response.then().assertThat().statusCode(HttpStatus.SC_OK);

        ResponseBody responseBody = response.then().contentType(ContentType.JSON).extract().response();
        System.out.println(responseBody.prettyPrint());
    }

    @Test
    public void postCommentTest()
    {
        Comment comment = new Comment(41, "My comment", 20);

        Response response = RestAssured
                .given()
                .when()
                .contentType(ContentType.JSON)
                .body(comment)
                .post(JsonServerProperty.URL + JsonServerProperty.URL_COMMENT);

        ResponseBody responseBody = response.then().contentType(ContentType.JSON).extract().response();
        System.out.println(responseBody.prettyPrint());
    }
}
