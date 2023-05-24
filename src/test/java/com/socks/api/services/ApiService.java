package com.socks.api.services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/**
 * @author NardinVN
 */
public class ApiService {
    // спецификация для всех сервисов - настройка
    public RequestSpecification setUp() {
        return RestAssured.given().contentType(ContentType.JSON).log().all();
    }
}
