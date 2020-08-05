package model;

public enum Category {
    KAROSERIA("karoseria"),
    ZAWIESZENIE("zawieszenie"),
    SILNIK("silnik");

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }
}
