package org.skypro.skyshop.product;

import org.skypro.skyshop.exceptions.BestResultNotFound;

public class SearchEngine {
    private final Searchable[] searchables;
    private int size;

    public SearchEngine() {
        this.searchables = new Searchable[10];
        size = 0;
    }

    public Searchable[] searchByKeyword(String keyword) {
        Searchable[] searchResult = new Searchable[5];
        int count = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String searchTerm = searchable.getSearchTerm();
                if (searchTerm.toLowerCase().contains(keyword.toLowerCase())) {
                    if (count >= searchResult.length) {
                        break;
                    }
                    searchResult[count++] = searchable;
                    System.out.println(searchable.getStringRepresentation());
                }
            }
        }
        return searchResult;
    }

    public void addToSearchable(Searchable searchable) {
        if (searchable != null) {
            if (size < searchables.length) {
                searchables[size] = searchable;
                size++;
            } else {
                System.out.println("Массив переполнен");
            }
        }
    }

    public void showSearchable() {
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                System.out.println(searchable.getStringRepresentation());
            }
        }
    }

    public Searchable findBestMatch(String keyword) throws BestResultNotFound {
        Searchable bestResult = null;
        int found = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String str = searchable.getSearchTerm().toLowerCase();
                int score = 0;
                int index = 0;
                while ((index = str.indexOf(keyword.toLowerCase(), index)) != -1) {
                    score++;
                    index++;
                }
                if (score > found) {
                    found = score;
                    bestResult = searchable;
                }
            }
        }
        if (bestResult == null) {
            throw new BestResultNotFound();
        }
        System.out.println(bestResult.getStringRepresentation());
        return bestResult;
    }
}


