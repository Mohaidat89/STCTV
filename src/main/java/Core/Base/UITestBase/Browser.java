package Core.Base.UITestBase;

import org.openqa.selenium.WebDriver;

public interface Browser {
     WebDriver getDriver(String machineOS, String browser, boolean headlessMode);
}
