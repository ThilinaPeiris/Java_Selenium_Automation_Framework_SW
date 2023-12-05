package com.bmsoft.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

public class CommonOp {

    private WebDriver driver;

    public CommonOp(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitUntilElementPresence(By locator, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(timeOut, SECONDS));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitUntilElementClickable(By locator, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(timeOut, SECONDS));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitUntilElementInvisibilityOf(By locator, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(timeOut, SECONDS));
        return wait.until(ExpectedConditions.invisibilityOf(driver.findElement(locator)));
    }

    public boolean waitUntilElementInvisibilityOfElementLocated(By locator, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(timeOut, SECONDS));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public List<WebElement> waitUntilElementsVisibilityOf(By locator, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(timeOut, SECONDS));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement waitUntilElementVisibilityOf(By locator, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(timeOut, SECONDS));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilAlertIsPresent(long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(timeOut, SECONDS));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void Sleep(long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
