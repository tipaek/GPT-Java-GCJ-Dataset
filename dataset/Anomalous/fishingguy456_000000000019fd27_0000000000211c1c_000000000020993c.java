import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeJam20Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }
            
            int trace = 0;
            int rowRepeats = 0, colRepeats = 0;
            
            // Calculate trace
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }
            
            // Check for row and column repeats
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                
                for (int k = 0; k < n; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        rowRepeats++;
                        break;
                    }
                }
                
                for (int k = 0; k < n; k++) {
                    if (!colSet.add(matrix[k][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        sc.close();
    }
}