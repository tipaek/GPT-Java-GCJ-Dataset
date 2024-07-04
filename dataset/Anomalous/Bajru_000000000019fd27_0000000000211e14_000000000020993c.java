import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            solve(matrix, n, t);
        }
        
        scanner.close();
    }
    
    private static void solve(int[][] matrix, int n, int caseNumber) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        
        int expectedSum = n * (n + 1) / 2;
        int rowRepeats = 0;
        int colRepeats = 0;
        
        for (int i = 0; i < n; i++) {
            int rowSum = expectedSum;
            int colSum = expectedSum;
            for (int j = 0; j < n; j++) {
                rowSum -= matrix[i][j];
                colSum -= matrix[j][i];
            }
            if (rowSum != 0) {
                rowRepeats++;
            }
            if (colSum != 0) {
                colRepeats++;
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
    }
}