import java.util.*;

public class wanrsdroff {
    static int N;
    static int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

    static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N
                && sol[x][y] == -1);
    }

    static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    static boolean solveKT() {
        int sol[][] = new int[N][N];

        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;

        sol[0][0] = 0;

        if (!solveKTUtil(0, 0, 1, sol)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printSolution(sol);

        return true;
    }

    static boolean solveKTUtil(int x, int y, int movei,
            int sol[][]) {
        int k, next_x, next_y;
        if (movei == N * N)
            return true;

        for (k = 0; k < N; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1,
                        sol))
                    return true;
                else
                    sol[next_x][next_y] = -1;
            }
        }

        return false;
    }

    /* Driver Code */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the chessboard (N):");
        N = scanner.nextInt();
        // Function Call
        solveKT();
        scanner.close();
    }
}
// This code is contributed by Abhishek Shankhadhar