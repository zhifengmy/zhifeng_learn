package com.ludas;

import java.math.BigDecimal;

public class Test {


    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(1);
        reBigDecimal(bigDecimal);
        System.out.printf(bigDecimal.toString());
    }

    public static void reBigDecimal(BigDecimal a) {
        a.add(new BigDecimal(3));
    }

    public static void reString(String a) {
        a = "bbb";
    }
}
