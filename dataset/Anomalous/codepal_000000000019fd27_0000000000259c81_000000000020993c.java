import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int[][] rowTracker = new int[n][n];
            int[][] colTracker = new int[n][n];
            int rowDuplicates = 0, colDuplicates = 0, trace = 0;
            
            for (int i = 0; i < n; i++) {
                boolean rowFlag = false;
                int colFlag = 0;
                
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    
                    if (rowTracker[i][matrix[i][j] - 1] != 1) {
                        rowTracker[i][matrix[i][j] - 1] = 1;
                    } else {
                        rowFlag = true;
                    }
                    
                    if (colTracker[matrix[i][j] - 1][j] != 1) {
                        colTracker[matrix[i][j] - 1][j] = 1;
                    } else {
                        colFlag++;
                    }
                    
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                
                if (colDuplicates < colFlag) {
                    colDuplicates = colFlag;
                }
                
                if (rowFlag) {
                    rowDuplicates++;
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }
}