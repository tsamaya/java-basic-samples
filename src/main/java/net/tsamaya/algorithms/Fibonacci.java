package net.tsamaya.algorithms;

/**
 * Created by tsamaya on 28/01/16.
 */
public class Fibonacci {

    public static long compute(int n) {
        if (n <= 1) return n;
        else return compute(n-1) + compute(n-2);
    }
}
