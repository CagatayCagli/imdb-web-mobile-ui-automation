package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ImdbHomePage;
import pages.ImdbSearchResultPage;

import java.util.concurrent.TimeUnit;

public class ImdbDesktopSearchTest {
    private WebDriver driver;
    private ImdbHomePage imdbHomePage;
    private ImdbSearchResultPage searchResultsPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\Downloads\\Compressed\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        imdbHomePage = new ImdbHomePage(driver);
        searchResultsPage = new ImdbSearchResultPage(driver);
    }

    @Test
    public void testSearchOnDesktop() {
        imdbHomePage.open();
        imdbHomePage.searchFor("Dövüş Kulübü");
        imdbHomePage.waitForSeconds(2);
        Assert.assertTrue(searchResultsPage.isSearchResultPresent("Dövüş Kulübü"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}