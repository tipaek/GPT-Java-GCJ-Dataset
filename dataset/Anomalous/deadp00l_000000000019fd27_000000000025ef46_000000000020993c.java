import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Vestigium {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int q = 1; q <= t; q++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(br.readLine());
                }
            }
            
            int trace = 0, rowCount = 0, colCount = 0;
            
            // Calculate the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            
            // Create an array to compare with
            int[] baseArray = new int[n];
            for (int i = 0; i < n; i++) {
                baseArray[i] = i + 1;
            }
            
            // Check rows and columns for duplicates
            for (int i = 0; i < n; i++) {
                int[] rowArray = new int[n];
                int[] colArray = new int[n];
                
                for (int j = 0; j < n; j++) {
                    rowArray[j] = matrix[i][j];
                    colArray[j] = matrix[j][i];
                }
                
                Arrays.sort(rowArray);
                Arrays.sort(colArray);
                
                if (!Arrays.equals(rowArray, baseArray)) {
                    rowCount++;
                }
                
                if (!Arrays.equals(colArray, baseArray)) {
                    colCount++;
                }
            }
            
            System.out.println("Case #" + q + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}