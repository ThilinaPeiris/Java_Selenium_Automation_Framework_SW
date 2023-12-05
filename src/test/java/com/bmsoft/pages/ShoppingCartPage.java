package com.bmsoft.pages;

import com.bmsoft.utilities.CommonOp;
import com.bmsoft.utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {

    private final WebDriver driver;
    private final CommonOp commonOpObj;

    private final By itemName = By.cssSelector("span.a-list-item span.a-truncate-cut");
    private final By itemPrice = By.cssSelector("div.sc-badge-price-to-pay span");
    private final By itemQuantity = By.id("sc-subtotal-label-buybox");
    private final By subTotal = By.cssSelector("span[id='sc-subtotal-amount-buybox'] span");
    private final By deleteItemFromCart = By.cssSelector("input[value='Delete']");
    private final By itemQuantityAfterDeletedItemFromCart = By.id("sc-subtotal-label-activecart");
    private final By itemSubTotalAfterDeletedItemFromCart = By.cssSelector("span[id='sc-subtotal-amount-activecart'] span");

    public ShoppingCartPage(WebDriver driver, CommonOp commonOpObj) {
        this.driver = driver;
        this.commonOpObj = commonOpObj;
    }

    public void setTestResult(int row, int col){
        ExcelUtil.rowNumber = row;
        ExcelUtil.columnNumber = col;
    }

    public String getItemName() {
        return driver.findElement(itemName).getText();
    }

    public String getItemPrice() {
        return driver.findElement(itemPrice).getText();
    }

    public String getItemQuantity() {
        return driver.findElement(itemQuantity).getText();
    }

    public String getSubTotal() {
        return driver.findElement(subTotal).getText();
    }

    public void clickDeleteItemFromCart() {
        commonOpObj.waitUntilElementClickable(deleteItemFromCart, 30).click();
    }

    public String getItemQuantityAfterDeletedItemFromCart() {
        commonOpObj.waitUntilElementPresence(itemQuantityAfterDeletedItemFromCart, 30);
        return driver.findElement(itemQuantityAfterDeletedItemFromCart).getText();
    }

    public String getItemSubTotalAfterDeletedItemFromCart() {
        commonOpObj.waitUntilElementPresence(itemSubTotalAfterDeletedItemFromCart, 30);
        return driver.findElement(itemSubTotalAfterDeletedItemFromCart).getText();
    }

}
