package step_definitions;

import io.cucumber.java.ru.И;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasketPageStepsDef {

    private final static By CREATE_ORDER = By.xpath("//a[contains(text(), 'Оформить заказ')]");

    @И("^нажать на кнопку Оформить заказ$")
    public void createOrder() {
        $(CREATE_ORDER).click();
    }
}
