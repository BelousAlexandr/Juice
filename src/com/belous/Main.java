package com.belous;

import com.belous.juice.FileJuicerSource;
import com.belous.juice.JuiceMachine;

public class Main {
    public static void main(String[] args) {
        JuiceMachine juiceMachine = new JuiceMachine();
        juiceMachine.processJuices(new FileJuicerSource("juice.in"));
    }
}