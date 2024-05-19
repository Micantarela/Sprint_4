package org.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseAutoTest {

    protected WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\PC\\Desktop/geckodriver.exe");
//        driver = new FirefoxDriver();
    }

    @After
    public void after() {
        driver.quit();
    }
}
