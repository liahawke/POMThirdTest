package com.testswithpom.projectpom.test;

import static com.testswithpom.projectpom.base.ProductFeatures.EVENING_DRESS;

import com.testswithpom.projectpom.base.BaseClass;
import com.testswithpom.projectpom.pages.*;
import org.junit.Test;

public class AddToCard extends BaseClass {

    @Test
    public void signInAndCheckName() {

        // Open site
        HomePage homePage = openSite();
        log("Opened site");

        // Click on Sign In link
        LoginPage loginPage = homePage.clickLoginLink();
        log("Click on Login Link");

        // Signing in Account
        AccountPage accountPage = loginPage.fillInputOnLoginPage();
        log("Fill data for auth");

        // Move to Women category
        accountPage.moveToCategory();
        log("Move to Women category");

        // Click on evening Dresses
        ListingPage listingPage = accountPage.clickOnMenuLink();
        log("Click on evening Dresses");

        // Open Product in new tab
        ProductPage productPage = listingPage.clickOnProduct();
        log("Open Product in new tab");

        // Switch to pink color
        productPage.chooseColor(EVENING_DRESS.getProductColor());
        log("Switch to pink color");

        // Switch to L size
        productPage.chooseSize(EVENING_DRESS.getProductSize());
        log("Select L size");

        // Click Add to cart button
        productPage.clickAddBtn();
        log("Click Add to cart button");

        // Click Continue shopping button
        productPage.clickContinueBtn();
        log("Click Continue shopping button");

        // Move to Cart icon
        productPage.moveToCart();
        log("Move to Cart icon");

        // Check Size and Color
        productPage.checkColorAndPrice(
                EVENING_DRESS.getProductSize(), EVENING_DRESS.getProductColor());
        log("Check Size and Color");

        // Remove product from cart
        productPage.removeProducts();
        log("Remove product from cart");

        // Check if cart is empty
        productPage.checkEmptyCart();
        log("Check if cart is empty");

        // Close current tab
        productPage.closeTab();
        log("Close current tab");

        // Print Cookies
        homePage.showCookie();
        log("Print Cookies");
    }
}
