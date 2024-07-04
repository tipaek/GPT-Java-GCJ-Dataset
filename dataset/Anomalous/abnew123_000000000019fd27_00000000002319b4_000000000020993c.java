import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Read matrix and calculate trace and row duplicates
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasRowDuplicate = false;
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;

                    if (!rowSet.add(value) && !hasRowDuplicate) {
                        rowDuplicates++;
                        hasRowDuplicate = true;
                    }

                    if (row == col) {
                        trace += value;
                    }
                }
            }

            // Calculate column duplicates
            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasColDuplicate = false;
                for (int row = 0; row < matrixSize; row++) {
                    if (!colSet.add(matrix[row][col]) && !hasColDuplicate) {
                        colDuplicates++;
                        hasColDuplicate = true;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}