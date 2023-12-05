package com.bmsoft.tests;

import com.bmsoft.pages.*;
import com.bmsoft.testbase.BaseTest;
import com.bmsoft.utilities.CommonOp;
import com.bmsoft.utilities.ExcelUtil;
import com.bmsoft.utilities.SetupDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.apache.logging.log4j.Level.INFO;

public class CartItemRemovalTest extends BaseTest {

    private final Logger LOGGER = LogManager.getLogger(CartItemRemovalTest.class);

    private WebDriver driver;
    private CommonOp commonOpObj;
    private HomePage pHomeObj;
    private BooksItemListPage pBooksItemListPage;
    private BookItemDetailsPage pBookItemDetailsPage;
    private ItemAddedToCartPage pItemAddedToCartPage;
    private ShoppingCartPage pShoppingCartPage;

    @BeforeClass
    public void setUpClass() {
        try {
            driver = SetupDriver.getDriver(driver, browser, baseUrl);
            driver.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.MILLISECONDS);

            commonOpObj = new CommonOp(driver);
            pHomeObj = new HomePage(driver,commonOpObj);
            pBooksItemListPage = new BooksItemListPage(driver, commonOpObj);
            pBookItemDetailsPage = new BookItemDetailsPage(driver, commonOpObj);
            pItemAddedToCartPage = new ItemAddedToCartPage(driver, commonOpObj);
            pShoppingCartPage = new ShoppingCartPage(driver, commonOpObj);

            driver.manage().window().maximize();

            //ExcelUtil.setExcelFileSheet("LoginData");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void setUpMethod() {
        driver.get(baseUrl);
    }

    @Test(description = "TC_001 - removeItemFromCartTest")
    @Parameters({"searchText", "expectedItemQuantity",
            "expectedItemQuantityAfterDeletedItem", "expectedSubTotalAfterDeletedItem" })
    public void removeItemFromCartTest(String searchText, String expectedItemQuantity, String expectedItemQuantityAfterDeletedItem, String expectedSubTotalAfterDeletedItem) throws InterruptedException {

        LOGGER.log(INFO, "Automated TestCase 'TC_001 - removeItemFromCartTest' is Initialized.");

        pHomeObj.clickSearchDropdownBox();
        pHomeObj.selectSearchDropdownBoxBooksItem();
        pHomeObj.enterValuesToSearchTextBoxAndSearch(searchText);

        pBooksItemListPage.clickFourStarsAndUpRating();
        pBooksItemListPage.clickEnglishLang();
        String expectedItemName = pBooksItemListPage.getSecondItemName();
        pBooksItemListPage.clickSecondItemDetailsLink();

        String expectedItemPrice = pBookItemDetailsPage.getPaperbackPrice();
        pBookItemDetailsPage.clickPaperbackLink();
        pBookItemDetailsPage.clickQuantityDropDown();
        pBookItemDetailsPage.clickQuantityOfTwo();
        pBookItemDetailsPage.clickAddToCartBtn();

        pItemAddedToCartPage.clickGoToCartBtn();

        String actualItemName = pShoppingCartPage.getItemName();
        String actualItemPrice = pShoppingCartPage.getItemPrice();
        String actualSubTotal = pShoppingCartPage.getSubTotal().substring(1);
        String actualItemQuantity = pShoppingCartPage.getItemQuantity();

        Assert.assertEquals(actualItemName.toLowerCase(), expectedItemName.toLowerCase(), "Expected Item Name was, " + expectedItemName + "But Actual Item Name was " + actualItemName);
        Assert.assertEquals(actualItemPrice, expectedItemPrice, "Expected Item Price was, " + expectedItemPrice + "But Actual Item Price was " + actualItemPrice);
        String expectedSubTotal = String.valueOf(Double.parseDouble(actualItemPrice.trim().substring(1))*2);
        Assert.assertEquals(actualSubTotal,expectedSubTotal , "Expected SubTotal was, " + expectedSubTotal + "But Actual SubTotal was " + actualSubTotal);
        Assert.assertTrue(actualItemQuantity.contains(expectedItemQuantity), "Expected Item Quantity was, " + expectedItemQuantity + "But Actual Item Quantity was " + actualItemQuantity);

        pShoppingCartPage.clickDeleteItemFromCart();
        String actualItemQuantityAfterDeletedItem = pShoppingCartPage.getItemQuantityAfterDeletedItemFromCart();
        String actualSubTotalAfterDeletedItem = pShoppingCartPage.getItemSubTotalAfterDeletedItemFromCart();

        Assert.assertTrue(actualItemQuantityAfterDeletedItem.contains(expectedItemQuantityAfterDeletedItem),"Expected Item Quantity was, " + expectedItemQuantityAfterDeletedItem + "But Actual Item Quantity was " + actualItemQuantityAfterDeletedItem);
        Assert.assertTrue(actualSubTotalAfterDeletedItem.contains(expectedSubTotalAfterDeletedItem),"Expected SubTotal was, " + expectedSubTotalAfterDeletedItem + "But Actual SubTotal was " + actualSubTotalAfterDeletedItem);

    }

    @AfterMethod
    public void captureScreen(ITestResult result) throws IOException
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            TakesScreenshot ts=(TakesScreenshot)driver;
            File source=ts.getScreenshotAs(OutputType.FILE); // capture screenshot file
            File target=new File(System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png");

            FileUtils.copyFile(source,target);
            commonOpObj.Sleep(2000);
        }
        driver.manage().deleteAllCookies();
        commonOpObj.Sleep(3000);
    }

    @AfterClass
    public void tearDownClass() {
        driver.quit();
    }

}
