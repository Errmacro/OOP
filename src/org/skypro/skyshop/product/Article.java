package org.skypro.skyshop.product;

public class Article implements Searchable {
    String articleName;
    String articleText;

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
