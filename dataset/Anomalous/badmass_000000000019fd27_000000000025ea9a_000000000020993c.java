import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            
            // Read the matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            
            // Calculate trace
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }
            
            // Check for row duplicates
            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < N) {
                    rowDuplicates++;
                }
            }
            
            // Check for column duplicates
            for (int i = 0; i < N; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    colSet.add(matrix[j][i]);
                }
                if (colSet.size() < N) {
                    colDuplicates++;
                }
            }
            
            // Print the result for this case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}