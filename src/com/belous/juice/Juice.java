package com.belous.juice;

import com.belous.fruit.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Juice implements Comparator<Fruit[]>{
    private Fruit[] fruits;

    public Fruit[] getFruits() {
        return fruits;
    }

    public Juice(Fruit[] fruits) {
        this.fruits = fruits;
    }

    public Juice(List<Fruit> fruits) {
        this.fruits = new Fruit [fruits.size()];
        for (int index = 0; index < fruits.size(); ++index) {
            this.fruits[index] = fruits.get(index);
        }
    }

    public List<Fruit> getAllFruits() {
        List<Fruit> fruitList = new ArrayList<Fruit>();
        for (int index = 0; index < fruits.length; ++index) {
            fruitList.add(fruits[index]);
        }
        return fruitList;
    }

    @Override
    public String toString() {
        return String.format("Juice{fruit: %s}", Arrays.toString(fruits));
    }

    @Override
    public int compare(Fruit[] o1, Fruit[] o2) {
        return o1.length - o2.length;
    }
}
