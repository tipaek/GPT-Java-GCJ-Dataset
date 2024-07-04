import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int trace = 0;
            int rowCount = 0;
            int colCount = 0;
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n];
                boolean[] colCheck = new boolean[n];
                boolean rowHasDuplicates = false;
                boolean colHasDuplicates = false;
                
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    
                    if (rowCheck[matrix[i][j] - 1]) {
                        rowHasDuplicates = true;
                    } else {
                        rowCheck[matrix[i][j] - 1] = true;
                    }
                    
                    if (colCheck[matrix[j][i] - 1]) {
                        colHasDuplicates = true;
                    } else {
                        colCheck[matrix[j][i] - 1] = true;
                    }
                }
                
                if (rowHasDuplicates) {
                    rowCount++;
                }
                
                if (colHasDuplicates) {
                    colCount++;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", caseNum, trace, rowCount, colCount);
        }
        scanner.close();
    }
}