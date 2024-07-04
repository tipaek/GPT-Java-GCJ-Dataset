import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] rowCounts = new int[matrixSize][matrixSize];
            int[][] colCounts = new int[matrixSize][matrixSize];
            HashMap<Integer, Boolean> duplicateRows = new HashMap<>();
            HashMap<Integer, Boolean> duplicateCols = new HashMap<>();
            int diagonalSum = 0;

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += value;
                    }
                    rowCounts[row][value - 1]++;
                    colCounts[col][value - 1]++;

                    if (rowCounts[row][value - 1] > 1 && !duplicateRows.containsKey(row)) {
                        duplicateRows.put(row, true);
                    }
                    if (colCounts[col][value - 1] > 1 && !duplicateCols.containsKey(col)) {
                        duplicateCols.put(col, true);
                    }
                }
            }

            System.out.println(diagonalSum + " " + duplicateRows.size() + " " + duplicateCols.size());
        }

        scanner.close();
    }
}