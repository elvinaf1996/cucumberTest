package step_definitions;

import io.cucumber.java.ru.И;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddressPageStepsDef {

    private final static By NAME = By.xpath("//input[@name='f_name']");
    private final static By LAST_NAME = By.xpath("//input[@name='l_name']");
    private final static By EMAIL = By.xpath("//input[@name='email']");
    private final static By STREET = By.xpath("//input[@name='street']");
    private final static By ZIP = By.xpath("//input[@name='zip']");
    private final static By CITY = By.xpath("//input[@name='city']");
    private final static By STATE = By.xpath("//input[@name='state']");
    private final static By PHONE = By.xpath("//input[@name='phone']");
    private final static By NEXT_BUTTON = By.xpath("//input[@type='submit']");

    @И("^заполнить форму$")
    public void setInfo() {
        $(NAME).sendKeys("Тест");
        $(LAST_NAME).sendKeys("Тестов");
        $(EMAIL).sendKeys("test@mail.ru");
        $(STREET).sendKeys("ул. Тестовая");
        $(ZIP).sendKeys("111111");
        $(CITY).sendKeys("Тестбург");
        $(STATE).sendKeys("Тестовый край");
        $(PHONE).sendKeys("+79999999999");
        $(NEXT_BUTTON).click();
    }
}
