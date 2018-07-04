import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GloboMainPage {

    @Test
    @Parameters({"browser", "platform"})

/**
 * Works only in Firefox and Chrome.
 */
    public void test(@Optional("firefox") String browser, String platform) throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        if (browser.equalsIgnoreCase("chrome")) {
            cap.setBrowserName("chrome");
            cap.setPlatform(Platform.fromString(platform));

        } else if (browser.equalsIgnoreCase("firefox")) {
            cap.setBrowserName("firefox");
            cap.setPlatform(Platform.fromString(platform));
        } else if (browser.equalsIgnoreCase("opera")) {

            System.setProperty("webdriver.chrome.driver", "operadriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files\\Opera\\54.0.2952.41\\opera.exe");
            cap.setCapability(ChromeOptions.CAPABILITY, options);

//            cap.setBrowserName("opera");
//            cap.setPlatform(Platform.fromString(platform));
        }


        URL url = new URL("http://10.6.126.55:4444/wd/hub");
        WebDriver driver = new RemoteWebDriver(url, cap);
        driver.get("https://www.globoforce.com/");
        Assert.assertEquals(driver.getTitle(), "Globoforce | Elevate Workplace Culture and Performance | Globoforce");
        driver.quit();
    }

}
