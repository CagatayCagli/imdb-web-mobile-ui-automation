package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.xml.xpath.XPath;

public class ImdbSearchResultPage {
    private WebDriver driver;

    public ImdbSearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSearchResultPresent(String query) {
        WebElement searchResult = driver.findElement(By.className("ipc-metadata-list-summary-item__t"));
        return searchResult.isDisplayed();
    }
}