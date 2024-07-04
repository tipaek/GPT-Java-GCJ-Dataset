import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine();

            int trace = 0;
            int repeatRows = 0;
            int repeatCols = 0;

            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                String[] rowElements = scanner.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(rowElements[col]);
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowRepeatFound = false;
                boolean colRepeatFound = false;

                for (int col = 0; col < matrixSize; col++) {
                    if (!rowRepeatFound && !rowSet.add(matrix[row][col])) {
                        repeatRows++;
                        rowRepeatFound = true;
                    }

                    if (!colRepeatFound && !colSet.add(matrix[col][row])) {
                        repeatCols++;
                        colRepeatFound = true;
                    }
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + repeatRows + " " + repeatCols);
        }
    }
}