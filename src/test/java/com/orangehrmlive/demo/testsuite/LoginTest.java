package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class LoginTest extends BaseTest{


        //Declaration
        AddUserPage addUserPage;
        AdminPage adminPage;
        DashBoardPage dashboardPage;
        HomePage homePage;
        LoginPage loginPage;


        @BeforeMethod(alwaysRun = true)
        public void inIt() {
            addUserPage = new AddUserPage();
            adminPage = new AdminPage();
            dashboardPage = new DashBoardPage();
            homePage = new HomePage();
            loginPage = new LoginPage();

        }


        @Test(groups = {"Sanity", "Smoke", "Regression"})
        public void verifyUserShouldLoginSuccessfully() {
            //Enter username
            loginPage.setEnterEmailIde("Admin");
            //   Enter password
            loginPage.setEnterPassword("admin123");
            //   Click on Login Button
            loginPage.setVerifyLoginPanel();
            //   Verify "Dashboard" Message
            String actualMessage = dashboardPage.getVerifyTheTextDashboard();
            String expectedMessage = "WelCome";
           Assert.assertEquals(actualMessage, expectedMessage, "WelCome Text is displayed");
        }

        @Test(groups = {"Smoke", "Regression"})
        public void verifyThatTheLogoDisplayedOnHomePage() {
            //Launch the application
            driver.getCurrentUrl();
            //   Verify Logo is Displayed
            homePage.setEnterCompanyLogo();
        }

        @Test(groups = {"Regression"})
        public void verifyUserShouldLogoutSuccessfully() throws InterruptedException {
            //Login To The application
            loginPage.setEnterEmailIde("Admin");
            loginPage.setEnterPassword("admin123");
            loginPage.setVerifyLoginPanel();
            //   Click on User Profile logo
            adminPage.setClickOnUserProfileLogo();
            //   Mouse hover on "Logout" and click
            adminPage.setMouseHoverOnLogout();
            //   Verify the text "Login Panel" is displayed
            Thread.sleep(2000);
            String actualMessage = loginPage.setVerifyLoginPanel();
            String expectedMessage = "Login";
            Assert.assertEquals(actualMessage, expectedMessage, "login message is not displayed");
        }


        @Test(groups = {"Regression"}, dataProvider = "loginData", dataProviderClass = TestData.class)
        public void verifyErrorMessageWithInvalidCredentials(String userName, String password, String errorMessage) {
            //Enter username
            loginPage.setEnterEmailIde(userName);
            //   Enter password
            loginPage.setEnterPassword(password);
            //   Click on Login Button
            loginPage.setVerifyLoginPanel();
            //   Verify "Dashboard" Message
            String actualMessage = dashboardPage.getVerifyTheTextDashboard();
            String expectedMessage = errorMessage;
            Assert.assertEquals(actualMessage, expectedMessage, "Welcome  Text is not displayed");

        }
    }

