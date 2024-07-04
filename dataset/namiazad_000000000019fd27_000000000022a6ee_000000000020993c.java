import java.util.*;
import java.io.*;

public class Solution {
    private static int trace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) trace += matrix[i][j];
            }
        }
        return trace;
    }

    private static int rowWithRepeated(int[][] matrix) {
        int counter = 0;

        for (int[] ints : matrix) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                set.add(ints[j]);
            }
            if (set.size() < matrix.length) counter++;
        }

        return counter;
    }

    private static int columnWithRepeated(int[][] matrix) {
        int counter = 0;

        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int[] ints : matrix) {
                set.add(ints[i]);
            }
            if (set.size() < matrix.length) counter++;
        }

        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= t; ++testCase) {
            int N = in.nextInt();

            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            int trace = trace(matrix);


            System.out.println(String.format("Case #%d: %d %d %d",
                    testCase, trace, rowWithRepeated(matrix), columnWithRepeated(matrix)));
        }
    }
}
  