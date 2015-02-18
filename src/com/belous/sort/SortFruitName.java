package com.belous.sort;

import com.belous.fruit.Fruit;

import java.util.Comparator;

public class SortFruitName implements Comparator<Fruit>{

    @Override
    public int compare(Fruit fruit1, Fruit fruit2) {
        return fruit1.getName().compareTo(fruit2.getName());
    }
}
