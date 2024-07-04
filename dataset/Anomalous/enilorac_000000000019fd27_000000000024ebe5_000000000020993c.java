import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    private static int traceSum = 0, repeatedRows = 0, repeatedCols = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            processMatrix(matrix, t);
            resetCounters();
        }
        
        scanner.close();
    }

    private static void processMatrix(int[][] matrix, int caseNumber) {
        calculateTraceAndDuplicates(matrix);
        System.out.printf("Case #%d: %d %d %d%n", caseNumber + 1, traceSum, repeatedRows, repeatedCols);
    }

    private static void calculateTraceAndDuplicates(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();
            
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    traceSum += matrix[i][j];
                }
                
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }
            
            if (rowSet.size() < matrix.length) {
                repeatedRows++;
            }
            
            if (colSet.size() < matrix.length) {
                repeatedCols++;
            }
        }
    }

    private static void resetCounters() {
        traceSum = 0;
        repeatedRows = 0;
        repeatedCols = 0;
    }
}