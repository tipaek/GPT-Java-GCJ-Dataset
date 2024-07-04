import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = generateMatrix(n, k);

            if (matrix == null) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                for (int[] row : matrix) {
                    for (int value : row) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static int[][] generateMatrix(int n, int k) {
        int attempts = 0;
        int[][] matrix = new int[n][n];
        Random random = new Random();

        while (attempts < 500000) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 1 + random.nextInt(n);
                }
            }

            if (countRepeatedRows(matrix) == 0 && countRepeatedColumns(matrix) == 0 && calculateTrace(matrix) == k) {
                return matrix;
            }

            attempts++;
        }

        return null;
    }

    public static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int countRepeatedRows(int[][] matrix) {
        int count = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int[] row : matrix) {
            for (int value : row) {
                frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
            }

            if (frequencyMap.values().stream().anyMatch(freq -> freq > 1)) {
                count++;
            }

            frequencyMap.clear();
        }

        return count;
    }

    public static int countRepeatedColumns(int[][] matrix) {
        int count = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                frequencyMap.put(matrix[row][col], frequencyMap.getOrDefault(matrix[row][col], 0) + 1);
            }

            if (frequencyMap.values().stream().anyMatch(freq -> freq > 1)) {
                count++;
            }

            frequencyMap.clear();
        }

        return count;
    }
}