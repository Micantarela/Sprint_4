package org.example.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScooterOrderAboutRentPage {

    // Заголовок формы
    public static final String TITLE = ".//div[@class='Order_Header__BZXOb' and text()='Про аренду']";

    // Поле для ввода: Когда привезти самокат
    public static final String DATE_INPUT_FIELD = ".//div[@class='Order_Form__17u6u']/div[1]/div/div/input";

    // Последний день в календаре в поле "Когда привезти самокат"
    public static final String LAST_DATE_OF_MONTH_IN_DATEPICKER = ".//div[@class='Order_Form__17u6u']/div[1]/div[@class='react-datepicker__tab-loop']/div[@class='react-datepicker-popper']/div/div/div[@class='react-datepicker__month-container']/div[@class='react-datepicker__month']/div[last()]/div[last()]";

    // Поле для ввода: Срок аренды
    public static final String PERIOD_INPUT_FIELD = ".//div[@class='Order_Form__17u6u']/div[2]/div[@class='Dropdown-control']";

    // Поле для выбора: Срок аренды: сутки
    public static final String PERIOD_DROPDOWN_ELEMENT_ONE_DAY_INPUT_FIELD = ".//div[@class='Order_Form__17u6u']/div[2]/div[@class='Dropdown-menu']/div[1]";

    // Поле для выбора: Срок аренды: трое суток
    public static final String PERIOD_DROPDOWN_ELEMENT_THREE_DAYS_INPUT_FIELD = ".//div[@class='Order_Form__17u6u']/div[2]/div[@class='Dropdown-menu']/div[3]";

    // Поле для ввода: Цвет самоката: чёрный жемчуг
    public static final String SCOOTER_COLOUR_BLACK_INPUT_FIELD = ".//div[@class='Order_Checkboxes__3lWSI']/label[@for='black']";

    // Поле для ввода: Цвет самоката: серая безысходность
    public static final String SCOOTER_COLOUR_GRAY_INPUT_FIELD = ".//div[@class='Order_Checkboxes__3lWSI']/label[@for='grey']";

    // Поле для ввода: Комментарий для курьера
    public static final String COURIER_COMMENT_INPUT_FIELD = ".//div[@class='Order_Form__17u6u']/div[4]/input";

    // Кнопка Заказать внизу экрана
    public static final String ORDER_BUTTON = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']";


    private final WebDriver driver;

    public ScooterOrderAboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitVisibilityOfTitle() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(TITLE))));
    }

    public void chooseLastDateInMonth() {
        driver.findElement(By.xpath(DATE_INPUT_FIELD)).click();
        driver.findElement(By.xpath(LAST_DATE_OF_MONTH_IN_DATEPICKER)).click();
    }

    public void choosePeriod(String scooterRentPeriodLocator) {
        driver.findElement(By.xpath(PERIOD_INPUT_FIELD)).click();
        driver.findElement(By.xpath(scooterRentPeriodLocator)).click();
    }

    public void chooseColour(String scooterColourLocator) {
        driver.findElement(By.xpath(scooterColourLocator)).click();
    }

    public void fillCourierCommentInput(String courierComment) {
        driver.findElement(By.xpath(COURIER_COMMENT_INPUT_FIELD)).sendKeys(courierComment);
    }

    public void clickOrderButton() {
        driver.findElement(By.xpath(ORDER_BUTTON)).click();
    }
}
