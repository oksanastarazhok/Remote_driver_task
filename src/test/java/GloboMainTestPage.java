import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GloboMainTestPage {

    @Parameters({"browserName","osName"})
    @Test
    public void test( String browser, String platform) throws MalformedURLException {
        String browserName = System.getProperty("browserName");
        String osName = System.getProperty("osName");

        System.out.println(browserName);
        System.out.println(osName);



        DesiredCapabilities cap = new DesiredCapabilities();
        if (browserName.equalsIgnoreCase("chrome")) {
            cap.setBrowserName("chrome");
            cap.setPlatform(Platform.fromString(platform));

        } else if (browserName.equalsIgnoreCase("firefox")) {
            cap.setBrowserName("firefox");
            cap.setPlatform(Platform.fromString(platform));
        } else if (browserName.equalsIgnoreCase("opera")) {

            System.setProperty("webdriver.chrome.driver", "operadriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files\\Opera\\54.0.2952.41\\opera.exe");
            cap.setCapability(ChromeOptions.CAPABILITY, options);

        }

        URL url = new URL("http://10.6.126.55:4444/wd/hub");
        WebDriver driver = new RemoteWebDriver(url, cap);
        driver.get("https://www.globoforce.com/");
        Assert.assertEquals(driver.getTitle(), "Globoforce | Elevate Workplace Culture and Performance | Globoforce");
        driver.quit();
    }

}
