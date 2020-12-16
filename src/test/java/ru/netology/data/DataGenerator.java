package ru.netology.data;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Locale;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class DataGenerator {
    private static Random random = new Random();

        private static RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(9999)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();


        public static void register (RequestData requestData) {
            // сам запрос
            given() // "дано"
                    .spec(requestSpec) // указываем, какую спецификацию используем
                    .body(requestData) // передаём в теле объект, который будет преобразован в JSON
                    .when() // "когда"
                    .post("/api/system/users") // на какой путь, относительно BaseUri отправляем запрос
                    .then() // "тогда ожидаем"
                    .statusCode(200); // код 200 OK
        }

       public static RequestData generateValidUser(){
            Faker faker = new Faker(new Locale("en"));
            String login = faker.name().username();
            String password = faker.internet().password();
            register(new RequestData(login, password, "active"));
            return new RequestData(login, password, "active");
       }
       public static RequestData generateBlockedUser(){
            Faker faker = new Faker(new Locale("en"));
            String login = faker.name().username();
            String password = faker.internet().password();
            register(new RequestData(login, password, "blocked"));
            return new RequestData(login, password, "blocked");
       }
       public static RequestData generateUserWithInvalidPassword(){
            Faker faker = new Faker(new Locale("en"));
            String login = faker.name().username();
            register(new RequestData(login, "12345", "active"));
            return new RequestData(login, "invalidPassword","active");
       }
       public static RequestData generateUserWithInvalidLogin(){
            Faker faker = new Faker(new Locale("en"));
            String password = faker.internet().password();
            register(new RequestData("petya", password, "active"));
            return new RequestData("invalidLogin", password, "active");

       }
       public static RequestData generateNonRegisteredUser(){
            Faker faker = new Faker(new Locale("en"));
            String login = faker.name().username();
            String password = faker.internet().password();
            RequestData firstUser = new RequestData(login, password, "active");
            RequestData secondUser = new RequestData(login, password, "active");
            register(firstUser);
            register(secondUser);
            return secondUser;
       }
    }

