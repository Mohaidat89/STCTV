package Core.Base.UITestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class ChromeBrowser implements Browser {

    @Override
    public WebDriver getDriver(String browser, String machineOS, boolean headlessMode) {
        WebDriver driver = null;
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-web-security");
            options.addArguments("--allow-running-insecure-content");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("enable-automation");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            options.setAcceptInsecureCerts(true);
            options.addArguments("--remote-allow-origins=*");
            if (headlessMode){
                options.addArguments("--proxy-bypass-list=*");
                options.addArguments("--headless");
            }
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            if (headlessMode) {
                Dimension targetSize = new Dimension(1920, 1080);
                driver.manage().window().setSize(targetSize);
            }
        } catch (Throwable e) {
            e.printStackTrace(System.out);
            Assert.fail("Please check Browser is exist Browser Unable to start");
        }
        driver.manage().window().maximize();
        return driver;
    }
}
