package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestClass {

    @Test
    public void cardDelivery() {

        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Кемерово");
        $("[data-test-id='date'] input").setValue("30.05.2022");
        $("[name=\"name\"]").setValue("Робертс Джулия");
        $("[name=\"phone\"]").setValue("+78906789090");
        $(withText("Я соглашаюсь с условиями")).click();
        $(byText("Забронировать")).click();
        $("[data-test-id=notification]").should(visible, Duration.ofSeconds(15));
    }
}
