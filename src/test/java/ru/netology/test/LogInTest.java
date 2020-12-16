package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataGenerator.generateValidUser;

public class LogInTest {

    @BeforeEach
    void setUp(){
        open ("http://localhost:9999/");
    }

    @Test
    void shouldLogIn(){
    val RequestData = generateValidUser();
    $ ("[data-test-id=login][name=login]").setValue(RequestData.getLogin());
    $ ("[data-test-id=password][name=password]").setValue(RequestData.getPassword());
    $ ("[data-test-id=action-login][class=button__text]").click();
    $("h2").shouldHave(text("Личный кабинет"));

    }
}
