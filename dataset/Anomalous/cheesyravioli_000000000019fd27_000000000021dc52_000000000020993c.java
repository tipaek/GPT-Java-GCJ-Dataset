import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numTestCases = Integer.parseInt(reader.readLine());
        
        for (int caseNum = 1; caseNum <= numTestCases; caseNum++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            int traceSum = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            
            for (int row = 0; row < n; row++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                boolean[] rowCheck = new boolean[n];
                boolean rowHasRepeat = false;
                
                for (int col = 0; col < n; col++) {
                    int value = Integer.parseInt(tokenizer.nextToken());
                    matrix[row][col] = value;
                    
                    if (row == col) {
                        traceSum += value;
                    }
                    
                    if (rowCheck[value - 1]) {
                        rowHasRepeat = true;
                    } else {
                        rowCheck[value - 1] = true;
                    }
                }
                
                if (rowHasRepeat) {
                    rowRepeats++;
                }
            }
            
            for (int col = 0; col < n; col++) {
                boolean[] colCheck = new boolean[n];
                boolean colHasRepeat = false;
                
                for (int row = 0; row < n; row++) {
                    int value = matrix[row][col];
                    
                    if (colCheck[value - 1]) {
                        colHasRepeat = true;
                        break;
                    } else {
                        colCheck[value - 1] = true;
                    }
                }
                
                if (colHasRepeat) {
                    colRepeats++;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", caseNum, traceSum, rowRepeats, colRepeats);
        }
        
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        // System.out.println(totalTime / 1_000_000_000.0);
    }
}