import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            int diagSum = 0;
            for (int i = 0; i < n; i++) {
                diagSum += matrix[i][i];
            }
            int rowCount = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> found = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (found.contains(matrix[i][j])) {
                        rowCount++;
                        break;
                    }
                    found.add(matrix[i][j]);
                }
            }
            int colCount = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> found = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (found.contains(matrix[i][j])) {
                        colCount++;
                        break;
                    }
                    found.add(matrix[i][j]);
                }
            }
            System.out.println("Case #" + t + ": " + diagSum + " " + rowCount + " " + colCount);
        }
    }
}