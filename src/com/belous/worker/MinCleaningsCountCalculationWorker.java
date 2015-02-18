package com.belous.worker;

import com.belous.juice.JuicerResult;
import com.belous.juice.JuicerSource;

public class MinCleaningsCountCalculationWorker implements JuiceMachineWorker {

    private MinCleaningCalculator minCleaningCalculator = new MinCleaningCalculatorImpl();
    private Thread runningThread;

    @Override
    public void process(final JuicerSource source, final JuicerResult output) {
        checkWorkerIsBusy();
        runningThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Integer result
                        = source.getJuices().size()
                        - minCleaningCalculator.calculateMinNumberOfCleanings(source.getJuices());
                output.write(result);
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
