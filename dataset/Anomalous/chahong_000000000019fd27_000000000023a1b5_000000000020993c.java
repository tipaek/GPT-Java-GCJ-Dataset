import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int crossSum = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int[][] matrix = new int[t][t];
            
            // Read matrix and calculate crossSum
            for (int j = 0; j < t; j++) {
                for (int k = 0; k < t; k++) {
                    matrix[j][k] = sc.nextInt();
                    if (j == k) {
                        crossSum += matrix[j][k];
                    }
                }
            }
            
            // Check for row and column duplicates
            for (int j = 0; j < t; j++) {
                boolean[] rowSeen = new boolean[t + 1];
                boolean[] colSeen = new boolean[t + 1];
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;
                
                for (int k = 0; k < t; k++) {
                    if (!rowHasDuplicate && rowSeen[matrix[j][k]]) {
                        rowDuplicates++;
                        rowHasDuplicate = true;
                    } else {
                        rowSeen[matrix[j][k]] = true;
                    }
                    
                    if (!colHasDuplicate && colSeen[matrix[k][j]]) {
                        colDuplicates++;
                        colHasDuplicate = true;
                    } else {
                        colSeen[matrix[k][j]] = true;
                    }
                }
            }
            
            System.out.println(crossSum + " " + rowDuplicates + " " + colDuplicates);
        }
        
        sc.close();
    }
}