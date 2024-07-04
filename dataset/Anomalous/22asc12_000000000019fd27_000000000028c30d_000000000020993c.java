import java.util.Scanner;

public class Solution {
    
    public static void process(int[][] matrix, int matSize, int caseNum) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;
        
        // Calculate trace and row duplicates
        for (int i = 0; i < matSize; i++) {
            trace += matrix[i][i];
            boolean[] rowSeen = new boolean[matSize + 1];
            boolean rowHasDuplicate = false;
            
            for (int j = 0; j < matSize; j++) {
                if (rowSeen[matrix[i][j]]) {
                    rowHasDuplicate = true;
                }
                rowSeen[matrix[i][j]] = true;
            }
            
            if (rowHasDuplicate) {
                rowDuplicates++;
            }
        }
        
        // Calculate column duplicates
        for (int i = 0; i < matSize; i++) {
            boolean[] colSeen = new boolean[matSize + 1];
            boolean colHasDuplicate = false;
            
            for (int j = 0; j < matSize; j++) {
                if (colSeen[matrix[j][i]]) {
                    colHasDuplicate = true;
                }
                colSeen[matrix[j][i]] = true;
            }
            
            if (colHasDuplicate) {
                colDuplicates++;
            }
        }
        
        System.out.println("Case #" + (caseNum + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        
        for (int i = 0; i < cases; i++) {
            int matSize = sc.nextInt();
            int[][] matrix = new int[matSize][matSize];
            
            for (int j = 0; j < matSize; j++) {
                for (int k = 0; k < matSize; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }
            
            process(matrix, matSize, i);
        }
        
        sc.close();
    }
}