package step_definitions;

import io.cucumber.java.ru.И;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageStepsDef {

    private static final By SHOPPING_BUTTON = By.xpath("//div/preceding-sibling::a[@href='/index.php/magazin']");

    @И("^открываем страницу$")
    public void goToShop() {
        open("https://qahacking.guru/");
        $(SHOPPING_BUTTON).click();
    }

    @И("^переходим в магазин$")
    public void goToHome() {
        $(SHOPPING_BUTTON).click();
    }
}
