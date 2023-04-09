package step_definitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.ProjectConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.И;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class Stepdefs {

    private static final ProjectConfig cfg = ConfigFactory.create(ProjectConfig.class);
    private static final By PRODUCT_NAME = By.xpath("//div[contains(text(), 'Наименование')]/following-sibling::div[@class='data']/a");
    private static final By SHOPPING_BUTTON = By.xpath("//div/preceding-sibling::a[@href='/index.php/magazin']");
    private static final By BUY_BUTTON = By.xpath(".//a[contains(@class,'button_buy')]");
    private static final By PRODUCTS_NAME = By.xpath("//div[contains(@class,'productitem')]/div[@class='name']/a");
    private static final By CHECKOUT_BUTTON = By.xpath("//a[@class='btn btn-arrow-right']");
    private static final By NAME_FIELD = By.xpath("//input[@name='f_name']");
    private static final By LAST_NAME = By.xpath("//input[@name='l_name']");
    private static final By EMAIL = By.xpath("//input[@id='email']");
    private static final By STREET = By.xpath("//input[@name='street']");
    private static final By POST_CODE = By.xpath("//input[@id='zip']");
    private static final By CITY = By.xpath("//input[@name='city']");
    private static final By REGION = By.xpath("//input[@name='state']");
    private static final By PHONE = By.xpath("//input[@name='phone']");
    private static final By NEXT_BUTTON = By.xpath("//input[@value='Далее']");
    private static final By CONFIRM_CHECKBOX = By.xpath("//input[@type='checkbox']");
    private static final By CONFIRM_ORDER_BUTTON = By.xpath("//input[@name='finish_registration']");
    private static final By FINAL_TEXT = By.xpath("//div[@class='uk-container']/p");
    private static final By ACTIVE_STEP = By.xpath("//div[@id='tm-main']");

    @И("^открываем страницу$")
    public void goToShop() {
        open(cfg.baseUrl());
        $(SHOPPING_BUTTON).click();
    }

    @И("^переходим в магазин$")
    public void goToHome() {
        $(SHOPPING_BUTTON).click();
    }

    @И("^выбирает продукт \"([^\"]*)\"$")
    public void selectProduct(String productName) {
        SelenideElement product = $$(PRODUCTS_NAME).findBy(Condition.text(productName)).parent().parent();
        product.$(BUY_BUTTON).click();
    }

    @И("^проверяем название продукта в корзине \"([^\"]*)\"$")
    public void checkProductName(String productName) {
        $(PRODUCT_NAME).shouldHave(Condition.text(productName));
    }

    @И("^нажимаем на кнопку 'оформить заказ'$")
    public void checkout() {
        $(CHECKOUT_BUTTON).click();
    }

    @И("^заполняем форму заказа$")
    public void fillOutTheOrderForm() {
        $(NAME_FIELD).sendKeys("Тест");
        $(LAST_NAME).sendKeys("Тестов");
        $(EMAIL).sendKeys("test@test.ru");
        $(STREET).sendKeys("Ибрагимова, 11");
        $(POST_CODE).sendKeys("423304");
        $(CITY).sendKeys("Казань");
        $(REGION).sendKeys("Республика Татарстан");
        $(PHONE).sendKeys("9999999999");
        $(NEXT_BUTTON).click();
    }

    @И("^указываем способ оплаты$")
    public void specifyThePaymentMethod() {
        $(ACTIVE_STEP).shouldHave(Condition.text("Способ оплаты"));
        $(NEXT_BUTTON).click();
    }

    @И("^указываем способ доставки")
    public void specifyTheDeliveryMethod() {
        $(ACTIVE_STEP).shouldHave(Condition.text("Способ доставки"));
        $(NEXT_BUTTON).click();
    }

    @И("^подтверждаем заказ$")
    public void confirmTheOrder() {
        $(CONFIRM_CHECKBOX).click();
        $(CONFIRM_ORDER_BUTTON).click();
    }

    @И("убеждаемся, что заказ отправлен")
    public void makeSureTheOrderHasBeenSent() {
        $(FINAL_TEXT).shouldHave(Condition.text("Спасибо за заказ"));
    }

    @Before
    public void openPage() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000L;
    }

    @After
    public void turnDown() {
        Selenide.closeWebDriver();
    }
}