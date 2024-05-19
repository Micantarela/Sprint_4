package org.example.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcceptancePage {

    // Заголовок модального окна "Хотите оформить заказ?"
    public static final String ACCEPT_TITLE = ".//div[@class='Order_ModalHeader__3FDaJ' and text()='Хотите оформить заказ?']";

    // Кнопка "Да" на форме "Хотите оформить заказ?"
    public static final String YES_BUTTON = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']";

    // Заголовок "Заказ успешно оформлен"
    public static final String ORDER_IS_FINISHED_TITLE = ".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']";

    private final WebDriver driver;

    public AcceptancePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitVisibilityOfAcceptTitle() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ACCEPT_TITLE))));
    }

    public void waitVisibilityOfYesButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(YES_BUTTON)));
    }

    public void clickYesButton() {
        driver.findElement(By.xpath(YES_BUTTON)).click();
    }

    public void waitVisibilityOfSuccessTitle() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ORDER_IS_FINISHED_TITLE))));
    }
}
