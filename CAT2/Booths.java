package CAT2;

import java.util.Scanner;

public class Booths {
    public int multiply(int n1, int n2) {
        int m = n1;
        int r = n2;
        int A = n1;
        int S = -n1;
        int P = 0;
        int count = Integer.SIZE;

        while (count > 0) {
            if ((r & 1) == 1) {
                P += A;
                S += m;
            }
            A <<= 1;
            S <<= 1;
            count--;
            r >>= 1;
        }
        return P;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Booths b = new Booths();
        System.out.println("Enter two integer numbers -");
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        int result = b.multiply(n1, n2);
        System.out.println(result);
        scan.close();
    }
}