import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;
            
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                int[] rowCheck = new int[101];
                boolean rowHasDuplicates = false;
                
                for (int j = 0; j < matrixSize; j++) {
                    int num = scanner.nextInt();
                    matrix[i][j] = num;
                    
                    if (i == j) {
                        trace += num;
                    }
                    
                    rowCheck[num]++;
                    if (rowCheck[num] > 1) {
                        rowHasDuplicates = true;
                    }
                }
                
                if (rowHasDuplicates) {
                    duplicateRows++;
                }
            }
            
            for (int j = 0; j < matrixSize; j++) {
                int[] colCheck = new int[101];
                boolean colHasDuplicates = false;
                
                for (int i = 0; i < matrixSize; i++) {
                    int num = matrix[i][j];
                    
                    colCheck[num]++;
                    if (colCheck[num] > 1) {
                        colHasDuplicates = true;
                    }
                }
                
                if (colHasDuplicates) {
                    duplicateCols++;
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        
        scanner.close();
    }
}