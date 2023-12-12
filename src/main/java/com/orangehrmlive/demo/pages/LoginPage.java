package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"//input[@placeholder='Username']\"]")
    WebElement enterEmailId;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"//input[@placeholder='Password']\"]")
    WebElement enterPassword;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"//button[normalize-space()='Login']\"]")
    WebElement loginButton;


    public void setEnterEmailIde(String userName) {
        sendTextToElement(enterEmailId, userName);
    }

    public void setEnterPassword(String password) {
        sendTextToElement(enterPassword, password);
    }

    public String setVerifyLoginPanel() {
        return getTextFromElement(loginButton);
    }


    }







