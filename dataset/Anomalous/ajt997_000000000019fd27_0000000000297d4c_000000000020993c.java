import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int testCases = Integer.parseInt(reader.readLine());
        for (int t = 0; t < testCases; t++) {
            int size = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[size][size];
            
            for (int row = 0; row < size; row++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            
            int trace = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;
            
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
                
                boolean rowHasRepeat = false;
                boolean colHasRepeat = false;
                int[] rowCount = new int[size + 1];
                int[] colCount = new int[size + 1];
                
                for (int j = 0; j < size; j++) {
                    int rowValue = matrix[i][j];
                    int colValue = matrix[j][i];
                    
                    rowCount[rowValue]++;
                    colCount[colValue]++;
                    
                    if (!rowHasRepeat && rowCount[rowValue] > 1) {
                        repeatedRows++;
                        rowHasRepeat = true;
                    }
                    
                    if (!colHasRepeat && colCount[colValue] > 1) {
                        repeatedCols++;
                        colHasRepeat = true;
                    }
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
}