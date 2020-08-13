package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GooglePage {

    SelenideElement searchInput = $(byName("q"));

    @Step("Открыть google")
    public void openMainPage() {
        open("https://google.com");
    }

    @Step("Ввести \"{someText}\" в поиск")
    public void typeSearch(String someText) {
        searchInput.setValue(someText).pressEnter();
    }

    @Step("Проверить, что \"{someText}\" появился в результатах поиска")
    public void verifyTextFoundInSearchResults(String someText) {
        $("html").shouldHave(text(someText));
    }
}
