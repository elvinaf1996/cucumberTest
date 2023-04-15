package step_definitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasketPageStepsDef {

    private static final By PRODUCT_NAME = By.xpath("//div[contains(text(), 'Наименование')]/following-sibling::div[@class='data']/a");
    private static final By CHECKOUT_BUTTON = By.xpath("//a[@class='btn btn-arrow-right']");

    @И("^проверяем название продукта в корзине \"(.*)\"$")
    public void checkProductName(String productName) {
        $(PRODUCT_NAME).shouldHave(Condition.text(productName));
    }

    @И("^нажимаем на кнопку 'оформить заказ'$")
    public void checkout() {
        $(CHECKOUT_BUTTON).click();
    }
}
