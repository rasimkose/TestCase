package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.security.Key;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchPage extends BasePage {

    static WebDriver driver;




    public By searchBtn = By.id("searchData");
    public By clickSearchBtn = By.id("searchBtn");
    public By samsungElement = By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[1]/div/div/div[2]/ul/li[1]/a/p");
    public By searchResultText = By.xpath("//*[@id=\"contentListing\"]/div/div/div[2]/section[1]/div[1]/div[1]");
    public By secondPage = By.xpath("//*[@id=\"contentListing\"]/div/div/div[2]/div[4]/a[2]");
    public By ThirdİtemFavBtn = By.xpath("//*[@id=\"p-378403945\"]/div[1]/span");
    public By favorLinkBtn = By.xpath("//*[@id=\"myAccount\"]/div[1]/div[1]/div[2]/ul/li[5]/a");
    public By confirmBtn = By.xpath("/html/body/div[4]/div/div/span");
    public By hesabım = By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/div[2]/div[1]/a[1]");
    public By myFavorBtn = By.className("listItemTitle");
    public By deleteFavorBtn = By.className("deleteProFromFavorites");
    public By delFavİtemOkBtn = By.className("closeBtn");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage searchAndClick(String text) {
        hoverElement(searchBtn);
        fillInputField(searchBtn, text);
        clickObject(samsungElement);

        return this;
    }
    public SearchPage secondPageClick() {
        hoverElement(secondPage);
        clickObject(secondPage);

        return this;
    }
    public static String productName;
    public SearchPage clickİtemToFavor() {
        hoverElement(ThirdİtemFavBtn);
        clickObject(ThirdİtemFavBtn);
        productName = getWebElementText(By.className("columnContent"));

        return this;
    }
    public SearchPage confirmClick() {
        hoverElement(confirmBtn);
        clickObject(confirmBtn);

        return this;
    }
    public SearchPage favorLink() {
        hoverElement(favorLinkBtn);
        clickObject(favorLinkBtn);

        return this;
    }
    public SearchPage clickHesabım() {
        hoverElement(hesabım);
        clickObject(hesabım);

        return this;
    }
    public SearchPage clickMyFavorBtn() {
        hoverElement(myFavorBtn);
        clickObject(myFavorBtn);

        return this;
    }
    public SearchPage deleteFavorİtemBtn() {
        hoverElement(deleteFavorBtn);
        clickObject(deleteFavorBtn);


        return this;
    }
    public SearchPage deleteFavorİtemOkBtn() {
        hoverElement(delFavİtemOkBtn);
        clickObject(delFavİtemOkBtn);

        return this;
    }
    public String expectedProductName(){
        return getWebElementText(By.className("column wishListColumn"));
    }

    public SearchPage itemControl() {
        String searchresult = driver.findElement(searchResultText).getText();
        if (searchresult.equals("Samsung")) {
            System.out.println("Sonuc bulundu " + searchresult);
        } else {
            System.out.println("Sonuc bulunamadı " + searchresult);
        }
        return this;

    }

}
