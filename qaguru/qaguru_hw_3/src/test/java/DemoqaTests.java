import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "3840 x 2160";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
    }


    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Andrey");
        $("#lastName").setValue("Telezhenko");
        $("#userEmail").setValue("andrey@telezhenko.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("June")).click();
        $(".react-datepicker__year-select").$(byText("1991")).click();
        $(".react-datepicker__month").$(byText("13")).click();
        $("#subjectsInput").setValue("Co");
        $(".subjects-auto-complete__menu-list").$(byText("Computer Science")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("#currentAddress").setValue("Улица Пушкина дом Колотушкина");
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        $("#submit").click();

        $(".table-responsive").shouldHave(text("Andrey Telezhenko"));
        $(".table-responsive").shouldHave(text("andrey@telezhenko.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("0123456789"));
        $(".table-responsive").shouldHave(text("13 June,1991"));
        $(".table-responsive").shouldHave(text("Computer Science"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("test.jpg"));
        $(".table-responsive").shouldHave(text("Улица Пушкина дом Колотушкина"));
        $(".table-responsive").shouldHave(text("NCR Noida"));
    }
}
