import java.util.Scanner;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        for (int tn = 1; tn <= t; tn++) {
            int n = scan.nextInt();
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            int[][] matrix = new int[n][n];
            
            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }
            
            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            
            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j]]) {
                        rowDuplicates++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }
            
            // Check for duplicate values in columns
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[j][i]]) {
                        colDuplicates++;
                        break;
                    }
                    seen[matrix[j][i]] = true;
                }
            }
            
            // Output the result
            String output = "Case #" + tn + ": " + trace + " " + rowDuplicates + " " + colDuplicates;
            try (PrintWriter writer = new PrintWriter(System.out)) {
                writer.println(output);
                writer.flush();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}