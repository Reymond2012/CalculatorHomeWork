package com.example.sidd.calculator;

import java.io.Serializable;

public class Bus implements Serializable {
    private final String eyeColor;
    private final String hairColor;

    public Bus(String eyeColor, String hairColor) {
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }
}
