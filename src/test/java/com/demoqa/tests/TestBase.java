package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import com.demoqa.attachments.ReportAttachments;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("Allure", new AllureSelenide());
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        //Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

      /*DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;*/

    }

    @AfterAll
    static void afterAllTests() {
        //ReportAttachments.addVideo();
        ReportAttachments.attachScreenshot();
    }
}
