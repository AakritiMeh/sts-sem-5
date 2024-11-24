package CAT1;

import java.io.*;

public class eulerphi {
    static int phi(int n) {
        float result = n;
        for (int p = 2; p * p <= n; ++p) {
            if (n % p == 0) {
                while (n % p == 0)
                    n /= p;
                result *= (1.0 - (1.0 / (float) p));
            }
        }
        if (n > 1)
            result -= result / n;
        return (int) result;
    }

    public static void main(String args[]) {
        int n = 16;
        System.out.println("phi(" + n + ") = " + phi(n));
    }
}
