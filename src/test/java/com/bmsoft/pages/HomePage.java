package com.bmsoft.pages;

import com.bmsoft.utilities.CommonOp;
import com.bmsoft.utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    private final WebDriver driver;
    private final CommonOp commonOpObj;

    private final By searchDropdownBox = By.id("searchDropdownBox");
    private final By twoTabSearchTextBox = By.id("twotabsearchtextbox");


    public HomePage(WebDriver driver, CommonOp commonOpObj) {
        this.driver = driver;
        this.commonOpObj = commonOpObj;
    }

    public void clickSearchDropdownBox() {
        commonOpObj.waitUntilElementPresence(searchDropdownBox, 60);
        driver.findElement(searchDropdownBox).click();
    }

    public void selectSearchDropdownBoxBooksItem() {
        Select searchDropDownBox = new Select(driver.findElement(searchDropdownBox));
        searchDropDownBox.selectByVisibleText("Books");
    }

    public void enterValuesToSearchTextBoxAndSearch(String searchText) {
        driver.findElement(twoTabSearchTextBox).sendKeys(searchText);
        driver.findElement(twoTabSearchTextBox).sendKeys(Keys.ENTER);
    }

    public void setTestResult(int row, int col){
        ExcelUtil.rowNumber = row;
        ExcelUtil.columnNumber = col;
    }

}
