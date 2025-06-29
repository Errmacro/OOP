package org.skypro.skyshop.product;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        int lengthComparison = Integer.compare(s2.getSearchTerm().length(), s1.getSearchTerm().length());
        if (lengthComparison == 0) {
            return s1.getSearchTerm().compareTo(s2.getSearchTerm());
        }
        return lengthComparison;
    }
}
