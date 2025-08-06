import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DemoQATests {

    @Test
    void textBoxTest() {
        open("https://demoqa.com/");

        $$(".card").findBy(text("Elements")).click();
        $(".element-group").$$("li").findBy(text("Text Box")).click();


        $("#userName").setValue("John Doe");
        $("#userEmail").setValue("john.doe@example.com");
        $("#currentAddress").setValue("123 Main Street");
        $("#permanentAddress").setValue("456 Elm Street");

        $("#submit").scrollTo().click();

        $("#output #name").shouldHave(text("John Doe"));
        $("#output #email").shouldHave(text("john.doe@example.com"));
        $("#output #currentAddress").shouldHave(text("123 Main Street"));
        $("#output #permanentAddress").shouldHave(text("456 Elm Street"));
    }

    @Test
    void checkBoxTest() {
        open("https://demoqa.com/");

        $$(".card").findBy(text("Elements")).click();
        $(".element-group").$$("li").findBy(text("Check Box")).click();

        $(".rct-option-expand-all").click();

        $("[for='tree-node-desktop']").click();

        $("#result").shouldBe(visible)
                .shouldHave(text("desktop"))
                .shouldHave(text("notes"))
                .shouldHave(text("commands"));
    }
}
