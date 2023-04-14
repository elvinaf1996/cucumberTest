package step_definitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class Stepdefs {


    private static final By NEXT_BUTTON = By.xpath("//input[@value='Далее']");
    private static final By CONFIRM_CHECKBOX = By.xpath("//input[@type='checkbox']");
    private static final By CONFIRM_ORDER_BUTTON = By.xpath("//input[@name='finish_registration']");
    private static final By FINAL_TEXT = By.xpath("//div[@class='uk-container']/p");
    private static final By ACTIVE_STEP = By.xpath("//div[@id='tm-main']");

    
    @И("^подтверждаем заказ$")
    public void confirmTheOrder() {
        $(CONFIRM_CHECKBOX).click();
        $(CONFIRM_ORDER_BUTTON).click();
    }

    @И("убеждаемся, что заказ отправлен")
    public void makeSureTheOrderHasBeenSent() {
        $(FINAL_TEXT).shouldHave(Condition.text("Спасибо за заказ"));
    }
}