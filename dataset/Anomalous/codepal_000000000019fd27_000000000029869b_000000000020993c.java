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
            int[][] rowCheck = new int[n][n];
            int[][] colCheck = new int[n][n];
            int duplicateRows = 0, duplicateCols = 0, diagonalSum = 0;
            int[] colFlags = new int[n];
            
            for (int i = 0; i < n; i++) {
                boolean rowHasDuplicate = false;
                
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    
                    if (rowCheck[i][matrix[i][j] - 1] != 1) {
                        rowCheck[i][matrix[i][j] - 1] = 1;
                    } else {
                        rowHasDuplicate = true;
                    }
                    
                    if (colCheck[matrix[i][j] - 1][j] != 1) {
                        colCheck[matrix[i][j] - 1][j] = 1;
                    } else {
                        colFlags[j] = 1;
                    }
                    
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
                
                if (rowHasDuplicate) {
                    duplicateRows++;
                }
            }
            
            for (int colFlag : colFlags) {
                duplicateCols += colFlag;
            }
            
            System.out.println("Case #" + (t + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
    }
}