import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int[] results = analyzeLatinSquare(n, matrix);
            System.out.println(formatOutput(caseNumber, results));
        }
    }

    private static String formatOutput(int caseNumber, int[] results) {
        StringBuilder output = new StringBuilder("Case #" + caseNumber + ": ");
        for (int result : results) {
            output.append(result).append(" ");
        }
        return output.toString().trim();
    }

    private static int[] analyzeLatinSquare(int size, int[][] matrix) {
        Map<Integer, Set<Integer>> rowTracker = new HashMap<>();
        Map<Integer, Set<Integer>> colTracker = new HashMap<>();
        boolean[] rowDuplicates = new boolean[size];
        boolean[] colDuplicates = new boolean[size];

        int[] results = new int[3];

        for (int i = 0; i < size; i++) {
            rowTracker.putIfAbsent(i, new HashSet<>());
            for (int j = 0; j < size; j++) {
                int value = matrix[i][j];

                colTracker.putIfAbsent(j, new HashSet<>());

                if (rowTracker.get(i).contains(value) && !rowDuplicates[i]) {
                    results[1]++;
                    rowDuplicates[i] = true;
                } else {
                    rowTracker.get(i).add(value);
                }

                if (colTracker.get(j).contains(value) && !colDuplicates[j]) {
                    results[2]++;
                    colDuplicates[j] = true;
                } else {
                    colTracker.get(j).add(value);
                }

                if (i == j) {
                    results[0] += value;
                }
            }
        }
        return results;
    }
}