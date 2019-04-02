package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import com.testswithpom.projectpom.utils.YamlParser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    // Web elements
    @FindBy(xpath = "//input[@id='email']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@id='SubmitLogin']/span")
    private WebElement loginBtn;

    /**
     * Constructor
     *
     * @param testClass
     */
    public LoginPage(BaseClass testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }

    /** Login form */
    public AccountPage fillInputOnLoginPage() {
        loginInput.sendKeys(YamlParser.getYamlData().getEmail());
        passwordInput.sendKeys(YamlParser.getYamlData().getPassword());
        loginBtn.click();
        return new AccountPage(testClass);
    }
}
