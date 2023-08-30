package com.demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.TableResponsiveComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    TableResponsiveComponent checkResponsiveInput = new TableResponsiveComponent();
    CalendarComponent calendar = new CalendarComponent();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            setPhoneInput = $("#userNumber"),
            setSubjectInput = $("#subjectsInput"),
            setHobbyInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            setAdressInput = $("#currentAddress"),
            setStateInput = $("#state"),
            setCityInput = $("#city"),
            submit = $("#submit");

    public RegistrationPage openDemoPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeADS() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        setPhoneInput.setValue(String.valueOf(value));
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        setSubjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String value) {
        setHobbyInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAdress(String value) {
        setAdressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        setStateInput.click();
        setStateInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        setCityInput.click();
        setCityInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submitButton() {
        submit.click();
        return this;
    }

    public RegistrationPage checkResponsive(String parentElement, String textElement) {
        $(".modal-content").should(Condition.appear);
        checkResponsiveInput.checkForm(parentElement, textElement);
        return this;
    }
}
