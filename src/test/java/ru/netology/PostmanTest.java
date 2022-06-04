package ru.netology;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanTest {
    @Test
    void shouldReturn() {
        Map<String, String> car = new HashMap<>();
        car.put("name", "Toyo");
        car.put("phone", "123");
        car.put("colour", "red");

        given()
                .baseUri("https://postman-echo.com")
                .body(car) // отправляемые данные (заголовки и query можно выставлять аналогично))
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("[0].name",equalTo("Toyo"))
        ;

    }

}
