package Core.Base.UITestBase;

import Core.Base.TestDataBase.TestDataBase;
import Core.Report.WebTestListener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners({WebTestListener.class})
public class UiTestBase extends TestDataBase {

    private static String machineOS = OsValidator.getDeviceOS();
    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(@Optional("optional") String browser, ITestContext context) {
        if (browser.equalsIgnoreCase("optional")) {
            driver = getDriver(this.browser);
        } else {
            driver = getDriver(browser);
        }
        driver.get(baseUrl);
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass(enabled = true)
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
            }
        }
    }

    public WebDriver getDriver(String browser) {
        WebDriver driver = null;
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeBrowser chromeBrowser = new ChromeBrowser();
                driver = chromeBrowser.getDriver(browser, machineOS, headlessMode);
                break;
            case "firefox":
                FireFoxBrowser fireFoxBrowser = new FireFoxBrowser();
                driver = fireFoxBrowser.getDriver(browser, machineOS, headlessMode);
                break;
            case "edge":
                EdgeBrowser edgeBrowser = new EdgeBrowser();
                driver = edgeBrowser.getDriver(browser, machineOS, headlessMode);
        }
        return driver;
    }

}
