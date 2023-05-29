package Core.Base.UITestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class EdgeBrowser implements Browser {

    @Override
    public WebDriver getDriver(String machineOS, String browser, boolean headlessMode) {
        WebDriver driver = null;
        try {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } catch (Throwable e) {
            e.printStackTrace(System.out);
            Assert.fail("Please check Browser is exist Browser Unable to start");
        }
        driver.manage().window().maximize();
        return driver;
    }
}
