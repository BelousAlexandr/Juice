package com.belous.worker;

import com.belous.juice.*;

/**
 * Created by s.belous on 18.02.15.
 */
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
