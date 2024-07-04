import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            // n = size of the matrix
            int n = in.nextInt();

            // build matrix
            int[][] matrix = new int[n][n];

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    matrix[x][y] = in.nextInt();
                }
            }

            //printM(matrix);

            // Find k -> trace
            // sum up diag from top left to bottom right
            int k = 0;
            for (int j = 0; j < n; ++j) {
                k = k + matrix[j][j];
            }

            // find r - rows that have repeated elements
            int r = 0;
            for (int x = 0; x < n; x++) {
                int[] row = matrix[x];
                // default value of 0 here
                int[] dupes = new int[n];
                for (int y = 0; y < n; y++) {
                    int check = row[y] - 1;

                    if (dupes[check] == 1) {
                        // if the array at this index is 1
                        // we have seen this number and so this row contains dups
                        // add to count and short circuit
                        r++;
                        break;
                    } else {
                        // number hasn't been seen, so mark as seen and continue
                        dupes[check]++;
                    }
                }
            }

            // find c - cols with repeated elems
            int c = 0;
            int[][] dupes = new int[n][n];
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    int check = matrix[x][y] -1;

                    if (dupes[y][check] == 1) {
                        // if the array at this index is 1
                        // we have seen this number and so this col contains dups
                        // add to count and short circuit
                        c++;
                        break;
                    } else {
                        // number hasn't been seen, so mark as seen and continue
                        dupes[y][check]++;
                    }
                }
            }

            System.out.println("Case #" + i + ": " +
                    Integer.toString(k) + " " +
                    Integer.toString(r) + " " +
                    Integer.toString(c)
            );
        }
    }
}