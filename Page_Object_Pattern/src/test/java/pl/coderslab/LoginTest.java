package pl.coderslab;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {

    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        //każdy test z tej klasy będzie startował od strony logowania

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
    }

    @Test
    public void testLoginWithProperCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("michal.dobrzycki@coderslab.pl", "CodersLab");
        Assert.assertEquals("Automated Tester", loginPage.getLoggedUsername());
    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}

