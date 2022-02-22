package com.selenium.methods;

import com.selenium.driver.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;
    Logger logger;

    public Methods() {

        driver = BaseTest.driver;
        wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void waitBySeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isElementVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public void scrollWithAction(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public List<WebElement> findElements(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }


    public Select getSelect(By by) {
        return new Select(findElement(by));
    }

    public void scrollWithAction(WebElement el) {
        Actions actions = new Actions(driver);
        actions.moveToElement(el).build().perform();
    }

    public void addFavorites() {
        List<WebElement> products = findElements(By.cssSelector(".add-to-favorites"));
        for (int i = 3; i < 7; i++) {
            WebElement el = products.get(i);
            scrollWithAction(el);
            products.get(i).click();
            waitBySeconds(2);
        }
    }

    public void clickRandom() {
        Random rnd = new Random();
        List<WebElement> pproducts = findElements(By.cssSelector(".cover"));
        WebElement rndProduct = pproducts.get(rnd.nextInt(pproducts.size()));
        scrollWithAction(rndProduct);
        rndProduct.click();

    }

    public void favoriteCheck() {
        click(By.cssSelector(".menu.top.my-list"));
        click(By.linkText("Favorilerim"));
        Assert.assertTrue(isElementVisible(By.cssSelector(".limit")));
    }

    public void selectByText(By by, String text) {
        getSelect(by).selectByVisibleText(text);
    }

    public String getAttribute(By by, String attributeName) {
        return findElement(by).getAttribute(attributeName);
    }


    public String getText(By by) {
        return findElement(by).getText();
    }


    public void clickJS(By by) {
        jsdriver.executeScript("arguments[0].click();", findElement(by));
    }

    public void selectByValue(By by, String text) {
        getSelect(by).selectByValue(text);
    }

}

