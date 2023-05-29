import Core.Base.UITestBase.UiTestBase;
import Core.Helpers.ActionHelper;
import Pages.SubscribePage;
import org.testng.annotations.Test;

public class SubscribeTest extends UiTestBase {
    ActionHelper action = new ActionHelper();
    SubscribePage subscribe;

    @Test(description = "TC001 Verify lite package subscription price ", priority = 1)
    public void verifyLitePackagePrice() {
        subscribe = new SubscribePage(driver);

        action.waitForExistence(subscribe.getLitePackageTitle(), "Lite Package Title", driver);
        action.waitForExistence(subscribe.getLitePackagePrice(), "Lite Package Price", driver);
        action.verifyResult(
                subscribe.getLitePackagePrice().getText(),
                "Lite package price should be 2.7 USD",
                subscribe.getLitePackagePrice().getText().equalsIgnoreCase("2.7")
        );
    }

    @Test(description = "TC002 Verify lite package subscription currency ", priority = 2)
    public void verifyLitePackageCurrency() {
        subscribe = new SubscribePage(driver);

        action.waitForExistence(subscribe.getLitePackageTitle(), "Lite Package Title", driver);
        action.waitForExistence(subscribe.getLitePackageCurrency(), "Lite Package Currency", driver);
        action.verifyResult(
                subscribe.getLitePackageCurrency().getText(),
                "Lite package currency should be USD",
                subscribe.getLitePackageCurrency().getText().contains("USD")
        );
    }

    @Test(description = "TC003 Verify classic package subscription price ", priority = 3)
    public void verifyClassicPackagePrice() {
        subscribe = new SubscribePage(driver);

        action.waitForExistence(subscribe.getClassicPackageTitle(), "Classic Package Title", driver);
        action.waitForExistence(subscribe.getClassicPackagePrice(), "Classic Package Price", driver);
        action.verifyResult(
                subscribe.getClassicPackagePrice().getText(),
                "Classic package price should be 5.2 USD",
                subscribe.getClassicPackagePrice().getText().equalsIgnoreCase("5.2")
        );
    }

    @Test(description = "TC004 Verify classic package subscription currency ", priority = 4)
    public void verifyClassicPackageCurrency() {
        subscribe = new SubscribePage(driver);

        action.waitForExistence(subscribe.getClassicPackageTitle(), "Classic Package Title", driver);
        action.waitForExistence(subscribe.getClassicPackageCurrency(), "Classic Package Currency", driver);
        action.verifyResult(
                subscribe.getClassicPackageCurrency().getText(),
                "Classic package currency should be USD",
                subscribe.getClassicPackageCurrency().getText().contains("USD")
        );
    }

    @Test(description = "TC005 Verify premium package subscription price ", priority = 3)
    public void verifyPremiumPackagePrice() {
        subscribe = new SubscribePage(driver);

        action.waitForExistence(subscribe.getPremiumPackageTitle(), "Premium Package Title", driver);
        action.waitForExistence(subscribe.getPremiumPackagePrice(), "Premium Package Price", driver);
        action.verifyResult(
                subscribe.getPremiumPackagePrice().getText(),
                "Classic package price should be 8 USD",
                subscribe.getPremiumPackagePrice().getText().equalsIgnoreCase("8")
        );
    }

    @Test(description = "TC006 Verify premium package subscription currency ", priority = 4)
    public void verifyPremiumPackageCurrency() {
        subscribe = new SubscribePage(driver);

        action.waitForExistence(subscribe.getPremiumPackageTitle(), "Premium Package Title", driver);
        action.waitForExistence(subscribe.getPremiumPackageCurrency(), "Premium Package Currency", driver);
        action.verifyResult(
                subscribe.getPremiumPackageCurrency().getText(),
                "Classic package currency should be USD",
                subscribe.getPremiumPackageCurrency().getText().contains("USD")
        );
    }
}
