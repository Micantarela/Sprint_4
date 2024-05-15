package org.example.page.object;

public class ScooterOrderForWhomPage {

    // Заголовок формы
    public static final String TITLE = ".//div[@class='Order_Header__BZXOb' and text()='Для кого самокат']";

    // Поле для ввода: Имя
    public static final String FIRSTNAME_INPUT_FIELD = ".//div[@class='Order_Form__17u6u']/div[1]/input";

    // Поле для ввода: Фамилия
    public static final String SECONDNAME_INPUT_FIELD = ".//div[@class='Order_Form__17u6u']/div[2]/input";

    // Поле для ввода: Адрес: куда привезти заказ
    public static final String ADDRESS_INPUT_FIELD = ".//div[@class='Order_Form__17u6u']/div[3]/input";

    // Поле для ввода: Станция метро
    public static final String SUBWAY_STATION_INPUT_FIELD = ".//div[@class='Order_Form__17u6u']/div[4]/div/div/input";

    // Первый элемент в выпадающем списке поля "Станция метро"
    public static final String FIRST_ELEMENT_SUBWAY_STATION_INPUT_FIELD = ".//div[@class='Order_Form__17u6u']/div[4]/div/div[@class='select-search__select']/ul/li[1]/button";

    // Третий элемент в выпадающем списке поля "Станция метро"
    public static final String THIRD_ELEMENT_SUBWAY_STATION_INPUT_FIELD = ".//div[@class='Order_Form__17u6u']/div[4]/div/div[@class='select-search__select']/ul/li[3]/button";

    // Поле для ввода: Телефон: на него позвонит курьер
    public static final String PHONE_NUMBER_INPUT_FIELD = ".//div[@class='Order_Form__17u6u']/div[5]/input";

    // Кнопка "Далее" внизу экрана
    public static final String CONTINUE_BUTTON = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']";

}
