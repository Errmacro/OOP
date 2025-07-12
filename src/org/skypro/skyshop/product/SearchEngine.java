package org.skypro.skyshop.product;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchables;
    private int size;

    public SearchEngine() {
        searchables = new HashSet<>();
    }

    public Set<Searchable> searchByKeyword(String keyword) {
        return searchables.stream()
                .filter(searchable -> searchable != null &&
                        searchable.getSearchTerm().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
    }

    public void addToSearchable(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable);
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


