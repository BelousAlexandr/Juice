package com.belous.juice;

import com.belous.worker.ComponentsSortWorker;
import com.belous.worker.DiffComponentsBuildWorker;
import com.belous.worker.JuiceMachineWorker;
import com.belous.worker.MinCleaningsCountCalculationWorker;

import java.util.Arrays;
import java.util.List;

public class JuiceMachine {
    private List<JuiceMachineWorker> workers = Arrays
            .asList(new DiffComponentsBuildWorker(), new ComponentsSortWorker(),
                    new MinCleaningsCountCalculationWorker());

    public void processJuices(JuicerSource source) {
        int i = 0;
        for (JuiceMachineWorker worker : workers) {
            worker.process(source, new FileJuicerResult(String.format("juice%s.out", ++i)));
        }
    }
}
