import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static int[] vestigium(int[][] mat) {
        int[] res = new int[3];
        int n = mat.length;
        
        for (int i = 0; i < n; i++) {
            res[0] += mat[i][i]; // Sum of diagonal elements
            
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            boolean rowRepeat = false;
            boolean colRepeat = false;
            
            for (int j = 0; j < n; j++) {
                // Check row for repeats
                if (!rowRepeat) {
                    if (rowSet.contains(mat[i][j])) {
                        res[1]++;
                        rowRepeat = true;
                    } else {
                        rowSet.add(mat[i][j]);
                    }
                }
                
                // Check column for repeats
                if (!colRepeat) {
                    if (colSet.contains(mat[j][i])) {
                        res[2]++;
                        colRepeat = true;
                    } else {
                        colSet.add(mat[j][i]);
                    }
                }
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int n = s.nextInt();
            int[][] mat = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = s.nextInt();
                }
            }
            
            int[] krc = vestigium(mat);
            String result = "Case #" + t + ": " 
                            + krc[0] + " "
                            + krc[1] + " "
                            + krc[2];
            System.out.println(result);
        }
        
        s.close();
    }
}