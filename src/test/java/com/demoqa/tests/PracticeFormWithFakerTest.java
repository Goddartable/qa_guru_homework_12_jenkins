package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.UserVariables.*;

public class PracticeFormWithFakerTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("remote")
    @DisplayName("Заполнение формы сайта demoqa.com случайными данными с проверкой вывода в модальное окно")
    void fillFormTest() {
        registrationPage
                .openDemoPage()
                .removeADS()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setPhoneNumber(userPhone)
                .setBirthDate(userDay, userMonth, userYear)
                .setSubject(userSubjects)
                .setHobby(userHobby)
                .uploadPicture(userPicture)
                .setAdress(userAdress)
                .setState(userState)
                .setCity(userCity)
                .submitButton()
                .checkResponsive(studentName, userFirstName + " " + userLastName)
                .checkResponsive(studentMail, userEmail)
                .checkResponsive(studentGender, userGender)
                .checkResponsive(studentPhone, userPhone)
                .checkResponsive(studentBirth, userDay + " " + userMonth + "," + userYear)
                .checkResponsive(studentSubs, userSubjects)
                .checkResponsive(studentHobbs, userHobby)
                .checkResponsive(studentPics, userPicture)
                .checkResponsive(studentAddr, userAdress)
                .checkResponsive(studentSaS, userState + " " + userCity);
    }
}
