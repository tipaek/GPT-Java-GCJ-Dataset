import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; ++k) {
            // Get Rows
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            int[][] colSet = new int[n][n];
            boolean[] isRepeatingCol = new boolean[n];
            int[] rowSet = new int[n];
            boolean isRepeatingRow = false;

            int diagSum = 0;
            int repeatingRow = 0;
            int repeatingCol = 0;

            for (int i = 0; i < n; i++) {
                for (int j=0; j<n; j++) {
                    int val = in.nextInt();
                    if (i==j) {
                        diagSum += val;
                    }

                    if (rowSet[val-1] == -1) {
                        isRepeatingRow = true;
                    } else {
                        rowSet[val-1] = -1;
                    }

                    if (colSet[j][val-1] == -1) {
                        isRepeatingCol[j] = true;
                    } else {
                        colSet[j][val-1] = -1;
                    }

                    arr[i][j] = val;
                }

                if (isRepeatingRow) {
                    repeatingRow++;
                }

                isRepeatingRow = false;
                rowSet = new int[n];
            }

            for (int i=0; i<n; i++) {
                if (isRepeatingCol[i]) {
                    repeatingCol ++;
                }
            }

            System.out.println("Case #" + k + ": " + diagSum + " " + repeatingRow + " " + repeatingCol);
        }
    }
}