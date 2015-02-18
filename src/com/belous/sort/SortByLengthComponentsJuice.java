package com.belous.sort;

import com.belous.juice.Juice;

import java.util.Comparator;

public class SortByLengthComponentsJuice implements Comparator<Juice>{

    @Override
    public int compare(Juice o1, Juice o2) {
        return o1.getFruits().length - o2.getFruits().length;
    }
}
