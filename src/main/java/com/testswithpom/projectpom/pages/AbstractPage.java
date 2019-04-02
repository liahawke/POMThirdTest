package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import com.testswithpom.projectpom.base.ClothesCategories;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    // Web Elements
    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement loginLink;

    @FindBy(xpath = "//div[@id='page']")
    protected WebElement divPage;

    @FindBy(
            xpath =
                    "//li[@class='sfHover']//a[@title='Evening Dresses'][contains(text(),'Evening Dresses')]")
    protected WebElement eveningDresses;

    @FindBy(xpath = "//span[@class='remove_link']//a")
    private WebElement deleteFromCart;

    @FindBy(xpath = "//div[@class='shopping_cart']//span[contains(text(), 'empty')]")
    private WebElement emptyWordLink;

    // Instances of BaseTest
    protected BaseClass testClass;

    // Parent window
    private static String actualWindow;

    // Instance of ClothesCategories
    ClothesCategories clothes;

    /**
     * Constructor
     *
     * @param testClass
     */
    public AbstractPage(BaseClass testClass) {
        this.testClass = testClass;
        PageFactory.initElements(testClass.getDriver(), this);
        testClass.waitTillElementIsVisible(divPage);
    }

    /**
     * Click on Sign in link
     *
     * @return Login Page
     */
    public LoginPage clickLoginLink() {
        testClass.waitTillElementIsVisible(loginLink);
        loginLink.click();
        return new LoginPage(testClass);
    }

    /** Click on Dresses link */
    public ListingPage clickOnMenuLink() {
        testClass.waitTillElementIsVisible(eveningDresses);
        eveningDresses.click();
        return new ListingPage(testClass);
    }

    /** Move to element */
    public void moveToSomeElement(String xpathElement) {
        WebElement element = testClass.getDriver().findElement(By.xpath(xpathElement));
        testClass.waitTillElementIsVisible(element);
        Actions actions = new Actions(testClass.getDriver());
        actions.moveToElement(element).build().perform();
    }

    /**
     * Open link in new tab
     *
     * @param webElement
     */
    public void openNewTab(WebElement webElement) {
        actualWindow = testClass.getDriver().getWindowHandle();
        webElement.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
        Set<String> windows = testClass.getDriver().getWindowHandles();
        String newWindow = null;
        for (String window : windows) {
            if (!window.equals(actualWindow)) {
                newWindow = window;
            }
        }
        testClass.getDriver().switchTo().window(newWindow);
    }

    /** Close current tab */
    public void closeTab() {
        testClass.getDriver().close();
        testClass.getDriver().switchTo().window(actualWindow);
    }

    /** Remove product from cart */
    public void removeProducts() {
        testClass.waitTillElementIsVisible(deleteFromCart);
        deleteFromCart.click();
    }

    /** Check if the cart is empty */
    public void checkEmptyCart() {
        testClass.waitTillElementIsVisible(emptyWordLink);
        Assert.assertEquals("Tha cart isn't empty", "(empty)", emptyWordLink.getText());
    }

    public void showCookie() {
        testClass.getDriver().switchTo().window(testClass.getDriver().getWindowHandle());
        Set<Cookie> cookies = testClass.getDriver().manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(
                    "Name - "
                            + cookie.getName()
                            + " Path - "
                            + cookie.getPath()
                            + " Value - "
                            + cookie.getValue());
        }
    }
}
