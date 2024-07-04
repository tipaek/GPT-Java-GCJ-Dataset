import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n * n; j++) {
                int row = j / n;
                int column = j % n;
                matrix[row][column] = in.nextInt();
            }
            Vestigium solution = new Vestigium(n, matrix);
            System.out.println("Case #" + i + ": " + (solution.getTrace())
                    + " " + (solution.getRepeatedElementsRowCount())
                    + " " + (solution.getRepeatedElementsColumnCount()));
        }
    }

    private static class Vestigium {
        private int n;
        private int[][] matrix;

        Vestigium(int n, int[][] matrix) {
            this.n = n;
            this.matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                System.arraycopy(matrix[i], 0, this.matrix[i], 0, n);
            }
        }

        int getTrace() {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += matrix[i][i];
            }
            return sum;
        }

        int getRepeatedElementsRowCount() {
            int count = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.clear();
                for (int j = 0; j < n; j++) {
                    int value = matrix[i][j];
                    if (set.contains(value)) {
                        count++;
                        break;
                    } else {
                        set.add(value);
                    }
                }
            }
            return count;
        }

        int getRepeatedElementsColumnCount() {
            int count = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.clear();
                for (int j = 0; j < n; j++) {
                    int value = matrix[j][i];
                    if (set.contains(value)) {
                        count++;
                        break;
                    } else {
                        set.add(value);
                    }
                }
            }
            return count;
        }
    }
}