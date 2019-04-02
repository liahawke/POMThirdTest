package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage {

    // Web elements
    @FindBy(xpath = "//a[contains(@title, 'Add')]")
    private WebElement incProduct;

    @FindBy(xpath = "//td[@class='cart_quantity text-center']/input[@type='text']")
    private WebElement prodQuantity;

    @FindBy(xpath = "//td[@class='cart_quantity text-center']/input[@type='hidden']")
    private WebElement hiddenQuantity;

    @FindBy(xpath = "//td[@class='cart_unit']/span")
    private WebElement prodPrice;

    @FindBy(xpath = "//span[@id='total_price']")
    private WebElement totalPrice;

    @FindBy(xpath = "//td[@id='total_shipping']")
    private WebElement shippingPrice;

    @FindBy(xpath = "//a[contains(@title, 'Delete')]")
    private WebElement deleteBtn;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement emptyCardMessage;

    private String EMPTY_CARD_MESSAGE = "Your shopping cart is empty.";

    /**
     * Constructor
     *
     * @param testClass
     */
    public CheckoutPage(BaseClass testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }

    /** Increase number of products by clicking + button */
    public void clickPlusBtn() {
        testClass.waitTillElementIsVisible(incProduct);
        incProduct.click();
        testClass.waitTillTextAppears(prodQuantity, "2");
    }

    /** Check if total price was recalculated after changing product quantity */
    public void checkPrice() {
        float actualPrice =
                (Float.parseFloat(prodPrice.getText().substring(1))
                                * Float.parseFloat(hiddenQuantity.getAttribute("value")))
                        + Float.parseFloat(shippingPrice.getText().substring(1));
        Assert.assertEquals(
                "Price is different!",
                String.valueOf(actualPrice),
                totalPrice.getText().substring(1));
    }

    /** Delete product from the cart */
    public void deleteProduct() {
        testClass.waitTillElementIsVisible(deleteBtn);
        deleteBtn.click();
    }

    /** Check title if cart is empty */
    public void checkTitle() {
        testClass.waitTillElementIsVisible(emptyCardMessage);
        Assert.assertEquals("Card isn't empty!", EMPTY_CARD_MESSAGE, emptyCardMessage.getText());
    }
}
