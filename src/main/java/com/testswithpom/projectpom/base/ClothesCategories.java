package com.testswithpom.projectpom.base;

public enum ClothesCategories {
    TSHIRTS("T-shirts", "Tops", "Women"),
    BLOUSES("Blouses", "Tops", "Women"),
    CASUALDRESSES("Casual Dresses", "Dresses", "Women"),
    EVENINGDRESSES("Evening Dresses", "Dresses", "Women"),
    SUMMERDRESSES("Summer Dresses", "Dresses", "Women");

    private String subcategoryName;
    private String categoryName;
    private String generalName;

    ClothesCategories(String subcategoryName, String categoryName, String generalName) {
        this.subcategoryName = subcategoryName;
        this.categoryName = categoryName;
        this.generalName = generalName;
    }

    /** Getter for Subcategory name */
    public String getGeneralName() {
        return generalName;
    }

    /** Getter for Subcategory name */
    public String getSubcategoryName() {
        return subcategoryName;
    }

    /** Getter for Category name */
    public String getCategoryName() {
        return categoryName;
    }
}
