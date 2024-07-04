import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int row = 0; row < matrixSize; row++) {
                boolean[] rowCheck = new boolean[matrixSize];
                boolean rowHasDuplicate = false;
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;

                    if (!rowHasDuplicate && rowCheck[value - 1]) {
                        rowDuplicates++;
                        rowHasDuplicate = true;
                    }
                    rowCheck[value - 1] = true;

                    if (row == col) {
                        trace += value;
                    }
                }
            }

            for (int col = 0; col < matrixSize; col++) {
                boolean[] colCheck = new boolean[matrixSize];
                for (int row = 0; row < matrixSize; row++) {
                    int value = matrix[row][col];
                    if (colCheck[value - 1]) {
                        colDuplicates++;
                        break;
                    }
                    colCheck[value - 1] = true;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}