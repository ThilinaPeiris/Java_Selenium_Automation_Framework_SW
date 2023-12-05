package com.bmsoft.pages;

import com.bmsoft.utilities.CommonOp;
import com.bmsoft.utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookItemDetailsPage {

    private final WebDriver driver;
    private final CommonOp commonOpObj;

    private final By paperbackPrice = By.xpath("//span[text()='Paperback']/following-sibling::span/span");
    private final By paperbackLink = By.xpath("//span[text()='Paperback']/parent::a[@class='a-button-text']");
    private final By quantityDropDown = By.xpath("//span[text()='Qty:']");
    private final By quantityOfTwo = By.xpath("//li[@aria-labelledby='quantity_1']");
    private final By addToCartBtn = By.id("add-to-cart-button");

    public BookItemDetailsPage(WebDriver driver, CommonOp commonOpObj) {
        this.driver = driver;
        this.commonOpObj = commonOpObj;
    }

    public void setTestResult(int row, int col){
        ExcelUtil.rowNumber = row;
        ExcelUtil.columnNumber = col;
    }

    public String getPaperbackPrice() {
        return driver.findElement(paperbackPrice).getText();
    }

    public void clickPaperbackLink() {
        driver.findElement(paperbackLink).click();
    }

    public void clickQuantityDropDown() {
        commonOpObj.waitUntilElementClickable(quantityDropDown, 30).click();
    }

    public void clickQuantityOfTwo() {
        commonOpObj.waitUntilElementClickable(quantityOfTwo, 30).click();
    }

    public void clickAddToCartBtn() throws InterruptedException {
        commonOpObj.waitUntilElementClickable(addToCartBtn, 30);
        driver.findElement(addToCartBtn).click();
    }


}
