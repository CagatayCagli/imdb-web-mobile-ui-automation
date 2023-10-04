package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImdbHomePage {
    private WebDriver driver;

    public ImdbHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.imdb.com/");
    }

    public void searchFor(String query) {
        WebElement searchBox = driver.findElement(By.id("suggestion-search"));
        searchBox.sendKeys(query);
        searchBox.submit();
    }

    public int waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000); // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return seconds;
    }
}