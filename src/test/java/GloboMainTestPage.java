import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GloboMainTestPage {
    private WebDriver driver;

    @Parameters({"browserName", "osName"})
    @BeforeTest(alwaysRun = true)
    //define configuration variables
    public void setup(String browser, String platform) throws MalformedURLException {
        String browserName = System.getProperty("browserName");
        String osName = System.getProperty("osName");

        System.out.println(browserName);
        System.out.println(osName);


        DesiredCapabilities cap = new DesiredCapabilities();
        //Browsers
        if (browserName.equalsIgnoreCase("chrome")) {
            cap.setBrowserName("chrome");


        } else if (browserName.equalsIgnoreCase("firefox")) {
            cap.setBrowserName("firefox");

        } else if (browserName.equalsIgnoreCase("opera")) {

            System.setProperty("webdriver.chrome.driver", "operadriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files\\Opera\\54.0.2952.41\\opera.exe");
            cap.setCapability(ChromeOptions.CAPABILITY, options);

        }
        //Platform
        if (osName.equalsIgnoreCase("windows")) {
            cap.setPlatform(Platform.WINDOWS);
        } else {
            cap.setPlatform(Platform.LINUX);
        }

        //initiate hub's driver
        URL url = new URL("http://10.6.126.55:4444/wd/hub");
        driver = new RemoteWebDriver(url, cap);

    }

    @Test
    public void test() {
        //Open webpage
        driver.get("https://www.globoforce.com/");
        //Verify we are on the correct page
        Assert.assertEquals(driver.getTitle(), "Globoforce | Elevate Workplace Culture and Performance | Globoforce");
        driver.quit();
    }

}
