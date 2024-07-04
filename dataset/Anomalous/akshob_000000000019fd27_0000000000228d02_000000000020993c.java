import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputs = sc.nextInt();

        for (int i = 0; i < inputs; i++) {
            int arraySize = sc.nextInt();
            int[][] matrix = new int[arraySize][arraySize];

            for (int row = 0; row < arraySize; row++) {
                for (int col = 0; col < arraySize; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }

            analyzeMatrix(matrix, arraySize, i + 1);
        }
    }

    private static void analyzeMatrix(int[][] matrix, int size, int caseNumber) {
        int diagonalSum = 0;
        int repeatedRows = 0;
        int repeatedCols = 0;

        // Calculate the diagonal sum
        for (int i = 0; i < size; i++) {
            diagonalSum += matrix[i][i];
        }

        // Check for repeated elements in rows
        for (int row = 0; row < size; row++) {
            if (hasRepeatedElements(matrix[row])) {
                repeatedRows++;
            }
        }

        // Check for repeated elements in columns
        for (int col = 0; col < size; col++) {
            int[] column = new int[size];
            for (int row = 0; row < size; row++) {
                column[row] = matrix[row][col];
            }
            if (hasRepeatedElements(column)) {
                repeatedCols++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
    }

    private static boolean hasRepeatedElements(int[] array) {
        Map<Integer, Boolean> elementMap = new HashMap<>();
        for (int element : array) {
            if (elementMap.containsKey(element)) {
                return true;
            }
            elementMap.put(element, true);
        }
        return false;
    }
}