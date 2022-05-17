package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestClass {


    @Test
    public void cardDelivery() {
        Calendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_YEAR, 5); // увеличиваем на 5 дня от текущей даты
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy"); //придаем нужный формат дате
        String str = format1.format(c.getTime());

        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Кемерово");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(str);
        $("[name=\"name\"]").setValue("Робертс Джулия");
        $("[name=\"phone\"]").setValue("+78906789090");
        $(withText("Я соглашаюсь с условиями")).click();
        $(byText("Забронировать")).click();
        $("[data-test-id=notification]").should(visible, Duration.ofSeconds(15));
    }
}
