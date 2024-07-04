import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTestCases; ++testCase) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;
            int numberOfRowRepeats = 0;
            int numberOfColumnRepeats = 0;

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasRepeat = false;
                for (int column = 0; column < matrixSize; column++) {
                    int value = scanner.nextInt();
                    matrix[row][column] = value;
                    if (row == column) {
                        trace += value;
                    }
                    if (!rowSet.add(value)) {
                        rowHasRepeat = true;
                    }
                }
                if (rowHasRepeat) {
                    numberOfRowRepeats++;
                }
            }

            for (int column = 0; column < matrixSize; column++) {
                Set<Integer> columnSet = new HashSet<>();
                boolean columnHasRepeat = false;
                for (int row = 0; row < matrixSize; row++) {
                    if (!columnSet.add(matrix[row][column])) {
                        columnHasRepeat = true;
                    }
                }
                if (columnHasRepeat) {
                    numberOfColumnRepeats++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + numberOfRowRepeats + " " + numberOfColumnRepeats);
        }
    }
}