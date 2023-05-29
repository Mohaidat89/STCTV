package Pages;

import Core.Helpers.ActionHelper;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class SubscribePage {
    public SubscribePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//strong[@id='name-lite']")
    private WebElement litePackageTitle;
    @FindBy(xpath = "//strong[@id='name-classic']")
    private WebElement classicPackageTitle;
    @FindBy(xpath = "//strong[@id='name-premium']")
    private WebElement premiumPackageTitle;

    @FindBy(xpath = "//div[@id='currency-lite']/b")
    private WebElement litePackagePrice;
    @FindBy(xpath = "//div[@id='currency-lite']/i")
    private WebElement litePackageCurrency;

    @FindBy(xpath = "//div[@id='currency-classic']/b")
    private WebElement classicPackagePrice;
    @FindBy(xpath = "//div[@id='currency-classic']/i")
    private WebElement classicPackageCurrency;

    @FindBy(xpath = "//div[@id='currency-premium']/b")
    private WebElement premiumPackagePrice;
    @FindBy(xpath = "//div[@id='currency-premium']/i")
    private WebElement premiumPackageCurrency;

}
