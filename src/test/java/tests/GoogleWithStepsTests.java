package tests;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;


class GoogleWithStepsTests {

    @Test
    void selenideSearchTest() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        String searchText = "Selenide";

        step("Открыть google", ()-> {
            open("https://google.com");
        });

        step("Ввести " + searchText + " в поиск", ()-> {
            $(byName("q")).setValue(searchText).pressEnter();
        });

        step("Проверить, что Selenide появился в результатах поиска", ()-> {
            $("html").shouldHave(text("ru.selenide.org"));
            $("html").shouldHave(text("ru.selenide.org"));
        });
    }

}
