import java.util.Scanner;

public class Trace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n = scanner.nextInt();
        
        int[][] matrix = new int[n][n];
        
        // Reading the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        int traceSum = 0;
        int rowRepeats = 0;
        int colRepeats = 0;
        
        // Calculating the trace
        for (int i = 0; i < n; i++) {
            traceSum += matrix[i][i];
        }
        
        // Checking for repeated elements in rows and columns
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                // Check row
                if (!rowSet.add(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
                // Check column
                if (!colSet.add(matrix[j][i])) {
                    colRepeats++;
                    break;
                }
            }
        }
        
        // Output results
        for (int i = 1; i <= t; i++) {
            System.out.println("Case #" + i + ": " + traceSum + " " + rowRepeats + " " + colRepeats);
        }
        
        scanner.close();
    }
}