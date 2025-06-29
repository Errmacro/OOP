package org.skypro.skyshop.product;

import java.util.Objects;

public final class Article implements Searchable {
    private final String articleName;
    private final String articleText;

    public Article(String articleName, String articleText) {
        this.articleName = articleName;
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return "'" +articleName + "'" +
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleName, article.articleName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(articleName);
    }

    public String getArticleName() {
        return articleName;
    }
}
