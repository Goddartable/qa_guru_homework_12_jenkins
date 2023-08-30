package com.demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.TableResponsiveComponent;
import io.qameta.allure.Step;

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

    @Step("Открываем страницу")
    public RegistrationPage openDemoPage() {
        open("/automation-practice-form");
        return this;
    }
    @Step("Убираем рекламу")
    public RegistrationPage removeADS() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }
    @Step("Вводим \"{value}\" в поле \"First Name\"")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    @Step("Вводим \"{value}\" в поле \"Last Name\"")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    @Step("Вводим \"{value}\" в поле \"Email\"")
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    @Step("Выбираем \"{value}\" в поле \"Gender\"")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    @Step("Вводим \"{value}\" в поле \"Mobile\"")
    public RegistrationPage setPhoneNumber(String value) {
        setPhoneInput.setValue(String.valueOf(value));
        return this;
    }
    @Step("Выставляем \"{value}\" в \"Date of Birth\"")
    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }
    @Step("Выбираем \"{value}\" в поле \"Subjects\"")
    public RegistrationPage setSubject(String value) {
        setSubjectInput.setValue(value).pressEnter();
        return this;
    }
    @Step("Выбираем \"{value}\" в поле \"Hobbies\"")
    public RegistrationPage setHobby(String value) {
        setHobbyInput.$(byText(value)).click();
        return this;
    }
    @Step("Загружаем картинку \"{value}\"")
    public RegistrationPage uploadPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);
        return this;
    }
    @Step("Вводим \"{value}\" в поле \"Current Address\"")
    public RegistrationPage setAdress(String value) {
        setAdressInput.setValue(value);
        return this;
    }
    @Step("Выбираем \"{value}\" в поле \"State\"")
    public RegistrationPage setState(String value) {
        setStateInput.click();
        setStateInput.$(byText(value)).click();
        return this;
    }
    @Step("Выбираем \"{value}\" в поле \"City\"")
    public RegistrationPage setCity(String value) {
        setCityInput.click();
        setCityInput.$(byText(value)).click();
        return this;
    }
    @Step("Нажимаем кнопку \"Submit\"")
    public RegistrationPage submitButton() {
        submit.click();
        return this;
    }
    @Step("Проверяем наличие {textElement}")
    public RegistrationPage checkResponsive(String parentElement, String textElement) {
        $(".modal-content").should(Condition.appear);
        checkResponsiveInput.checkForm(parentElement, textElement);
        return this;
    }
}
