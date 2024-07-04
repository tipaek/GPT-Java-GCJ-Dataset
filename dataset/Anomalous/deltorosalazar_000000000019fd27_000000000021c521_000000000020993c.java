import java.util.*;
import java.io.*;

class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; ++caseNumber) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            int trace = 0;
            int rowsWithRepeatedNumbers = 0;
            int columnsWithRepeatedNumbers = 0;

            Set<Integer>[] rowSets = new HashSet[matrixSize];
            Set<Integer>[] columnSets = new HashSet[matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                rowSets[i] = new HashSet<>();
                columnSets[i] = new HashSet<>();
            }

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;

                    if (row == col) {
                        trace += value;
                    }

                    if (!rowSets[row].add(value)) {
                        rowsWithRepeatedNumbers++;
                        rowSets[row].clear();
                    }

                    if (!columnSets[col].add(value)) {
                        columnsWithRepeatedNumbers++;
                        columnSets[col].clear();
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowsWithRepeatedNumbers + " " + columnsWithRepeatedNumbers);
        }
    }
}