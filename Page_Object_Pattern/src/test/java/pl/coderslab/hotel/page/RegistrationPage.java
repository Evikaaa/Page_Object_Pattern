package pl.coderslab.hotel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;

public class RegistrationPage {

    private WebDriver driver;
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterRequiredUserData(String name, String lastname, String passwd) {
        WebElement nameInput = driver.findElement(By.id("customer_firstname"));
        nameInput.clear();
        nameInput.sendKeys(name);

        WebElement lastnameInput = driver.findElement(By.id("customer_lastname"));
        lastnameInput.clear();
        lastnameInput.sendKeys(lastname);

        WebElement passwdInput = driver.findElement(By.id("passwd"));
        passwdInput.clear();
        passwdInput.sendKeys(passwd);

        driver.findElement(By.id("submitAccount")).click();
    }
}
