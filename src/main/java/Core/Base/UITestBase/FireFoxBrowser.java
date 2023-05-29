package Core.Base.UITestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;

public class FireFoxBrowser implements Browser {
    public FireFoxBrowser() {

    }

    @Override
    public WebDriver getDriver(String browser, String machineOS, boolean headlessMode) {
        WebDriver driver = null;
        try {
            FirefoxOptions options = new FirefoxOptions();
            options.setAcceptInsecureCerts(true);
            if (headlessMode){
                options.addArguments("--headless");
            }
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);
            if (headlessMode) {
                Dimension targetSize = new Dimension(1920, 1080);
                driver.manage().window().setSize(targetSize);
            }
        } catch (Throwable e) {
            e.printStackTrace(System.out);
            Assert.fail("Please check Browser is exist Browser Unable to start");
        }

        WebDriverManager.firefoxdriver().setup();
        driver.manage().window().maximize();
        return driver;
    }
}
