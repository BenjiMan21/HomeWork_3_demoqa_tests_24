package com.benjiman21;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm24 {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillRegistrationForm() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Alex");
        $("[id=lastName]").setValue("Nikiforov");
        $("[id=userEmail]").setValue("unleash21@mail.ru");
        $("[id=genterWrapper]").find(byText("Male")).click();
        $("[id=userNumber]").setValue("8999777665");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").click(); $("[value='10']").click();
        $("[class=react-datepicker__year-select]").click(); $("[value='1989']").click();
        $("[class=react-datepicker__month]").find(byText("20")).click();
        $("[id=subjectsInput]").setValue("Eng"); $("[id=subjectsWrapper]").find(byText("English")).click();
        $("[id=subjectsInput]").setValue("Ma"); $("[id=subjectsWrapper]").find(byText("Maths")).click();
        $("[id=hobbiesWrapper]").find(byText("Sports")).click();
        $("[id=hobbiesWrapper]").find(byText("Reading")).click();
        $("[id=uploadPicture]").uploadFromClasspath("image.jpg");
        $("[id=currentAddress]").setValue("Lorem ipsum dolor");
        $("[id=stateCity-wrapper]").find(byText("Select State")).click();
        $("[id=stateCity-wrapper]").find(byText("NCR")).click();
        $("[id=stateCity-wrapper]").find(byText("Select City")).click();
        $("[id=stateCity-wrapper]").find(byText("Delhi")).click();
        $("[id=submit]").click();

        $("[class=modal-content]").shouldHave(text("Thanks for submitting the form"));
    }
}
