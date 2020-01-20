package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchPage;

public class GeneralTest extends BaseTest {

    @Test (description = "navigate to http://www.n11.com <http://www.n11.com/> and confirm that homepage is open")
    public void goToN11() throws InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        SearchPage searchPage = new SearchPage(webDriver);

        loginPage.navigateTo("https://www.n11.com/");
        Assert.assertTrue(webDriver.getTitle().equals("n11.com - Alışverişin Uğurlu Adresi"));
        System.out.println("N11 Alışveriş sitesi başarılı bir şekilde açıldı");

    }
    @Test(description = "Open login screen, will login with a user")
    public void LoginN11(){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.navigateTo("https://www.n11.com/");
        loginPage.clickLoginButton();
        loginPage.setLoginData("trendyoltestrk@gmail.com","test.123");

    }
    @Test(description = "write 'samsung' to search field and search")
    public void search(){
        LoginPage loginPage = new LoginPage(webDriver);
        SearchPage searchPage = new SearchPage(webDriver);
        loginPage.navigateTo("https://www.n11.com/");
        loginPage.clickLoginButton();
        loginPage.setLoginData("trendyoltestrk@gmail.com","test.123");
        searchPage.searchAndClick("samsung");
        //searchPage.itemControl();

    }
    @Test(description = "click second page and confirmation")
    public void nextPageClick(){
        LoginPage loginPage = new LoginPage(webDriver);
        SearchPage searchPage = new SearchPage(webDriver);
        loginPage.navigateTo("https://www.n11.com/");
        loginPage.clickLoginButton();
        loginPage.setLoginData("trendyoltestrk@gmail.com","test.123");
        searchPage.searchAndClick("samsung");
        searchPage.secondPageClick();
        Assert.assertTrue(webDriver.getCurrentUrl().equals("https://www.n11.com/arama?q=samsung&pg=2"));


    }
    @Test(description = "Click on the 'add to favorites' button in the 3rd product of the top")
    public void clickToFavor() {
        LoginPage loginPage = new LoginPage(webDriver);
        SearchPage searchPage = new SearchPage(webDriver);
        loginPage.navigateTo("https://www.n11.com/");
        loginPage.clickLoginButton();
        loginPage.setLoginData("trendyoltestrk@gmail.com", "test.123");
        searchPage.searchAndClick("samsung");
        searchPage.secondPageClick();
        searchPage.clickİtemToFavor();

    }
    @Test(description = "Click on the 'my favorites' link at the top of the screen")
    public void goToFavorLink() {
      LoginPage loginPage = new LoginPage(webDriver);
      SearchPage searchPage = new SearchPage(webDriver);
      loginPage.navigateTo("https://www.n11.com/");
      loginPage.clickLoginButton();
      loginPage.setLoginData("trendyoltestrk@gmail.com", "test.123");
      searchPage.searchAndClick("samsung");
      searchPage.secondPageClick();
      searchPage.clickİtemToFavor();
      searchPage.confirmClick();
      searchPage.clickHesabım();
      searchPage.favorLink();

  }
  @Test(description = "Confirm that on the opened page there is a product tracked on the previous page")
  public void goToFavorBasketAndAssert() {
      LoginPage loginPage = new LoginPage(webDriver);
      SearchPage searchPage = new SearchPage(webDriver);
      loginPage.navigateTo("https://www.n11.com/");
      loginPage.clickLoginButton();
      loginPage.setLoginData("trendyoltestrk@gmail.com", "test.123");
      searchPage.searchAndClick("samsung");
      searchPage.secondPageClick();
      searchPage.clickİtemToFavor();
      searchPage.confirmClick();
      searchPage.clickHesabım();
      searchPage.favorLink();
      searchPage.clickMyFavorBtn();
      Assert.assertEquals(searchPage.expectedProductName(), SearchPage.productName);

    }
    @Test(description = "Confirm that on the opened page there is a product tracked on the previous page")
    public void deleteFavorİtem(){
        LoginPage loginPage = new LoginPage(webDriver);
        SearchPage searchPage = new SearchPage(webDriver);
        loginPage.navigateTo("https://www.n11.com/");
        loginPage.clickLoginButton();
        loginPage.setLoginData("trendyoltestrk@gmail.com", "test.123");
        searchPage.searchAndClick("samsung");
        searchPage.secondPageClick();
        searchPage.clickİtemToFavor();
        searchPage.confirmClick();
        searchPage.clickHesabım();
        searchPage.favorLink();
        searchPage.clickMyFavorBtn();
        searchPage.deleteFavorİtemBtn();
        searchPage.deleteFavorİtemOkBtn();
    }

}
