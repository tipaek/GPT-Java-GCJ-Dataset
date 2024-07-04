import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numCases; i++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                String[] rowNumbers = scanner.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(rowNumbers[col]);
                }
            }

            int trace = calculateMatrixTrace(matrixSize, matrix);
            int repeatedInRows = countRepeatedInRows(matrixSize, matrix);
            int repeatedInCols = countRepeatedInCols(matrixSize, matrix);

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + repeatedInRows + " " + repeatedInCols);
        }
    }

    static int calculateMatrixTrace(int matrixSize, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrixSize; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    static int countRepeatedInRows(int matrixSize, int[][] matrix) {
        int repeatedInRows = 0;
        for (int row = 0; row < matrixSize; row++) {
            Set<Integer> uniqueNumbers = new HashSet<>();
            for (int col = 0; col < matrixSize; col++) {
                if (!uniqueNumbers.add(matrix[row][col])) {
                    repeatedInRows++;
                    break;
                }
            }
        }
        return repeatedInRows;
    }

    static int countRepeatedInCols(int matrixSize, int[][] matrix) {
        int repeatedInCols = 0;
        for (int col = 0; col < matrixSize; col++) {
            Set<Integer> uniqueNumbers = new HashSet<>();
            for (int row = 0; row < matrixSize; row++) {
                if (!uniqueNumbers.add(matrix[row][col])) {
                    repeatedInCols++;
                    break;
                }
            }
        }
        return repeatedInCols;
    }
}