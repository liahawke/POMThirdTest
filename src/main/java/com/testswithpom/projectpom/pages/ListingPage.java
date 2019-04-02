package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListingPage extends AbstractPage {

    @FindBy(xpath = "//span[@class='cat-name']")
    private WebElement headingOfListingPage;

    /**
     * Constructor
     *
     * @param testClass
     */
    public ListingPage(BaseClass testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }

    /**
     * Click on product
     *
     * @return Product Page
     */
    public ProductPage clickOnProduct() {
        testClass.waitTillElementIsVisible(headingOfListingPage);
        openNewTab(getProductXPath("Printed Dress"));
        return new ProductPage(testClass);
    }

    /**
     * Return product XPath
     *
     * @param productName
     * @return
     */
    public WebElement getProductXPath(String productName) {
        testClass.waitTillElementIsVisible(headingOfListingPage);
        return testClass
                .getDriver()
                .findElement(By.xpath("//a[contains(text(),'" + productName + "')]"));
    }
}
