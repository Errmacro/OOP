package org.skypro.skyshop.product;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchables;
    private int size;

    public SearchEngine() {
        searchables = new ArrayList<>();
    }

    public List<Searchable> searchByKeyword(String keyword) {
        List<Searchable> searchResult = new ArrayList<>();
        System.out.println("Результаты поиска: ");
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String searchTerm = searchable.getSearchTerm();
                if (searchTerm.toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println(searchable.getStringRepresentation());
                }
            }
        }
        return searchResult;
    }

    public void addToSearchable(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable);
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


