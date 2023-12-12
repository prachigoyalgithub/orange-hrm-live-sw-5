package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"//img[@alt='company-branding']")
    WebElement enterCompanyLogo;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"//li[1]//a[1]//span[1]")
    WebElement enterAdmin;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"//span[normalize-space()='PIM']")
    WebElement enterPIM;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"//span[normalize-space()='Leave']")
    WebElement enterLeave;

    @CacheLookup
    @FindBy(xpath ="//*[@id=\"//span[@class='oxd-text oxd-text--span oxd-main-menu-item']" )
    WebElement enterDashboard;


    public void setEnterCompanyLogo() {
        Reporter.log("Enter " + logo + " companyLogo" + enterCompanyLogo.toString());
        sendTextToElement(enterCompanyLogo, logo);


        String Admin = new String();
        Reporter.log("Enter  " + Admin+ " in admin field" + enterAdmin.toString());
        sendTextToElement(enterAdmin, Admin);

        String PIM = new String();
        Reporter.log("Enter  " + PIM+" in PIM field" + enterPIM.toString());
        sendTextToElement(enterPIM, PIM);

        String leave = new String();
        Reporter.log("Enter  " + leave+" in Leave field" + enterLeave.toString());
        sendTextToElement(enterLeave, leave);

        String Dashboard = new String();
        Reporter.log("Enter  " + Dashboard+" in Dashboard field" + enterDashboard.toString());
        sendTextToElement(enterDashboard, Dashboard);




    }
}


