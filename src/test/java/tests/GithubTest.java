package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {


    @Test
    void shouldFindSelenideAsRepository() {

        // - Откройте страницу Selenide в Github
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $("[href='/selenide/selenide']").click();
        // - Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(".js-wiki-more-pages-link").click();
        $$(".Box--condensed li").find(text("SoftAssertions")).shouldBe(visible);
        // - Откройте страницу SoftAssertions
        $("[href='/selenide/selenide/wiki/SoftAssertions']").click();
        // - Проверьте что внутри есть пример кода для JUnit5
        $("#wiki-body ol").shouldHave(text("JUnit5 extension - "));

    }

}
