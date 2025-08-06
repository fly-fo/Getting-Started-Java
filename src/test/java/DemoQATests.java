import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DemoQATests {

    @Test
    void textBoxTest() {
        // Open main DemoQA site
        open("https://demoqa.com/");

        // Navigate to 'Elements' -> 'Text Box'
        $$(".card").findBy(text("Elements")).click();
        $(".element-group").$$("li").findBy(text("Text Box")).click();

        // Fill in the form fields
        $("#userName").setValue("John Doe");
        $("#userEmail").setValue("john.doe@example.com");
        $("#currentAddress").setValue("123 Main Street");
        $("#permanentAddress").setValue("456 Elm Street");

        // Submit the form
        $("#submit").scrollTo().click();

        // Verify the submitted details
        $("#output #name").shouldHave(text("John Doe"));
        $("#output #email").shouldHave(text("john.doe@example.com"));
        $("#output #currentAddress").shouldHave(text("123 Main Street"));
        $("#output #permanentAddress").shouldHave(text("456 Elm Street"));
    }

    @Test
    void checkBoxTest() {
        // Open main DemoQA site
        open("https://demoqa.com/");

        // Navigate to 'Elements' -> 'Check Box'
        $$(".card").findBy(text("Elements")).click();
        $(".element-group").$$("li").findBy(text("Check Box")).click();

        // Expand all checkbox options
        $(".rct-option-expand-all").click();

        // Click on the "Desktop" checkbox
        $("[for='tree-node-desktop']").click();

        // Validate that checkbox selection is shown correctly
        $("#result").shouldBe(visible)
                .shouldHave(text("desktop"))
                .shouldHave(text("notes"))
                .shouldHave(text("commands"));
    }
}
