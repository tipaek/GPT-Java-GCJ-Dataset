import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            int[] results = calculateVestigium(matrix);
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, results[0], results[1], results[2]);
        }
    }

    private static int[] calculateVestigium(int[][] matrix) {
        int[] results = new int[3];
        int size = matrix.length;

        // Calculate the trace
        for (int i = 0; i < size; i++) {
            results[0] += matrix[i][i];
        }

        // Check for duplicate values in rows and columns
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                results[1]++;
            }
            if (hasDuplicatesInColumn(matrix, i)) {
                results[2]++;
            }
        }

        return results;
    }

    private static boolean hasDuplicates(int[] array) {
        HashSet<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDuplicatesInColumn(int[][] matrix, int columnIndex) {
        HashSet<Integer> seen = new HashSet<>();
        for (int[] row : matrix) {
            if (!seen.add(row[columnIndex])) {
                return true;
            }
        }
        return false;
    }
}