package step_definitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class CatalogPageStepsDef {

    private static final By PRODUCT_CARD = By.xpath("//div[@class='block_product']");
    private static final By PRODUCT_NAME = By.xpath(".//div[@class='name']//a");
    private static final By BUY_BUTTON = By.xpath(".//a[@class='btn btn-success button_buy']");

    @И("^добавить в корзину \"(.*)\"$")
    public void addToBasket(String productName) {
        SelenideElement selenideElement = $$(PRODUCT_NAME).findBy(Condition.text(productName)).parent().parent();
        selenideElement.$(BUY_BUTTON).click();
    }
}
