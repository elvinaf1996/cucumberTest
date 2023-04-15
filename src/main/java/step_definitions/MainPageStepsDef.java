package step_definitions;

import io.cucumber.java.ru.И;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageStepsDef {

    private static final By SHOPPING_LINK = By.xpath("//div/preceding-sibling::a[@href='/index.php/magazin']");

    @И("^открыть сайт$")
    public void openPage() {
        open("https://qahacking.guru/");
    }

    @И("^перейти в магазин$")
    public void goToShopping() {
        $(SHOPPING_LINK).click();
        $(SHOPPING_LINK).click();
    }
}
