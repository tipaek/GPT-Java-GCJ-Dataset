import java.util.HashSet;
import java.util.Scanner;

public class Vest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;
            
            // Read matrix and calculate trace
            for (int row = 0; row < matrixSize; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() < matrixSize) {
                    duplicateRows++;
                }
            }
            
            // Check for duplicate columns
            for (int col = 0; col < matrixSize; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() < matrixSize) {
                    duplicateCols++;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        
        scanner.close();
    }
}