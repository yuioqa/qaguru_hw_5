import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class GitHubTest {

    @BeforeAll
    public static void setUp() {
        // Открыть браузер и перейти на базовый URL
        Configuration.baseUrl = "https://github.com";
        Configuration.browser = "chrome"; // Можно изменить на другой браузер при необходимости
        open("/");
    }

    @Test
    public void testEnterprisePageTitle() {
        $(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $("#hero-section-brand-heading").shouldBe(Condition.visible);
        $("#hero-section-brand-heading").shouldHave(Condition.text("The AI-powered developer platform."));
    }

    @AfterAll
    public static void tearDown() {
        closeWebDriver();
    }
}