package com.lunna.insight.Core.commons;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Rounder {
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
