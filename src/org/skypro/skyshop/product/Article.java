package org.skypro.skyshop.product;

public class Article implements Searchable {
    private final String articleName;
    private final String articleText;

    public Article(String articleName, String articleText) {
        this.articleName = articleName;
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return "Товар: " + articleName + '\'' +
                ", содержание: " + articleText + '\'';
    }

    @Override
    public String getSearchTerm() {
        return articleName + ": " + articleText;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

}
