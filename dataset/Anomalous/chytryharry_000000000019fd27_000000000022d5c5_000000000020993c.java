import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            System.out.println("Case #" + i + ": " + analyzeMatrix(matrix, matrixSize));
        }
    }

    public static String analyzeMatrix(int[][] matrix, int matrixSize) {
        int trace = 0;
        int repeatedRows = 0;
        int repeatedColumns = 0;

        // Calculate the trace of the matrix
        for (int i = 0; i < matrixSize; i++) {
            trace += matrix[i][i];
        }

        // Check for repeated elements in rows
        for (int i = 0; i < matrixSize; i++) {
            if (hasRepeatedElements(matrix[i])) {
                repeatedRows++;
            }
        }

        // Check for repeated elements in columns
        for (int i = 0; i < matrixSize; i++) {
            int[] column = new int[matrixSize];
            for (int j = 0; j < matrixSize; j++) {
                column[j] = matrix[j][i];
            }
            if (hasRepeatedElements(column)) {
                repeatedColumns++;
            }
        }

        return trace + " " + repeatedRows + " " + repeatedColumns;
    }

    private static boolean hasRepeatedElements(int[] array) {
        Set<Integer> elements = new HashSet<>();
        for (int value : array) {
            if (!elements.add(value)) {
                return true;
            }
        }
        return false;
    }
}