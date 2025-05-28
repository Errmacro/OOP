package org.skypro.skyshop.product;

public interface Searchable {
    String getSearchTerm();
    String getContentType();
    default String getStringRepresentation(){
        return getSearchTerm()+", тип - "+getContentType();
    }
}
