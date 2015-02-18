package com.belous.worker;

import com.belous.juice.Juice;

import java.util.List;

/**
 * Created by s.belous on 18.02.15.
 */
public interface MinCleaningCalculator {

    int calculateMinNumberOfCleanings(List<Juice> juices);
}
