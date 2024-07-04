import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = sc.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            // Reading the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            int trace = 0;
            int rowViolations = 0;
            int colViolations = 0;
            
            // Calculating trace
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }
            
            // Checking row violations
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != matrixSize) {
                    rowViolations++;
                }
            }
            
            // Checking column violations
            for (int j = 0; j < matrixSize; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < matrixSize; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != matrixSize) {
                    colViolations++;
                }
            }
            
            // Printing the result for the current test case
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowViolations + " " + colViolations);
        }
    }
}