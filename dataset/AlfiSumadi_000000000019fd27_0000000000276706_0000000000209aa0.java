import java.util.*;
import java.io.*;
/**
 * Solution
 */

public class Solution {
    static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        long t = sc.nextLong();
        for (int x = 1; x <= t; x++) {
            solve(x);
        }
    }

    private static void solve(long x) {
        int n = sc.nextInt(), k = sc.nextInt();
        boolean possible = false;
        
        if (n == 1) {
            if (k != 1) possible = false;
        } 
        else {

        }

        int sq[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = 0;
                if (i==j) num = 1;
                else if (j > i) num = n - j + 1 + i ;
                else num = 1 + i - j;
                sq[i][j] = num;
            }
        }

        int i = 0;
        Random r = new Random();
        while (trace(sq) != k && i < 1000) {
            int randX = r.nextInt(n);
            int randY = r.nextInt(n);
            swapRow(sq, randX, randY);
            if (trace(sq) == k) {
                possible = true;
                break;
            }
            int randX2 = r.nextInt(n);
            int randY2 = r.nextInt(n);
            swapCol(sq, randX2, randY2);
            if (trace(sq) == k) {
                possible = true;
                break;
            }
            ++i;
        }


        if (possible) {
            System.out.println("Case #" + x + ": POSSIBLE");
            printSq(sq);
        }
        else {
            System.out.println("Case #" + x + ": IMPOSSIBLE");
        }
    }

    private static long trace(int[][] sq) {
        long sum = 0;
        for(int i = 0; i < sq.length; i++) {
            sum += sq[i][i];
        }
        return sum;
    }

    private static void swapRow(int[][] sq, int r1, int r2) {
        int[] temp = sq[r2].clone();
        sq[r2] = sq[r1];
        sq[r1] = temp;
    }

    private static void swapCol(int[][] sq, int c1, int c2) {
        for (int i = 0; i < sq.length; i++) {
            int[] currentRow = sq[i];
            int temp = currentRow[c1];
            currentRow[c1] = currentRow[c2];
            currentRow[c2] = temp;
        }
    }

    private static void printSq(int[][] sq) {
        for (int i = 0; i < sq.length; i++) {
            for (int j = 0; j < sq.length; j++) {
                System.out.print(sq[i][j] + " ");
            }
            System.out.println("");
        }
    }
}