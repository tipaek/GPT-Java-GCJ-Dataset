import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            
            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasRepeat = false;
                
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    
                    if (!rowHasRepeat) {
                        if (rowSet.contains(matrix[i][j])) {
                            rowHasRepeat = true;
                            rowRepeats++;
                        } else {
                            rowSet.add(matrix[i][j]);
                        }
                    }
                }
            }
            
            // Check for column repeats
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colHasRepeat = false;
                
                for (int i = 0; i < n; i++) {
                    if (!colHasRepeat) {
                        if (colSet.contains(matrix[i][j])) {
                            colHasRepeat = true;
                            colRepeats++;
                        } else {
                            colSet.add(matrix[i][j]);
                        }
                    } else {
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        scanner.close();
    }
}