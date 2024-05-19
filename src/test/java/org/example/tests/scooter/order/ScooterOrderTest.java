package org.example.tests.scooter.order;

import org.example.page.object.AcceptancePage;
import org.example.page.object.MainPage;
import org.example.page.object.ScooterOrderAboutRentPage;
import org.example.page.object.ScooterOrderForWhomPage;
import org.example.tests.BaseAutoTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ScooterOrderTest extends BaseAutoTest {
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String subwayStationElement;
    private final String phoneNumber;
    private final String scooterRentPeriodLocator;
    private final String scooterColourLocator;
    private final String courierComment;

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

    @Test
    public void test() {
        MainPage mainPage = new MainPage(driver);
        ScooterOrderForWhomPage scooterOrderForWhomPage = new ScooterOrderForWhomPage(driver);
        ScooterOrderAboutRentPage scooterOrderAboutRentPage = new ScooterOrderAboutRentPage(driver);
        AcceptancePage acceptancePage = new AcceptancePage(driver);

        mainPage.openScooterMainPage();

        mainPage.acceptCookie();

        mainPage.clickScooterOrderButton();

        scooterOrderForWhomPage.waitVisibilityOfTitle();

        scooterOrderForWhomPage.fillFirstNameInput(firstName);
        scooterOrderForWhomPage.fillSecondNameInput(secondName);
        scooterOrderForWhomPage.fillAddressInput(address);
        scooterOrderForWhomPage.chooseSubwayStation(subwayStationElement);
        scooterOrderForWhomPage.filPhoneNumberInput(phoneNumber);

        scooterOrderForWhomPage.clickContinueButton();

        scooterOrderAboutRentPage.waitVisibilityOfTitle();

        scooterOrderAboutRentPage.chooseLastDateInMonth();
        scooterOrderAboutRentPage.choosePeriod(scooterRentPeriodLocator);
        scooterOrderAboutRentPage.chooseColour(scooterColourLocator);
        scooterOrderAboutRentPage.fillCourierCommentInput(courierComment);

        scooterOrderAboutRentPage.clickOrderButton();

        acceptancePage.waitVisibilityOfAcceptTitle();

        acceptancePage.waitVisibilityOfYesButton();

        acceptancePage.clickYesButton();

        acceptancePage.waitVisibilityOfSuccessTitle();
    }

}