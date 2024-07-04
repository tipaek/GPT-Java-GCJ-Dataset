import java.util.*;
import java.io.*;

public class Solution {
    
    public static int getRepeatRows(int[][] m) {
        int numRows = 0;
        
        for (int i = 0; i < m.length; i++) {
            boolean[] vals = new boolean[m.length];
            
            for (int j = 0; j < m.length; j++) {
                if (vals[m[i][j] - 1]) { // already encountered
                    numRows++;
                    break;
                } else {
                    vals[m[i][j] - 1] = true;
                }
            }
        }
        
        return numRows;
    }
    
    public static int getRepeatCols(int[][] m) {
        int numCols = 0;
        
        for (int j = 0; j < m.length; j++) {
            boolean[] vals = new boolean[m.length];
            
            for (int i = 0; i < m.length; i++) {
                if (vals[m[i][j] - 1]) { // already encountered
                    numCols++;
                    break;
                } else {
                    vals[m[i][j] - 1] = true;
                }
            }
        }
        
        return numCols;
    }
    
    public static int getTrace(int[][] m) {
        int result = 0;
        for (int i = 0; i < m.length; i++){
            result = result + m[i][i];
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        
        for (int x = 1; x <= testCases; x++) {
            String answer = "Case #" + x + ": ";
            
            // Create the matrix
            int n = in.nextInt();
            int[][] myMatrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0 ; j < n; j++) {
                    myMatrix[i][j] = in.nextInt();
                }
            }
            
            int trace = getTrace(myMatrix);
            int numRows = getRepeatRows(myMatrix);
            int numCols = getRepeatCols(myMatrix);
            
            answer = answer + trace + " " + numRows + " " + numCols;
            System.out.println(answer);
        }
        
        in.close();
    }
}