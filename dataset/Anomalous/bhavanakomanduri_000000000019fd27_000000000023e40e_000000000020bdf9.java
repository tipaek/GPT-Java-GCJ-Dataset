import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] traceSums = new int[N];
        int[] rowDuplicates = new int[N];
        int[] colDuplicates = new int[N];
        
        for (int l = 0; l < N; l++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            
            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            // Calculate trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            traceSums[l] = trace;
            
            // Calculate row duplicates
            int rowDuplicateCount = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j]]) {
                        rowDuplicateCount++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }
            rowDuplicates[l] = rowDuplicateCount;
            
            // Calculate column duplicates
            int colDuplicateCount = 0;
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[matrix[i][j]]) {
                        colDuplicateCount++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }
            colDuplicates[l] = colDuplicateCount;
        }
        
        for (int a = 0; a < N; a++) {
            System.out.printf("Case #%d: %d %d %d%n", a + 1, traceSums[a], rowDuplicates[a], colDuplicates[a]);
        }
        
        sc.close();
    }
}