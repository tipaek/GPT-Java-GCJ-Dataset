import java.util.Scanner;

public class Prob1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int trace = 0;
            int[][] matrix = new int[n][n];
            
            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            int rowRepeats = 0;
            int colRepeats = 0;
            
            // Check for row repeats
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j] - 1]) {
                        rowRepeats++;
                        break;
                    }
                    seen[matrix[i][j] - 1] = true;
                }
            }
            
            // Check for column repeats
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n];
                for (int i = 0; i < n; i++) {
                    if (seen[matrix[i][j] - 1]) {
                        colRepeats++;
                        break;
                    }
                    seen[matrix[i][j] - 1] = true;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        scanner.close();
    }
}