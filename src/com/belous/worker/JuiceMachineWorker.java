package com.belous.worker;

import com.belous.juice.JuicerResult;
import com.belous.juice.JuicerSource;

public interface JuiceMachineWorker {

    void process(JuicerSource source, JuicerResult output);
}
