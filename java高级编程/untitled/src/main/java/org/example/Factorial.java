package org.example;

public class Factorial {

    public static long fact(long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
            if(i>20){
                throw new ArithmeticException();

            }
        }
        return r;
    }

}



