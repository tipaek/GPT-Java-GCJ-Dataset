import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;
            HashSet<String> columnChecker = new HashSet<>();
            boolean[] columnHasRepeats = new boolean[matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                HashSet<Integer> rowChecker = new HashSet<>();
                boolean rowHasRepeats = false;

                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;

                    if (rowChecker.contains(value)) {
                        rowHasRepeats = true;
                    } else {
                        rowChecker.add(value);
                    }

                    String columnKey = (char) (caseNumber + 97) + "" + value;
                    if (columnChecker.contains(columnKey)) {
                        columnHasRepeats[col] = true;
                    } else {
                        columnChecker.add(columnKey);
                    }

                    if (row == col) {
                        diagonalSum += value;
                    }
                }

                if (rowHasRepeats) {
                    repeatedRows++;
                }
            }

            for (boolean colRepeat : columnHasRepeats) {
                if (colRepeat) {
                    repeatedColumns++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}