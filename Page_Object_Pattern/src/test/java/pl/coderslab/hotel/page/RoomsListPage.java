package pl.coderslab.hotel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * weryfikacja wyników wyszukiwania z zadania 2
 */


public class RoomsListPage {
    private WebDriver driver;
    public RoomsListPage(WebDriver driver){
        this.driver = driver;
        }

    public String getHotelName() {
        return driver.findElement(By.className("hotel_cat_id_btn")).getText();
    }

    public String getCheckInTime() {
        return driver.findElement(By.id("check_in_time")).getAttribute("value");
    }

    public String getCheckOutTime() {
        return driver.findElement(By.id("check_out_time")).getAttribute("value");
    }

    public boolean areRoomsFound() {
    return !driver.findElements(By.className("room_cont")).isEmpty();
    }
}
