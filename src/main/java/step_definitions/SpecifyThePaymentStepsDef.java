package step_definitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SpecifyThePaymentStepsDef {

    private static final By ACTIVE_STEP = By.xpath("//div[@id='tm-main']");
    private static final By NEXT_BUTTON = By.xpath("//input[@value='Далее']");

    @И("^указываем способ оплаты$")
    public void specifyThePaymentMethod() {
        $(ACTIVE_STEP).shouldHave(Condition.text("Способ оплаты"));
        $(NEXT_BUTTON).click();
    }
}
