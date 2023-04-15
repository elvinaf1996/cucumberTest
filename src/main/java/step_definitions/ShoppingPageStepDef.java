package step_definitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class ShoppingPageStepDef {

    private static final By BUY_BUTTON = By.xpath(".//a[contains(@class,'button_buy')]");
    private static final By PRODUCTS_NAME = By.xpath("//div[contains(@class,'productitem')]/div[@class='name']/a");

    @И("^выбирает продукт \"(.*)\"$")
    public void selectProduct(String productName) {
        SelenideElement product = $$(PRODUCTS_NAME).findBy(Condition.text(productName)).parent().parent();
        product.$(BUY_BUTTON).click();
    }
}
