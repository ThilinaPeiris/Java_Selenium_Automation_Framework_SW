package com.bmsoft.pages;

import com.bmsoft.utilities.CommonOp;
import com.bmsoft.utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BooksItemListPage {

    private final WebDriver driver;
    private final CommonOp commonOpObj;

    private final By fourStarsAndUpRating = By.xpath("//section[@aria-label='4 Stars & Up']");
    private final By englishLang = By.xpath("//span[contains(text(), 'English') and @class='a-size-base a-color-base']");
    private final By secondItemName = By.xpath("//div[@data-index='3']/descendant::a[2]/span");
    private final By secondItemDetailsLink = By.xpath("//div[@data-index='3']/descendant::a[2]");

    public BooksItemListPage(WebDriver driver, CommonOp commonOpObj) {
        this.driver = driver;
        this.commonOpObj = commonOpObj;
    }

    public void setTestResult(int row, int col){
        ExcelUtil.rowNumber = row;
        ExcelUtil.columnNumber = col;
    }

    public void clickFourStarsAndUpRating() {
        WebElement element = commonOpObj.waitUntilElementClickable(fourStarsAndUpRating, 30);
        new Actions(driver).moveToElement(driver.findElement(fourStarsAndUpRating)).build().perform();
        element.click();
    }

    public void clickEnglishLang() {
        WebElement element = commonOpObj.waitUntilElementClickable(englishLang, 30);
        new Actions(driver).moveToElement(driver.findElement(englishLang)).build().perform();
        element.click();
    }

    public String getSecondItemName() {
        return driver.findElement(secondItemName).getText();
    }

    public void clickSecondItemDetailsLink() {
        WebElement element = commonOpObj.waitUntilElementClickable(secondItemDetailsLink, 30);
        new Actions(driver).moveToElement(driver.findElement(secondItemDetailsLink)).build().perform();
        element.click();
    }

}
