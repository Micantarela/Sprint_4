package org.example.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    // Кнопка "Да все привыкли"
    public static final String ACCEPT_COOKIE_BUTTON = ".//button[@class='App_CookieButton__3cvqF' and text()='да все привыкли']";

    // Первый вопрос в разделе "Вопросы о важном"
    public static final String FIRST_IMPORTANT_QUESTION_TITLE = ".//div[@data-accordion-component='Accordion']/div[1]/div/div[@data-accordion-component='AccordionItemButton']";

    // Пятый вопрос в разделе "Вопросы о важном"
    public static final String FIFTH_IMPORTANT_QUESTION_TITLE = ".//div[@data-accordion-component='Accordion']/div[5]/div/div[@data-accordion-component='AccordionItemButton']";

    // Первый ответ на вопрос в разделе "Вопросы о важном"
    public static final String FIRST_IMPORTANT_QUESTION_ANSWER = ".//div[@data-accordion-component='Accordion']/div[1]/div[@data-accordion-component='AccordionItemPanel']/p";

    // Пятый ответ на вопрос в разделе "Вопросы о важном"
    public static final String FIFTH_IMPORTANT_QUESTION_ANSWER = ".//div[@data-accordion-component='Accordion']/div[5]/div[@data-accordion-component='AccordionItemPanel']/p";

    // Кнопка "Заказать"
    public static final String SCOOTER_ORDER_BUTTON = ".//button[@class='Button_Button__ra12g']";

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openScooterMainPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void clickToTitle(String titleLocator) {
        WebElement title = driver.findElement(By.xpath(titleLocator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", title);
        title.click();
    }

    public String getAnswerText(String answerLocator) {
        return driver.findElement(By.xpath(answerLocator)).getText();
    }

    public void acceptCookie() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(ACCEPT_COOKIE_BUTTON)));
        driver.findElement(By.xpath(ACCEPT_COOKIE_BUTTON)).click();
    }

    public void clickScooterOrderButton() {
        driver.findElement(By.xpath(SCOOTER_ORDER_BUTTON)).click();
    }
}
