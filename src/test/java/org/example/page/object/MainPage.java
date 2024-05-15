package org.example.page.object;

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
}
