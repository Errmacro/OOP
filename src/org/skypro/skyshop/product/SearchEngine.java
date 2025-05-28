package org.skypro.skyshop.product;

public class SearchEngine {
    private final Searchable[] searchables;
    private int size;

    public SearchEngine() {
        this.searchables = new Searchable[8];
        size = 0;
    }

    public String[] searchByKeyword(String keyword) {
        String[] searchResult = new String[5];
        int count = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String searchTerm = searchable.getSearchTerm();
                if (searchTerm.toLowerCase().contains(keyword.toLowerCase())) {
                    if (count < searchResult.length) {
                        searchResult[count] = searchable.getStringRepresentation();
                        count++;
                        System.out.println(searchable.getStringRepresentation());
                    } else {
                        break;
                    }
                }
            } else {
                System.out.println(" ");
            }
        }
        return searchResult;
    }

    public void addToSearchable(Searchable searchable) {
        if (size < searchables.length) {
            searchables[size] = searchable;
            size++;
        } else {
            System.out.println("Массив переполнен");
        }
    }

    public void showSearchable() {
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                System.out.println(searchable.getStringRepresentation());
            } else {
                System.out.println("Пусто");
            }
        }
    }
}


