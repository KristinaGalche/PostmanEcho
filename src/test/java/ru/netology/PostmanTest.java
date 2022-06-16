package ru.netology;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanTest {
    @Test
    public void shouldReturn() {
// Given - When - Then
        given()
                .baseUri("https://postman-echo.com")
                .body("Peter") // отправляемые данные (заголовки и query можно выставлять аналогично))
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("Peter"))
        ;
    }
}
