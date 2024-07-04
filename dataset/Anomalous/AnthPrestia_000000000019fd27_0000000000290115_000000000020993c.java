import java.util.*;
import java.io.*;

public class Vestigium {

    public static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumns = 0;

        for (int col = 0; col < size; col++) {
            Set<Integer> columnElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                columnElements.add(matrix[row][col]);
            }
            if (columnElements.size() < size) {
                duplicateColumns++;
            }
        }

        return duplicateColumns;
    }

    public static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;

        for (int row = 0; row < size; row++) {
            Set<Integer> rowElements = new HashSet<>();
            for (int col = 0; col < size; col++) {
                rowElements.add(matrix[row][col]);
            }
            if (rowElements.size() < size) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix, matrixSize);
            int duplicateRows = countDuplicateRows(matrix, matrixSize);
            int duplicateColumns = countDuplicateColumns(matrix, matrixSize);
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}