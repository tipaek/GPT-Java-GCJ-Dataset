import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int testCases = Integer.parseInt(reader.readLine());
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
                
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;
                
                int[] rowCount = new int[matrixSize + 1];
                int[] colCount = new int[matrixSize + 1];
                
                for (int j = 0; j < matrixSize; j++) {
                    int rowElement = matrix[i][j];
                    int colElement = matrix[j][i];
                    
                    rowCount[rowElement]++;
                    colCount[colElement]++;
                    
                    if (!rowHasDuplicate && rowCount[rowElement] > 1) {
                        duplicateRows++;
                        rowHasDuplicate = true;
                    }
                    
                    if (!colHasDuplicate && colCount[colElement] > 1) {
                        duplicateCols++;
                        colHasDuplicate = true;
                    }
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}