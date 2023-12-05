package com.bmsoft.pages;

import com.bmsoft.utilities.CommonOp;
import com.bmsoft.utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemAddedToCartPage {

    private final WebDriver driver;
    private final CommonOp commonOpObj;

    private final By goToCartBtn = By.cssSelector("form + span  a.a-button-text");

    public ItemAddedToCartPage(WebDriver driver, CommonOp commonOpObj) {
        this.driver = driver;
        this.commonOpObj = commonOpObj;
    }

    public void setTestResult(int row, int col){
        ExcelUtil.rowNumber = row;
        ExcelUtil.columnNumber = col;
    }

    public void clickGoToCartBtn() {
        commonOpObj.waitUntilElementClickable(goToCartBtn, 30).click();
    }

}
