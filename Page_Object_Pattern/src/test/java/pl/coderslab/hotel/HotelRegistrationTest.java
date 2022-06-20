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
import pl.coderslab.hotel.page.RegistrationPage;

import java.time.Duration;

public class HotelRegistrationTest {
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
    public void testLoginWithProperCredentials() {
        MainPage mainPage = new MainPage(driver);
        mainPage.signIn();

        AuthPage authPage = new AuthPage(driver);
        authPage.enterNewUserEmail(generateUniqueEmail());

        String firstname = "John";    //lokalna zmienna przyda się na później
        RegistrationPage regPage = new RegistrationPage(driver);
        regPage.enterRequiredUserData(firstname, "Doe", "secretpass");

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.successMessageIsVisible());
        Assert.assertEquals("Your account has been created.", myAccountPage.getSuccessMessage());
        Assert.assertEquals(firstname, myAccountPage.getUserName());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private static String generateUniqueEmail() {
        return "art" + System.currentTimeMillis() + "@random.com";
    }
}


