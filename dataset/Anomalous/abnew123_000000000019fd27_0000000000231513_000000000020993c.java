import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Read matrix and calculate trace and row duplicates
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowFlag = true;
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (!rowSet.add(matrix[row][col]) && rowFlag) {
                        rowDuplicates++;
                        rowFlag = false;
                    }
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            // Calculate column duplicates
            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colFlag = true;
                for (int row = 0; row < matrixSize; row++) {
                    if (!colSet.add(matrix[row][col]) && colFlag) {
                        colDuplicates++;
                        colFlag = false;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}