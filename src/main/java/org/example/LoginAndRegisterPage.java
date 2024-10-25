package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginAndRegisterPage {
    WebDriver driver;

    //Constructor
    public LoginAndRegisterPage(WebDriver driver){
        this.driver=driver;
    }

    //Locators
    private By loginTabButton = By.xpath("//a[@href=\"/login\"]");
    private By loginHeader = By.xpath("//div[@class=\"login-form\"]//h2");
    private By loginEmailTextField = By.xpath("//input[@data-qa=\"login-email\"]");
    private By loginPasswordTextField = By.xpath("//input[@data-qa=\"login-password\"]");
    private By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");
    private By logoutButton = By.xpath("//a[@href=\"/logout\"]");

    //Actions
    public void navigateToURL (String URL){
        driver.get(URL);
    }

    public void clickLoginTabButton (){
        driver.findElement(loginTabButton).click();
    }

    public void fillLoginEmailTextField(String email){
        driver.findElement(loginEmailTextField).sendKeys(email);
    }

    public void fillLoginPasswordTextField(String password){
        driver.findElement(loginPasswordTextField).sendKeys(password);
    }

    public void fillLoginData(String email , String password){
        fillLoginEmailTextField(email);
        fillLoginPasswordTextField(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    //Assertions
    public void assertOnLoginHeader(String expectedloginHeader){
        String actualLoginHeader = driver.findElement(loginHeader).getText();
        Assert.assertEquals(actualLoginHeader,expectedloginHeader);
    }

    public void assertOnLogoutButton(){
        WebElement logoutButtonElement = driver.findElement(logoutButton);
        Assert.assertTrue(logoutButtonElement.isDisplayed());
    }

}
