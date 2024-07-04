import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int testCases = sc.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }
            
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            
            // Calculate trace
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }
            
            // Check for repeated elements in rows
            for (int j = 0; j < n; j++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean hasDuplicate = false;
                for (int k = 0; k < n; k++) {
                    if (rowCheck[matrix[j][k]]) {
                        hasDuplicate = true;
                        break;
                    }
                    rowCheck[matrix[j][k]] = true;
                }
                if (hasDuplicate) {
                    rowRepeats++;
                }
            }
            
            // Check for repeated elements in columns
            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                boolean hasDuplicate = false;
                for (int k = 0; k < n; k++) {
                    if (colCheck[matrix[k][j]]) {
                        hasDuplicate = true;
                        break;
                    }
                    colCheck[matrix[k][j]] = true;
                }
                if (hasDuplicate) {
                    colRepeats++;
                }
            }
            
            result.append("case #").append(i + 1).append(": ").append(trace).append(" ").append(rowRepeats).append(" ").append(colRepeats).append("\n");
        }
        
        System.out.print(result);
    }
}