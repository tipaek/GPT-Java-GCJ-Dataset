import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            long trace = 0;
            int rowCount = 0;
            int colCount = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < matrixSize) {
                    rowCount++;
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < matrixSize; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < matrixSize; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() < matrixSize) {
                    colCount++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}