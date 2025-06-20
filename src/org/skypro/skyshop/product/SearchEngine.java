package org.skypro.skyshop.product;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final Map<String,List<Searchable>> searchables;
    private int size;

    public SearchEngine() {
        searchables = new TreeMap<>();
    }

    public Map<String,List<Searchable>> searchByKeyword(String keyword) {
        Map<String,List<Searchable>> searchResult = new TreeMap<>();
        System.out.println("Результаты поиска: ");
        for (List<Searchable> productList : searchables.values()) {
            for (Searchable searchable : productList) {
                if (searchable != null) {
                    String searchTerm = searchable.getSearchTerm();
                    if (searchTerm.toLowerCase().contains(keyword.toLowerCase())) {
                        System.out.println(searchable.getStringRepresentation());
                    }
                }
            }
        }
        return searchResult;
    }

    public void addToSearchable(String name, Searchable searchable) {
        if (searchable != null) {
            List<Searchable> productList = searchables.getOrDefault(name, new ArrayList<>());
            productList.add(searchable);
            searchables.put(name, productList);
        }
    }

    public void showSearchable() {
        for (Map.Entry<String, List<Searchable>> entry : searchables.entrySet()) {
            String name = entry.getKey();
            List<Searchable> searchableList = entry.getValue();
            System.out.println(name+": ");
            for (Searchable searchable : searchableList) {
                System.out.println(" - " + searchable);
            }
        }
    }

    public Searchable findBestMatch(String keyword) throws BestResultNotFound {
        Searchable bestResult = null;
        int found = 0;
        for (List<Searchable> productList : searchables.values()) {
            for (Searchable searchable : productList) {
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
        }
        if (bestResult == null) {
            throw new BestResultNotFound();
        }
        System.out.println(bestResult.getStringRepresentation());
        return bestResult;
    }
}


