package com.testswithpom.projectpom.base;

public enum ProductFeatures {
    EVENING_DRESS("Pink", "L");

    private String productColor;
    private String productSize;

    ProductFeatures(String productColor, String productSize) {
        this.productColor = productColor;
        this.productSize = productSize;
    }

    /** Getter for product color */
    public String getProductColor() {
        return productColor;
    }

    /** Getter for product size */
    public String getProductSize() {
        return productSize;
    }
}
