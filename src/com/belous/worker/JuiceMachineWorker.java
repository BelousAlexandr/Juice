package com.belous.worker;

import com.belous.juice.JuicerResult;
import com.belous.juice.JuicerSource;

/**
 * Created by s.belous on 18.02.15.
 */
public interface JuiceMachineWorker {

    void process(JuicerSource source, JuicerResult output);
}
