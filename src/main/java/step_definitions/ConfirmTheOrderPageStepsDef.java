package step_definitions;

import io.cucumber.java.ru.И;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ConfirmTheOrderPageStepsDef {

    private static final By CONFIRM_CHECKBOX = By.xpath("//input[@type='checkbox']");
    private static final By CONFIRM_ORDER_BUTTON = By.xpath("//input[@name='finish_registration']");

    @И("^подтверждаем заказ$")
    public void confirmTheOrder() {
        $(CONFIRM_CHECKBOX).click();
        $(CONFIRM_ORDER_BUTTON).click();
    }
}
