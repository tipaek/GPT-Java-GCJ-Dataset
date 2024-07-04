import java.util.Scanner;
import java.util.HashSet;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            
            // Reading matrix and calculating trace
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scan.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }
            
            // Checking for row and column repeats
            for (int j = 0; j < n; j++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;
                
                for (int k = 0; k < n; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        rowHasDuplicate = true;
                    }
                    if (!colSet.add(matrix[k][j])) {
                        colHasDuplicate = true;
                    }
                }
                
                if (rowHasDuplicate) {
                    rowRepeats++;
                }
                if (colHasDuplicate) {
                    colRepeats++;
                }
            }
            
            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        scan.close();
    }
}