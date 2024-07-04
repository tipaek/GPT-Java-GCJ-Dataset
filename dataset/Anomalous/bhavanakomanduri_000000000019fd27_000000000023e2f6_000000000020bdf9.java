import java.util.Scanner;

public class CodeJam {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        int[] traceSums = new int[testCases];
        int[] rowRepeats = new int[testCases];
        int[] columnRepeats = new int[testCases];
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            traceSums[t] = trace;
            
            // Check for row repeats
            int rowRepeatCount = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j]]) {
                        rowRepeatCount++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }
            rowRepeats[t] = rowRepeatCount;
            
            // Check for column repeats
            int columnRepeatCount = 0;
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[matrix[i][j]]) {
                        columnRepeatCount++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }
            columnRepeats[t] = columnRepeatCount;
        }
        
        // Print the results
        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + traceSums[t] + " " + rowRepeats[t] + " " + columnRepeats[t]);
        }
        
        scanner.close();
    }
}