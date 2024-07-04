import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, matrixSize);
            int rowRepeats = countRowRepeats(matrix, matrixSize);
            int columnRepeats = countColumnRepeats(matrix, matrixSize);

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + columnRepeats);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowRepeats(int[][] matrix, int size) {
        int rowRepeats = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> rowValues = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowValues.add(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
            }
        }
        return rowRepeats;
    }

    private static int countColumnRepeats(int[][] matrix, int size) {
        int columnRepeats = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> columnValues = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!columnValues.add(matrix[j][i])) {
                    columnRepeats++;
                    break;
                }
            }
        }
        return columnRepeats;
    }
}