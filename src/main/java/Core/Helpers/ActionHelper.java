package Core.Helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class ActionHelper {
    private long defaultWaitTime;
    int waitTime;

    public ActionHelper() {
        Map testConfig = ReadWriteHelper.getDataFromJson("src/main/java/config/testConfig.json");
        Map envConfig = (Map) testConfig.get("env_config");
        defaultWaitTime = (long) envConfig.get("defaultWaitTime");
        waitTime = (int) defaultWaitTime;
    }

    public void sleepBySeconds(Integer timeWait) {
        try {
            Thread.sleep(timeWait * 1000);
        } catch (Exception e) {
        }
    }

    public void highlightElement(WebElement element, WebDriver driver) {
        try {
            if (element.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
            }
        } catch (Exception e) {
        }
    }

    public void selectByIndex(WebElement element, int index) {
        if (element == null) {
            return;
        }
        try {
            Select selector = new Select(element);
            selector.selectByIndex(index);
        } catch (Exception e) {
        }
    }

    public void scrollTo(WebElement element, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebElement findElement(WebDriver driver, String locator, String selector) {
        WebElement element = null;

        try {
            switch (locator) {
                case "id":
                    element = driver.findElement(By.id(selector));
                    break;
                case "name":
                    element = driver.findElement(By.name(selector));
                    break;
                case "class":
                    element = driver.findElement(By.className(selector));
                    break;
                case "xpath":
                    element = driver.findElement(By.xpath(selector));
            }
        } catch (Exception e) {
        }
        highlightElement(element, driver);
        return element;
    }

    public boolean waitForExistence(WebElement element, String elementName, int nTimes, WebDriver driver) {
        boolean isExist = false;
        int count = 1;
        while (count <= nTimes) {
            try {
                //don't sleep the first try
                if (count > 1) {
                    Thread.sleep(1000);
                }
                if (element.isDisplayed()) {
                    highlightElement(element, driver);
                    isExist = true;
                    break;
                }
            } catch (Exception e) {
            }
            count++;
        }
        verifyResult(
                "<b><font color=red>" + elementName + "</b> - not found!</font>",
                "<font color=green>User should be able to find <b>" + elementName + "</b></font>",
                isExist
        );
        return isExist;
    }

    public boolean waitForExistence(WebElement element, WebDriver driver) {
        boolean isExist = false;
        int count = 1;
        while (count <= waitTime) {
            try {
                //don't sleep the first try
                if (count > 1) {
                    Thread.sleep(1000);
                }
                if (element.isDisplayed()) {
                    highlightElement(element, driver);
                    isExist = true;
                    break;
                }
            } catch (Exception e) {
            }
            count++;
        }
        return isExist;
    }

    public boolean waitForExistence(WebElement element, int nTimes, WebDriver driver) {
        boolean isExist = false;
        int count = 1;
        while (count <= nTimes) {
            try {
                //don't sleep the first try
                if (count > 1) {
                    Thread.sleep(1000);
                }
                if (element.isDisplayed()) {
                    highlightElement(element, driver);
                    isExist = true;
                    break;
                }
            } catch (Exception e) {
            }
            count++;
        }
        return isExist;
    }

    public boolean waitForExistence(WebElement element, String elementName, WebDriver driver) {
        boolean isExist = waitForExistence(element, elementName, waitTime, driver);
        return isExist;
    }

    public boolean waitForListExistence(List<WebElement> element, String elementName, int seconds, WebDriver driver) {
        boolean isExist = false;
        int count = 1;
        while (count <= seconds) {
            try {
                Thread.sleep(1000);
                if (element.size() != 0 || element.get(count).isDisplayed() && element.get(count).isEnabled()) {
                    isExist = true;
                    highlightElement(element.get(count), driver);
                    break;
                }
            } catch (Exception e) {
            }
            count++;
        }
        verifyResult(elementName + " element not found!", "User will be able to find the element!", isExist);
        return isExist;
    }

    public boolean waitForListExistence(List<WebElement> element, int seconds, WebDriver driver) {
        boolean isExist = false;
        int count = 1;
        while (count <= seconds) {
            try {
                Thread.sleep(1000);
                if (element.size() != 0 || element.get(count).isDisplayed() && element.get(count).isEnabled()) {
                    isExist = true;
                    highlightElement(element.get(count), driver);
                    break;
                }
            } catch (Exception e) {
            }
            count++;
        }
        return isExist;
    }

    public boolean waitForListExistence(List<WebElement> element, WebDriver driver) {
        boolean isExist = false;
        int count = 1;
        while (count <= waitTime) {
            try {
                Thread.sleep(1000);
                if (element.size() != 0 || element.get(count).isDisplayed() && element.get(count).isEnabled()) {
                    isExist = true;
                    highlightElement(element.get(count), driver);
                    break;
                }
            } catch (Exception e) {
            }
            count++;
        }
        return isExist;
    }

    public void sendTextByJSEx(String locator, String value, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('" + locator + "').value='" + value + "';");
    }

    public void select(WebElement element, String text) {
        if (element == null) {
            return;
        }
        for (int i = 0; i < 10; i++) {
            try {
                Select selector = new Select(element);
                int index = 0;
                for (WebElement option : selector.getOptions()) {
                    if (option.getText().equalsIgnoreCase(text))
                        break;
                    index++;
                }
                selector.selectByIndex(index);
                break;
            } catch (Exception e) {
                continue;
            }
        }
    }

    public void scrollDownWebPage(WebDriver driver) {
        try {
            int topY = driver.manage().window().getSize().height / 2;
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scrollBy(0, " + topY + ");");
            Thread.sleep(1500);
        } catch (Exception e) {
        }
    }

    public void scrollToElement(WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickElement(WebElement element) {
        for (int i = 0; i < 60; i++) {
            try {
                Thread.sleep(500);
                element.click();
                break;
            } catch (ElementClickInterceptedException e) {
                continue;
            } catch (StaleElementReferenceException e) {
                continue;
            } catch (ElementNotInteractableException e) {
                continue;
            } catch (InterruptedException e) {
            }
        }
    }

    public void setText(WebElement element, Keys keys) {
        for (int i = 0; i < 30; i++) {
            try {
                element.sendKeys(keys);
                break;
            } catch (ElementClickInterceptedException e) {
                continue;
            } catch (StaleElementReferenceException e) {
                continue;
            } catch (InvalidElementStateException e) {
                continue;
            }
        }
    }

    public void setText(WebElement element, String value) {
        for (int i = 0; i < 40; i++) {
            try {
                element.clear();
                element.sendKeys(value);
                break;
            } catch (ElementClickInterceptedException e) {
                continue;
            } catch (StaleElementReferenceException e) {
                continue;
            } catch (InvalidElementStateException e) {
                continue;
            }
        }
    }

    public WebElement findElement(String locator, String selector, int waitTime, WebDriver driver) {
        WebElement element = null;
        for (int i = 0; i < waitTime; i++) {
            try {
                element = findElement(driver, locator, selector);
                if (element == null) {
                    Thread.sleep(1000);
                    element = findElement(driver, locator, selector);
                    if (element != null && element.isDisplayed()) {
                        break;
                    }
                }
            } catch (Exception e) {
                continue;
            }
        }
        return element;
    }

    public void scrollTopWebPage(WebDriver driver) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "window.scrollTo(Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight),0);");
    }


    public void verifyResult(String actualResult, String expectedResult, boolean condition) {
        actualResult = "<b><font color=red>" + actualResult + "</b></font>";
        expectedResult = "<b><font color=green>" + expectedResult + "</b></font>";
        if (condition) {
            actualResult = expectedResult;
        }
        Assert.assertEquals(actualResult, expectedResult);
    }
}
