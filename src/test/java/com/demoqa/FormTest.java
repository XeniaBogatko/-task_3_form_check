package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void firstTest() {
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#ad_unit').remove()");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#RightSide_Advertisement').remove()");

        $("#firstName").setValue("xenia");
        $("#lastName").setValue("BOGATKO");
        $("#userEmail").setValue("BOGATKO@a.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__day--013").click();

        $("#subjectsInput").setValue("English").pressEnter();

        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFromClasspath("1660769245797.jpeg");
        $("#currentAddress").setValue("st.Address 123/2");

        $("#state").click();
        $("#react-select-3-option-2").click();

        $("#city").click();
        $("#react-select-4-option-0").click();

        $("#submit").click();

        $$(".table-responsive").findBy(text("Student Name")).shouldHave(text("xenia BOGATKO"));
        $$(".table-responsive").findBy(text("Student Email")).shouldHave(text("BOGATKO@a.com"));
        $$(".table-responsive").findBy(text("Gender")).shouldHave(text("Other"));
        $$(".table-responsive").findBy(text("Mobile")).shouldHave(text("1234567890"));
        $$(".table-responsive").findBy(text("Date of Birth")).shouldHave(text("13 July,1990"));
        $$(".table-responsive").findBy(text("Subjects")).shouldHave(text("English"));
        $$(".table-responsive").findBy(text("Hobbies")).shouldHave(text("Music, Reading"));
        $$(".table-responsive").findBy(text("Picture")).shouldHave(text("1660769245797.jpeg"));
        $$(".table-responsive").findBy(text("Address")).shouldHave(text("st.Address 123/2"));
        $$(".table-responsive").findBy(text("State and City")).shouldHave(text("Haryana Karnal"));
    }
}
