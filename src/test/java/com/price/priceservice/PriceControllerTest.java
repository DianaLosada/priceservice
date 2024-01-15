package com.price.priceservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.Matchers.equalTo;

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

    private static final int PRODUCT_ID = 35455;
    private static final int BRAND_ID = 1;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = TestConstants.BASE_URI;
        RestAssured.port = port;
    }


    @ParameterizedTest
    @CsvSource({
            "2020-06-14T10:00:00, 35.50f, 1, 2020-06-14T00:00:00, 2020-12-31T23:59:59",
            "2020-06-14T16:00:00, 25.45f, 2, 2020-06-14T15:00:00, 2020-06-14T18:30:00",
            "2020-06-14T21:00:00, 35.50f, 1, 2020-06-14T00:00:00, 2020-12-31T23:59:59",
            "2020-06-15T10:00:00, 30.50f, 3, 2020-06-15T00:00:00, 2020-06-15T11:00:00",
            "2020-06-16T21:00:00, 38.95f, 4, 2020-06-15T16:00:00, 2020-12-31T23:59:59"
    })
    void shouldReturnCorrectPrice(String date, float price, int priceList, String startDate, String endDate){

        given()
                .queryParam(TestConstants.APPLICATION_DATE_PARAM, date)
                .queryParam(TestConstants.PRODUCT_ID_PARAM,PRODUCT_ID)
                .queryParam(TestConstants.BRAND_ID_PARAM, BRAND_ID)
                .accept(ContentType.JSON)
        .when()
                .get(TestConstants.PATH_API_PRICES)
        .then()
                .statusCode(HttpStatus.OK.value())
                .contentType(ContentType.JSON)
                .body(
                        TestConstants.PRICE_PARAM, equalTo(price),
                        TestConstants.BRAND_ID_PARAM, equalTo(BRAND_ID),
                        TestConstants.PRODUCT_ID_PARAM, equalTo(PRODUCT_ID),
                        TestConstants.PRICE_LIST_PARAM, equalTo(priceList),
                        TestConstants.START_DATE_PARAM, equalTo(startDate),
                        TestConstants.END_DATE_PARAM, equalTo(endDate)

                );
    }

    @ParameterizedTest
    @ValueSource(strings = {"2020-06-14 10:00:00", "2020/06/14 10:00:00", "2020-06-14T10:00:00", "2020-06-14-10.00.00"})
    void shouldReturnSamePriceWithDifferentDateFormats(String date) {
        final float PRICE_VALUE = 35.50f;
        given()
            .queryParam(TestConstants.APPLICATION_DATE_PARAM, date)
            .queryParam(TestConstants.PRODUCT_ID_PARAM,PRODUCT_ID)
            .queryParam(TestConstants.BRAND_ID_PARAM, BRAND_ID)
            .accept(ContentType.JSON)
        .when()
            .get(TestConstants.PATH_API_PRICES)
        .then()
            .statusCode(HttpStatus.OK.value())
            .body(TestConstants.PRICE_PARAM, equalTo(PRICE_VALUE));
    }
}
