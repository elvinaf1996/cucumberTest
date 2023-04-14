package step_definitions;

import io.cucumber.java.ru.И;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OrderFormStepsDef {

    private static final By NAME_FIELD = By.xpath("//input[@name='f_name']");
    private static final By LAST_NAME = By.xpath("//input[@name='l_name']");
    private static final By EMAIL = By.xpath("//input[@id='email']");
    private static final By STREET = By.xpath("//input[@name='street']");
    private static final By POST_CODE = By.xpath("//input[@id='zip']");
    private static final By CITY = By.xpath("//input[@name='city']");
    private static final By REGION = By.xpath("//input[@name='state']");
    private static final By PHONE = By.xpath("//input[@name='phone']");
    private static final By NEXT_BUTTON = By.xpath("//input[@value='Далее']");

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
}
