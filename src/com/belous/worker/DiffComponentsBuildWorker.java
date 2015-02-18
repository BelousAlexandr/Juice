package com.belous.worker;

import com.belous.fruit.Fruit;
import com.belous.juice.JuicerResult;
import com.belous.juice.JuicerSource;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class DiffComponentsBuildWorker implements JuiceMachineWorker {
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
                Set<Fruit> juiceSet = new LinkedHashSet<Fruit>();
                for (int i = 0; i < source.getJuices().size(); i++) {
                    Collections.addAll(juiceSet, source.getJuices().get(i).getFruits());
                }
                output.write(juiceSet);
            }
        });
        runningThread.start();
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
