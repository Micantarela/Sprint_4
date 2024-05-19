package org.example.tests.important.questions;

import org.example.page.object.MainPage;
import org.example.tests.BaseAutoTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@RunWith(Parameterized.class)
public class ImportantQuestionTest extends BaseAutoTest {
    private String titleLocator;
    private String answerLocator;
    private String expectedText;


    public ImportantQuestionTest(String titleLocator, String answerLocator, String expectedText) {
        this.titleLocator = titleLocator;
        this.answerLocator = answerLocator;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {MainPage.FIRST_IMPORTANT_QUESTION_TITLE, MainPage.FIRST_IMPORTANT_QUESTION_ANSWER, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {MainPage.FIFTH_IMPORTANT_QUESTION_TITLE, MainPage.FIFTH_IMPORTANT_QUESTION_ANSWER, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
        };
    }

    @Test
    public void test() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openScooterMainPage();

        mainPage.clickToTitle(titleLocator);

        String answerText = mainPage.getAnswerText(answerLocator);
        Assert.assertEquals(expectedText, answerText);
    }

}
