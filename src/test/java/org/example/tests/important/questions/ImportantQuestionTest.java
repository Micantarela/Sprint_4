package org.example.tests.important.questions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.page.object.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class ImportantQuestionTest {
    private String titleLocator;
    private String textLocator;
    private String expectedText;
    private WebDriver driver;

    public ImportantQuestionTest(String titleLocator, String textLocator, String expectedText) {
        this.titleLocator = titleLocator;
        this.textLocator = textLocator;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {MainPage.FIRST_IMPORTANT_QUESTION_TITLE, MainPage.FIRST_IMPORTANT_QUESTION_ANSWER, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {MainPage.FIFTH_IMPORTANT_QUESTION_TITLE, MainPage.FIFTH_IMPORTANT_QUESTION_ANSWER, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\PC\\Desktop/geckodriver.exe");
//        driver = new FirefoxDriver();
    }

    @Test
    public void test() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        WebElement title = driver.findElement(By.xpath(titleLocator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", title);
        title.click();

        WebElement text = driver.findElement(By.xpath(textLocator));
        Assert.assertEquals(expectedText, text.getText());
    }

    @After
    public void after() {
        driver.quit();
    }
}
