package pl.coderslab.hotel;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.hotel.page.AuthPage;
import pl.coderslab.hotel.page.MainPage;
import pl.coderslab.hotel.page.MyAccountPage;
import pl.coderslab.hotel.page.RoomsListPage;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HotelRoomsSearchTest {

    private static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-uuuu");
    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void searchAvailableRooms(){
        MainPage mainPage = new MainPage(driver);
        AuthPage authPage = mainPage.singInWithObject();

        authPage.loginAs("hohnd@tescik.com", "secretpass");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.returnHome();

        String hotelName = "The Hotel Prime";
        String checkInDate = LocalDate.now().format(DATE_FORMATTER);
        String checkOutDate = LocalDate.now().plusDays(1).format(DATE_FORMATTER);

        mainPage.enterSearchDetails(hotelName, checkInDate, checkOutDate);

        RoomsListPage roomsListPage = new RoomsListPage(driver);
        Assert.assertEquals(hotelName, roomsListPage.getHotelName());
        Assert.assertEquals(checkInDate, roomsListPage.getCheckInTime());
        Assert.assertEquals(checkOutDate, roomsListPage.getCheckOutTime());
        Assert.assertTrue(roomsListPage.areRoomsFound());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
