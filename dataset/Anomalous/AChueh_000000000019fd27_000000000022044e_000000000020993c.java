import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final boolean DEBUG = false;
        Scanner scanner = null;

        try {
            scanner = DEBUG ? new Scanner(new FileInputStream("test.in")) : new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int[] results = calculateVestigium(matrix);
            System.out.printf("Case #%d: %d %d %d%n", t, results[0], results[1], results[2]);
        }

        scanner.close();
    }

    private static int[] calculateVestigium(int[][] matrix) {
        int trace = 0;
        int rowRepeats = 0;
        int columnRepeats = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                rowRepeats++;
            }
        }

        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                columnRepeats++;
            }
        }

        return new int[]{trace, rowRepeats, columnRepeats};
    }

    private static boolean hasDuplicates(int[] array) {
        HashMap<Integer, Boolean> seen = new HashMap<>();
        for (int value : array) {
            if (seen.containsKey(value)) {
                return true;
            }
            seen.put(value, true);
        }
        return false;
    }
}