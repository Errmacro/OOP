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
            if (searchable == null) {
                System.out.println("Ничего не найдено");
            }
            String searchTerm = searchable.getSearchTerm();
            if (searchTerm.contains(keyword)) {
                if (count < searchResult.length) {
                    searchResult[count] = searchTerm;
                    count++;
                } else {
                    break;
                }
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

    public void showResults() {
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                System.out.println(searchable.getStringRepresentation());
            } else {
                System.out.println("Пусто");
            }
        }
    }
}


