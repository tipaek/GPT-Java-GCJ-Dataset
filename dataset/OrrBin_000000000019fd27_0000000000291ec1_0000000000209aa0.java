import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();

            if (k % n != 0) {
                System.out.println(String.format("Case #%d: %s", i, "IMPOSSIBLE"));
                continue;
            }

            System.out.println(String.format("Case #%d: %s", i, "POSSIBLE"));
            createLatin(n, k / n - 1);
        }
    }


    static void createLatin(int n, int colSwitches) {
        int[][] latin = new int[n][n];


        int start = 1;
        for (int row = 0; row < n; row++) {
            latin[row][0] = start;
            start++;
            if (start > n)
                start = start - n;
        }

        for (int col = n - 1; col > 0; col--) {
            start = n - col + 1;
            for (int row = 0; row < n; row++) {
                latin[row][col] = start;
                start++;
                if (start > n)
                    start = start - n;
            }
        }

        if (colSwitches > 0) {
            interchangeCols(latin, 0, n-1);
            for (int i = 0; i < colSwitches - 1; i++) {
                interchangeCols(latin, i, i + 1);
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(latin[row][col] + " ");
            }
            System.out.println();
        }

    }

    static void interchangeCols(int m[][], int a, int b) {
        int n = m.length;

        for (int i = 0; i < n; i++) {
            int t = m[i][a];
            m[i][a] = m[i][b];
            m[i][b] = t;
        }
    }
}