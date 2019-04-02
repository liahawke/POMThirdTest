package com.testswithpom.projectpom.test;

import com.testswithpom.projectpom.base.BaseClass;
import com.testswithpom.projectpom.pages.AccountPage;
import com.testswithpom.projectpom.pages.HomePage;
import com.testswithpom.projectpom.pages.LoginPage;
import org.junit.Test;

public class SignInWithExistingUser extends BaseClass {

    @Test
    public void SignInWithExistingUserTest() {
        // Open site
        HomePage homePage = openSite();
        log("Opened site");

        // Click on Sign In link
        LoginPage loginPage = homePage.clickLoginLink();
        log("Click on Login Link");

        // Signing in Account
        AccountPage accountPage = loginPage.fillInputOnLoginPage();
        log("Fill data for auth");

        // Verify user name
        accountPage.verifyName();
        log("Verify username");
    }
}
