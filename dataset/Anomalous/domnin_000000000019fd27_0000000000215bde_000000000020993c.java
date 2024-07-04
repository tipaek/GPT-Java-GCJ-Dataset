import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int matrixSize = scanner.nextInt();
            int rowDuplicates = 0, colDuplicates = 0, traceSum = 0;

            int[][] matrix = new int[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        traceSum += matrix[row][col];
                    }
                }
            }

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() < matrixSize) {
                    rowDuplicates++;
                }
            }

            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() < matrixSize) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + caseNumber++ + ": " + traceSum + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}