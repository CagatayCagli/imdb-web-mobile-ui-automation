package tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;


public class ImdbMobileSearchTest {
    private AndroidDriver<MobileElement> mobileDriver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_7_API_32");
        caps.setCapability("platformName", "Android");
        caps.setCapability("browserName", "Chrome");

        // Appium server URL (start Appium server before running the test)
        String appiumServerURL = "http://localhost:4723/wd/hub";

        mobileDriver = new AndroidDriver<>(new URL(appiumServerURL), caps);
    }

    @Test
    public void testSearchOnMobile() {
        mobileDriver.get("https://www.imdb.com/");
        MobileElement searchBox = mobileDriver.findElement(MobileBy.id("suggestion-search"));
        searchBox.sendKeys("Dövüş Kulübü");
        searchBox.submit();

        // Continue with your test steps for mobile browser
    }

    @AfterMethod
    public void tearDown() {
        if (mobileDriver != null) {
            mobileDriver.quit();
        }
    }
}
