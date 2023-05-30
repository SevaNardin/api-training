package com.socks.api.services;

import com.socks.api.ProjectConfig;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author NardinVN
 */
public class ApiService {
    // спецификация для всех сервисов - настройка
    protected RequestSpecification setUp() {

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .filter((Filter) getFilters());
    }

    private List<Filter> getFilters() {
//        Boolean enable = Boolean.valueOf(System.getProperty("logging", "true"));
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class);

        if(config.logging()) {
            return Arrays.asList(new ResponseLoggingFilter(), new ResponseLoggingFilter());
        }

        return Collections.emptyList();
    }
}
