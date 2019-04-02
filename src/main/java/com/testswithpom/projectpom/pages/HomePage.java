package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;

public class HomePage extends AbstractPage {

    /**
     * Constructor
     *
     * @param testClass
     */
    public HomePage(BaseClass testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }
}
