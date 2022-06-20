package pl.coderslab.hotel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    private static final String ALERT_SELECTOR = "alert-success";
    private WebDriver driver;

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
    }
    //weryfikacja asercji, imienia, alertu w nagłówku, tekst w alercie

    //metody do asercji nie będą void, bo będą zwracać typ
    public String getUserName(){
        return driver.findElement(By.className("account_user_name")).getText();
        }

    //sprawdzamy czy alert jest widoczny i czy teskt jest taki jak chcemy, metoda prawda/fałsz
    public boolean successMessageIsVisible() {
        return driver.findElement(By.className(ALERT_SELECTOR)).isDisplayed();
    }

    //sprawdzamy czy teskt alertu jest taki jak chcemy, metoda prawda/fałsz
    public String getSuccessMessage() {
        return driver.findElement(By.className(ALERT_SELECTOR)).getText();
    }

    //kolejne zadanie 2
    public void returnHome(){
        driver.findElement(By.className("logo")).click();
    }
}
