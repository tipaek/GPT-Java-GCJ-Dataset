import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                    matrix[rowIndex][colIndex] = scanner.nextInt();
                    if (rowIndex == colIndex) {
                        trace += matrix[rowIndex][colIndex];
                    }
                    if (!rowHasDuplicate && !rowSet.add(matrix[rowIndex][colIndex])) {
                        duplicateRows++;
                        rowHasDuplicate = true;
                    }
                }
            }

            for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                    if (!colHasDuplicate && !colSet.add(matrix[rowIndex][colIndex])) {
                        duplicateCols++;
                        colHasDuplicate = true;
                    }
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}