import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        
        for (int t = 0; t < testCaseCount; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            scanner.nextLine();
            
            for (int i = 0; i < matrixSize; i++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }
            
            int rowCount = 0;
            int colCount = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                if (!isUniqueInColumn(matrix, matrixSize, i)) {
                    colCount++;
                }
                if (!isUniqueInRow(matrix, matrixSize, i)) {
                    rowCount++;
                }
            }
            
            int matrixTrace = calculateTrace(matrix, matrixSize);
            int caseNumber = t + 1;
            System.out.println("Case #" + caseNumber + ": " + matrixTrace + " " + rowCount + " " + colCount);
        }
    }
    
    private static int calculateTrace(int[][] matrix, int size) {
        int traceSum = 0;
        for (int i = 0; i < size; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }
    
    private static boolean isUniqueInColumn(int[][] matrix, int size, int column) {
        HashSet<Integer> uniqueValues = new HashSet<>();
        for (int i = 0; i < size; i++) {
            uniqueValues.add(matrix[i][column]);
        }
        return uniqueValues.size() == size;
    }
    
    private static boolean isUniqueInRow(int[][] matrix, int size, int row) {
        HashSet<Integer> uniqueValues = new HashSet<>();
        for (int i = 0; i < size; i++) {
            uniqueValues.add(matrix[row][i]);
        }
        return uniqueValues.size() == size;
    }
}