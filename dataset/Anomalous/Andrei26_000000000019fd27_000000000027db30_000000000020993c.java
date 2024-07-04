import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public final class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0;
            Set<Integer> uniqueElements = new HashSet<>();
            int repeatedRows = 0;

            for (int row = 0; row < matrixSize; row++) {
                boolean hasDuplicate = false;
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }

                uniqueElements.clear();
                for (int col = 0; col < matrixSize; col++) {
                    if (!uniqueElements.add(matrix[row][col])) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    repeatedRows++;
                }
            }

            int repeatedCols = 0;
            for (int col = 0; col < matrixSize; col++) {
                boolean hasDuplicate = false;
                uniqueElements.clear();
                for (int row = 0; row < matrixSize; row++) {
                    if (!uniqueElements.add(matrix[row][col])) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    repeatedCols++;
                }
            }

            System.out.println("Case #" + caseIndex + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
        }
    }
}