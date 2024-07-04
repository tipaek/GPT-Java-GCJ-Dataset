import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scn.nextInt();
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scn.nextInt();
                }
            }

            ArrayList<Long> result = calculateTraceAndDuplicates(matrix, n);
            long trace = result.get(0);
            long duplicateRows = result.get(1);
            long duplicateCols = result.get(2);

            System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static ArrayList<Long> calculateTraceAndDuplicates(int[][] matrix, int n) {
        long trace = 0;
        long duplicateRows = 0;
        long duplicateCols = 0;

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }
            if (hasDuplicates(getColumn(matrix, i))) {
                duplicateCols++;
            }
        }

        ArrayList<Long> results = new ArrayList<>();
        results.add(trace);
        results.add(duplicateRows);
        results.add(duplicateCols);

        return results;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int n = matrix.length;
        int[] column = new int[n];
        for (int i = 0; i < n; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}