package step_definitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class OrderFinalPageStepDef {

    private static final By FINAL_TEXT = By.xpath("//div[@class='uk-container']/p");

    @И("убеждаемся, что заказ отправлен")
    public void makeSureTheOrderHasBeenSent() {
        $(FINAL_TEXT).shouldHave(Condition.text("Спасибо за заказ"));
    }
}