package com.belous.worker;

import com.belous.fruit.Fruit;
import com.belous.juice.JuicerResult;
import com.belous.juice.JuicerSource;
import com.belous.sort.SortFruitName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComponentsSortWorker implements JuiceMachineWorker {

    private Thread runningThread;

    /**
     * Processes juices source
     *
     * @param source source
     * @param output output
     */
    @Override
    public void process(final JuicerSource source, final JuicerResult output) {
        checkWorkerIsBusy();
        runningThread = new Thread(new Runnable() {
            @Override
            public void run() {
                List<Fruit> fruitList = new ArrayList<>();
                for (int i = 0; i < source.getJuices().size(); i++) {
                    Collections.addAll(fruitList, source.getJuices().get(i).getFruits());
                }
                Collections.sort(fruitList, new SortFruitName());
                output.write(fruitList);
            }
        });
        runningThread.start();
        runningThread.interrupt();
    }

    private void checkWorkerIsBusy() {
        if (runningThread != null && runningThread.isAlive()) {
            try {
                runningThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
