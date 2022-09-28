package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.FormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FormTest {
    FormPage formPage = new FormPage();
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void firstTest() {

        formPage.openPage()
                .setFirstName("xenia")
                .setLastName("BOGATKO")
                .setEmail("BOGATKO@a.com")
                .setGender("Other")
                .setUserNumber("1234567890")
                .setBirthDate("13", "July", "1990")
                .setSubjects("English")
                .setHobbies("Music")
                .setHobbies("Reading").uploadPicture("1660769245797.jpeg")
                .setAddress("st.Address 123/2")
                .setState("Haryana")
                .setCity("Karnal")
                .submit();

        formPage.checkResultTableVisible()
                .checkResult("Student Name", "xenia BOGATKO")
                .checkResult("Student Email", "BOGATKO@a.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "13 July,1990")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Music, Reading")
                .checkResult("Picture", "1660769245797.jpeg")
                .checkResult("Address", "st.Address 123/2")
                .checkResult("State and City", "Haryana Karnal");
    }
}
