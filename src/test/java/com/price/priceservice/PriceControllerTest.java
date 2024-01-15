package com.price.priceservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.Matchers.equalTo;

import java.math.BigInteger;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceControllerTest {

    @LocalServerPort
    private int port;

    private static final BigInteger PRODUCT_ID = BigInteger.valueOf(35455);
    private static final Integer BRAND_ID = 1;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = TestConstants.BASE_URI;
        RestAssured.port = port;
    }

    @Test
    void testAt10On14th() {
        given()
            .param(TestConstants.APPLICATION_DATE_PARAM, "2020-06-14T10:00:00")
            .param(TestConstants.PRODUCT_ID_PARAM, PRODUCT_ID)
            .param(TestConstants.BRAND_ID_PARAM, BRAND_ID)
        .when()
            .get(TestConstants.PATH_API_PRICES)
        .then()
            .statusCode(HttpStatus.OK.value())
            .body(TestConstants.PRICE_PARAM, equalTo(35.50f));
    }

    @Test
    void testAt16On14th() {
        given()
            .param(TestConstants.APPLICATION_DATE_PARAM, "2020-06-14T16:00:00")
            .param(TestConstants.PRODUCT_ID_PARAM,PRODUCT_ID)
            .param(TestConstants.BRAND_ID_PARAM, BRAND_ID)
        .when()
            .get(TestConstants.PATH_API_PRICES)
        .then()
            .statusCode(HttpStatus.OK.value())
            .body(TestConstants.PRICE_PARAM, equalTo(25.45f));
    }

    @Test
    void testAt21On14th() {
        given()
            .param(TestConstants.APPLICATION_DATE_PARAM, "2020-06-14T21:00:00")
            .param(TestConstants.PRODUCT_ID_PARAM, PRODUCT_ID)
            .param(TestConstants.BRAND_ID_PARAM, BRAND_ID)
        .when()
            .get(TestConstants.PATH_API_PRICES)
        .then()
            .statusCode(HttpStatus.OK.value())
            .body(TestConstants.PRICE_PARAM, equalTo(35.50f));
    }

    @Test
    void testAt10On15th() {
        given()
            .param(TestConstants.APPLICATION_DATE_PARAM, "2020-06-15T10:00:00")
            .param(TestConstants.PRODUCT_ID_PARAM,PRODUCT_ID)
            .param(TestConstants.BRAND_ID_PARAM, BRAND_ID)
        .when()
            .get(TestConstants.PATH_API_PRICES)
        .then()
            .statusCode(HttpStatus.OK.value())
            .body(TestConstants.PRICE_PARAM, equalTo(30.50f));
    }

    @Test
    void testAt21On16th() {
        given()
            .param(TestConstants.APPLICATION_DATE_PARAM, "2020-06-16T21:00:00")
            .param(TestConstants.PRODUCT_ID_PARAM, PRODUCT_ID)
            .param(TestConstants.BRAND_ID_PARAM, BRAND_ID)
        .when()
            .get(TestConstants.PATH_API_PRICES)
        .then()
            .statusCode(HttpStatus.OK.value())
            .body(TestConstants.PRICE_PARAM, equalTo(38.95f));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2020-06-14 10:00:00", "2020/06/14 10:00:00", "2020-06-14T10:00:00", "2020-06-14-10.00.00"})
    void testAt10On14th(String date) {

        given()
            .queryParam(TestConstants.APPLICATION_DATE_PARAM, date)
            .queryParam(TestConstants.PRODUCT_ID_PARAM,PRODUCT_ID)
            .queryParam(TestConstants.BRAND_ID_PARAM, BRAND_ID)
            .accept(ContentType.JSON)
        .when()
            .get(TestConstants.PATH_API_PRICES)
        .then()
            .statusCode(HttpStatus.OK.value())
            .body(TestConstants.PRICE_PARAM, equalTo(35.50f));
    }
}
