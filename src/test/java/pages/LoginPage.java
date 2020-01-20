package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {
    static WebDriver driver;

    private By loginButtonClassName = By.className("btnSignIn");
    private By userEmailId = By.id("email");
    private By passwordId = By.id("password");
    private By loginSubmitButtonId = By.id("loginButton");
    private By popUpCloseAfterLoginClassname = By.className("modal-close");
    private By konum = By.className("menuLink pin");




    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setLoginData(String userEmail, String password){
        fillInputField(userEmailId, userEmail);
        fillInputField(passwordId, password);
        clickObject(loginSubmitButtonId);

    }
    public LoginPage clickLoginButton(){
        hoverElement(loginButtonClassName);
        clickObject(loginButtonClassName);

        return this;
    }






}

