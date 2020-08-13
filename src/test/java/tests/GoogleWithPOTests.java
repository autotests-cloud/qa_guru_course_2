package tests;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import pages.GooglePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;


class GoogleWithPOTests {

    @Test
    void selenideSearchTest() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        GooglePage googlePage = new GooglePage();

        googlePage.openMainPage();

        googlePage.typeSearch("Selenide");

        googlePage.verifyTextFoundInSearchResults("ru.selenide.org");

    }

}
