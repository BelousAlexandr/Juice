package com.belous.worker;

import com.belous.fruit.Fruit;
import com.belous.juice.Juice;
import com.belous.sort.SortFruitName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinCleaningCalculatorImpl implements MinCleaningCalculator {

    private int[] res;
    private boolean[] usedJuices;
    private int[][] graphJuices;

    @Override
    public int calculateMinNumberOfCleanings(List<Juice> juices) {
        graphJuices = new int[juices.size()][juices.size()];
        List<Juice> tmpJuices = new ArrayList<Juice>();
        for (int index = 0; index < juices.size(); ++index) {
            List<Fruit> tempFruits = juices.get(index).getAllFruits();
            Collections.sort(tempFruits, new SortFruitName());
            tmpJuices.add(new Juice(tempFruits));
        }
        juices = tmpJuices;

        for (int index1 = 0; index1 < juices.size(); ++index1)
            for (int index2 = 0; index2 < juices.size(); ++index2) {
                List<Fruit> tempJuice1 = juices.get(index1).getAllFruits();
                List<Fruit> tempJuice2 = juices.get(index2).getAllFruits();
                int tmpIndex1 = 0;
                int tmpIndex2 = 0;
                while (tmpIndex1 < tempJuice1.size() && tmpIndex2 < tempJuice2.size()) {
                    if (tempJuice1.get(tmpIndex1).getName().compareTo(tempJuice2.get(tmpIndex2).getName()) == 0) {
                        ++tmpIndex1;
                        ++tmpIndex2;
                    } else {
                        ++tmpIndex2;
                    }
                }
                if (tmpIndex1 >= tempJuice1.size() && index1 != index2) {
                    graphJuices[index1][index2] = 1;
                } else {
                    graphJuices[index1][index2] = 0;
                }
            }
        int answer = 0;
        res = new int[juices.size()];
        usedJuices = new boolean[juices.size()];
        for (int i = 0; i < juices.size(); ++i) {
            res[i] = -1;
        }
        for (int i = 0; i < juices.size(); ++i) {

            for (int j = 0; j < juices.size(); ++j) {
                usedJuices[j] = true;
            }

            if (getPair(i, juices) == true) {
                ++answer;
            }

        }
        return answer;
    }

    private boolean getPair(int currentJuice, List<Juice> juices) {
        if (!usedJuices[currentJuice]) {
            return false;
        }
        usedJuices[currentJuice] = false;
        for (int index = 0; index < juices.size(); ++index) {
            if (graphJuices[currentJuice][index] == 0) {
                continue;
            }
            if (res[index] == -1 || getPair(res[index], juices)) {
                res[index] = currentJuice;
                return true;
            }
        }
        return false;
    }
}
