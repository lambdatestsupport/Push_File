import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

public class vanilla_ios {

    public static String userName = "sandhyas";
    public static String accessKey = "Zxv9DJUj23o5R0lwZZIPbDkrmTw4Jny5JVBRg2IOzrynXhYQDH";

    public static final String URL = "https://" + userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub";
    public static IOSDriver driver = null;

    public static void main(String[] args) throws Exception {

        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformVersion", "15");
            caps.setCapability("deviceName", "iPhone 12");
            caps.setCapability("isRealMobile", true);
            caps.setCapability("app", "lt://APP10160211631694089754866973"); // Enter your app url
            caps.setCapability("platformName", "iOS");
            caps.setCapability("build", "Java Vanilla - iOS");
            caps.setCapability("name", "Sample Test Java");
            caps.setCapability("devicelog", true);
            caps.setCapability("network", false);

            driver = new IOSDriver(
                    new URL("https://" + userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"),
                    caps);

            Thread.sleep(2000);
            // Push file
            driver.pushFile("@com.koombea.LunaTherapist-Stag:documents/sample-image.jpg", new File("C:/Users/sandhyas/Pictures/Screenshots/Screenshot 2023-09-06 135203.png"));
// Pull file
            byte[] fileBase64 = driver.pullFile("@com.koombea.LunaTherapist-Stag:documents/sample-image.jpg");

            // Changes color

            driver.findElement(MobileBy.id("color")).click();
            Thread.sleep(1000);

            // Back to black color
            driver.navigate().back();

            Thread.sleep(1000);

            // Changes the text to proverbial
            driver.findElement(MobileBy.id("Text")).click();
            Thread.sleep(1000);

            // toast is visible
            driver.findElement(MobileBy.id("toast")).click();
            Thread.sleep(1000);

            // notification is visible
            driver.findElement(MobileBy.id("notification")).click();
            Thread.sleep(2000);

            // Open the geolocation page
            driver.findElement(MobileBy.id("geoLocation")).click();
            Thread.sleep(4000);
            driver.navigate().back();
            Thread.sleep(1000);

            // Takes to speed test page
            driver.findElement(MobileBy.id("speedTest")).click();
            Thread.sleep(5000);
            driver.navigate().back();
            Thread.sleep(1000);

            // Opens the browser
            MobileElement browser = (MobileElement) driver.findElementByAccessibilityId("Browser");
            browser.click();
            Thread.sleep(3000);

            WebDriverWait el7 = new WebDriverWait(driver, 30);
            el7.until(ExpectedConditions.elementToBeClickable(MobileBy.id("url")));
            driver.findElementById("url").sendKeys("https://www.lambdatest.com/");

            // Clicks on the text box
            WebDriverWait el = new WebDriverWait(driver, 90);
            MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("find");
            el.until(ExpectedConditions.elementToBeClickable(el4));
            el4.click();
            el4.sendKeys("Lambdatest");

            // ((JavascriptExecutor) driver).executeScript("lambda-status=passed");
            driver.quit();

        } catch (Exception t) {
            System.out.println(t);
            driver.quit();

        }
    }
}