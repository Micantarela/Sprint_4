package org.example.tests.scooter.order;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.page.object.AcceptancePage;
import org.example.page.object.MainPage;
import org.example.page.object.ScooterOrderAboutRentPage;
import org.example.page.object.ScooterOrderForWhomPage;
import org.junit.After;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class ScooterOrderTest {
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String subwayStationElement;
    private final String phoneNumber;
    private final String scooterRentPeriodLocator;
    private final String scooterColourLocator;
    private final String courierComment;
    private WebDriver driver;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Иван", "Иванов", "Ивановская, 10", ScooterOrderForWhomPage.FIRST_ELEMENT_SUBWAY_STATION_INPUT_FIELD, "89139139911", ScooterOrderAboutRentPage.PERIOD_DROPDOWN_ELEMENT_ONE_DAY_INPUT_FIELD, ScooterOrderAboutRentPage.SCOOTER_COLOUR_BLACK_INPUT_FIELD, "Оставьте у подъезда"},
                {"Михаил", "Михайлов", "Михайловская, 10", ScooterOrderForWhomPage.THIRD_ELEMENT_SUBWAY_STATION_INPUT_FIELD, "89139139911", ScooterOrderAboutRentPage.PERIOD_DROPDOWN_ELEMENT_THREE_DAYS_INPUT_FIELD, ScooterOrderAboutRentPage.SCOOTER_COLOUR_GRAY_INPUT_FIELD, "Оставьте у входа"},
        };
    }

    public ScooterOrderTest(String firstName, String secondName, String address, String subwayStation, String phoneNumber, String scooterRentPeriodLocator, String scooterColourLocator, String courierComment) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.subwayStationElement = subwayStation;
        this.phoneNumber = phoneNumber;
        this.scooterRentPeriodLocator = scooterRentPeriodLocator;
        this.scooterColourLocator = scooterColourLocator;
        this.courierComment = courierComment;
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

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(MainPage.ACCEPT_COOKIE_BUTTON)));
        driver.findElement(By.xpath(MainPage.ACCEPT_COOKIE_BUTTON)).click();

        driver.findElement(By.xpath(MainPage.SCOOTER_ORDER_BUTTON)).click();

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ScooterOrderForWhomPage.TITLE))));

        driver.findElement(By.xpath(ScooterOrderForWhomPage.FIRSTNAME_INPUT_FIELD)).sendKeys(firstName);
        driver.findElement(By.xpath(ScooterOrderForWhomPage.SECONDNAME_INPUT_FIELD)).sendKeys(secondName);
        driver.findElement(By.xpath(ScooterOrderForWhomPage.ADDRESS_INPUT_FIELD)).sendKeys(address);
        driver.findElement(By.xpath(ScooterOrderForWhomPage.SUBWAY_STATION_INPUT_FIELD)).click();
        driver.findElement(By.xpath(subwayStationElement)).click();

        driver.findElement(By.xpath(ScooterOrderForWhomPage.PHONE_NUMBER_INPUT_FIELD)).sendKeys(phoneNumber);

        WebElement continueButton = driver.findElement(By.xpath(ScooterOrderForWhomPage.CONTINUE_BUTTON));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", continueButton);
        continueButton.click();

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ScooterOrderAboutRentPage.TITLE))));

        driver.findElement(By.xpath(ScooterOrderAboutRentPage.DATE_INPUT_FIELD)).click();
        driver.findElement(By.xpath(ScooterOrderAboutRentPage.LAST_DATE_OF_MONTH_IN_DATEPICKER)).click();
        driver.findElement(By.xpath(ScooterOrderAboutRentPage.PERIOD_INPUT_FIELD)).click();
        driver.findElement(By.xpath(scooterRentPeriodLocator)).click();
        driver.findElement(By.xpath(scooterColourLocator)).click();
        driver.findElement(By.xpath(ScooterOrderAboutRentPage.COURIER_COMMENT_INPUT_FIELD)).sendKeys(courierComment);

        driver.findElement(By.xpath(ScooterOrderAboutRentPage.ORDER_BUTTON)).click();

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(AcceptancePage.ACCEPT_TITLE))));
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(AcceptancePage.YES_BUTTON)));

        driver.findElement(By.xpath(AcceptancePage.YES_BUTTON)).click();

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(AcceptancePage.ORDER_IS_FINISHED_TITLE))));

    }

    @After
    public void after() {
        driver.quit();
    }
}