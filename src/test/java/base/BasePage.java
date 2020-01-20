package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 5);
    }

    public void navigateTo(String webUrl) {
        if (!driver.getCurrentUrl().equals(webUrl)) {
            driver.navigate().to(webUrl);
        }
    }
    private void scrollToCenter(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})",
                webElement);
    }
    private void highLightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
                "color: red; border: 1px dashed red;");
    }

    private WebElement findElement(By by, int... index) {
        WebElement element = null;

        if (index.length == 0) {
            try {
                element = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
            } catch (Exception e) {
                return null;
            }
        } else if (index[0] >= 0) {
            try {
                element = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)).get(index[0]);
            } catch (Exception e) {
                return null;
            }
        }
        highLightElement(element);

        return element;
    }

    protected void fillInputField(By by, String text, int... index) {
        WebElement element;

        try {
            element = findElement(by,index);
            if (element.isEnabled()) {
                scrollToCenter(element);
                element.clear();
                element.sendKeys(text);
            }
        } catch (NullPointerException e) {
            Assert.assertTrue(false, "Nullpointer Exception for:" + by);
        }
    }
    protected void clickObject(By by, int... index) {
        WebElement element;

        try {
            element = findElement(by, index);
            if (element == null){
                throw new RuntimeException("ELEMENT (" + by + (index.length > 0 ? index[0] : "")
                        + ") NOT EXIST; AUTOMATION DATAS MAY BE INVALID!");
            }else {
                waitUntilExpectedElementClickable(element);
                scrollToCenter(element);
                threadSleep(1250);
                element.click();
            }
        }catch (NullPointerException e){
            e.printStackTrace();
            Assert.assertTrue(false, "Nullpointer Exception for:" + by);
        }
    }
    private void waitUntilExpectedElementClickable(WebElement element) {
        try {
            highLightElement(element);
            webDriverWait.until(ExpectedConditions.visibilityOfAllElements(element));
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (NullPointerException e) {
            Assert.fail("Nullpointer Exception for:" + element);
            e.getMessage();
        }
    }
    protected void threadSleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected boolean isElementDisplayed(By by, int... index) {
        boolean found = false;

        try {
            if (findElement(by, index) != null && findElement(by, index).isDisplayed())
                found = true;
        } catch (NullPointerException e) {
            found = false;
        }

        return found;
    }
    protected void hoverElement(By by, int... index) {
        threadSleep(1000);
        Actions action = new Actions(driver);
        action.moveToElement(findElement(by, index)).build().perform();
    }
    protected String getWebElementText(By by, int... index) {
        try {
            return findElement(by, index).getText();
        } catch (NullPointerException e) {
            Assert.assertTrue(false, "Nullpointer Exception for:" + by);
            return null;
        }
    }





}
