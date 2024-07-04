import java.util.*;
import java.io.*;
public class Solution {
        
    public static int sumTrace(int [][] mat, int n) {
        int trace = 0;
        for(int i = 0; i < n; i++) {
            trace += mat[i][i];
        }
        return trace;
    }
    
    public static int getDupRows(int [][] mat, int n) {
        int dupRows = 0;
        
        for(int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for(int j = 0; j < n; j++) {
                if(!set.add(mat[i][j])) {
                    dupRows += 1;
                    break;
                }
            }
        }
        
        return dupRows;
    }
    
    public static int getDupCols(int [][] mat, int n) {
        int dupCols = 0;
        
        for(int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for(int j = 0; j < n; j++) {
                if(!set.add(mat[j][i])) {
                    dupCols += 1;
                    break;
                }
            }
        }
        
        return dupCols;
    }
        
        
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int [][] mat = new int[n][n];
            
            for(int x = 0; x < n; x++) {
                for(int y = 0; y < n; y++) {
                    mat[x][y] = in.nextInt();    
                }
            }
            
            System.out.println("Case #" + i + ": " + Solution.sumTrace(mat, n) + " " + Solution.getDupRows(mat, n) + " " + Solution.getDupCols(mat, n));
        }
    }
}