import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int k = 0; k < t; k++) {
            int n = in.nextInt();
            int[][] m = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    m[r][c] = in.nextInt();
                }
            }
            
            int r = 0, c = 0;
            int trace = 0;
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            
            for (int i = 0; i < n; i++) {
                trace += m[i][i];
                for (int j = 0; j < n; j++) {
                    rowSet.add(m[i][j]);
                    colSet.add(m[j][i]);
                }
                if (rowSet.size() != n) r++;
                if (colSet.size() != n) c++;
                rowSet.clear();
                colSet.clear();
            }
            System.out.println("Case #" + (k+1)
                                + ": " + trace 
                                + " " + r 
                                + " " + c);
        }
    }
}