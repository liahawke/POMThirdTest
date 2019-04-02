package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='add_to_cart']/button/span")
    private WebElement addToCardBtn;

    @FindBy(xpath = "//*[@id='layer_cart']")
    private WebElement checkOutPopUp;

    @FindBy(xpath = "//span[@title='Continue shopping']//span")
    private WebElement btnContinue;

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement productName;

    @FindBy(xpath = "//select[@id='group_1']")
    private WebElement selectSize;

    @FindBy(xpath = "//div[@class='cart-info']//div[@class='product-atributes']//a")
    private WebElement linkProductDetails;

    /**
     * Constructor
     *
     * @param testClass
     */
    public ProductPage(BaseClass testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }

    /** Click on Add product button */
    public void clickAddBtn() {
        testClass.waitTillElementIsVisible(addToCardBtn);
        addToCardBtn.click();
        testClass.waitTillElementIsVisible(checkOutPopUp);
    }

    /**
     * Select color
     *
     * @param color
     */
    public void chooseColor(String color) {

        testClass.getDriver().findElement(By.xpath("//a[@name='" + color + "']")).click();
    }

    /**
     * Choose size
     *
     * @param size
     */
    public void chooseSize(String size) {
        Select dropdownSize = new Select(selectSize);
        dropdownSize.selectByVisibleText(size);
    }

    /** Click continue shopping button */
    public void clickContinueBtn() {
        testClass.waitTillElementIsVisible(btnContinue);
        btnContinue.click();
        testClass.waitTillElementIsVisible(productName);
    }

    /**
     * Check color and size in cart
     *
     * @param productSize
     * @param productColor
     */
    public void checkColorAndPrice(String productSize, String productColor) {
        testClass.waitTillElementIsVisible(linkProductDetails);
        String dataFromCart = productColor + ", " + productSize;
        Assert.assertEquals(
                "Product parameters is different!", dataFromCart, linkProductDetails.getText());
    }
}
