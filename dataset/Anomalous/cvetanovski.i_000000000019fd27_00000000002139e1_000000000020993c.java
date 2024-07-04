import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        int[][] results = new int[testCases][3];

        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int diagonalSum = 0;
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int cellValue = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += cellValue;
                    }
                    matrix[row][col] = cellValue;
                }
            }

            results[t][0] = diagonalSum;

            for (int index = 0; index < matrixSize; index++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();

                for (int innerIndex = 0; innerIndex < matrixSize; innerIndex++) {
                    rowSet.add(matrix[index][innerIndex]);
                    colSet.add(matrix[innerIndex][index]);
                }

                if (rowSet.size() < matrixSize) {
                    results[t][1]++;
                }
                if (colSet.size() < matrixSize) {
                    results[t][2]++;
                }
            }
        }

        for (int t = 0; t < testCases; t++) {
            System.out.printf("Case #%d: %d %d %d%n", t + 1, results[t][0], results[t][1], results[t][2]);
        }

        scanner.close();
    }
}