import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        int[][] mat;
        for (int i = 0; i < max; i++) {
            int numLines = sc.nextInt();
            mat = new int[numLines][numLines];
            for (int j = 0; j < numLines; j++) {
                for (int p = 0; p < numLines; p++) {
                    mat[j][p] = sc.nextInt();
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + trace(mat) + " " + check(mat));
        } 
    }

    public static int trace(int[][] mat) {
        int ans = 0;
        for (int k = 0; k < mat[0].length; k++) {
            ans += mat[k][k];
        }
        return ans;
    }

    public static String check(int[][] mat) {
        Set<Integer> rowCheck;
        Set<Integer> colCheck;
        int row = 0;
        int col = 0;
        for (int n = 0; n < mat[0].length; n++) {
            rowCheck = new HashSet<>();
            colCheck = new HashSet<>();
            for (int m = 0; m < mat[0].length; m++) {
                if (rowCheck.contains(mat[n][m])) {
                    row += 1;
                    break;
                } else {
                    rowCheck.add(mat[n][m]);
                } 
            }
            for (int k = 0; k < mat[0].length; k++) {
                if (colCheck.contains(mat[k][n])) {
                    col += 1;
                    break;
                } else {
                    colCheck.add(mat[k][n]);
                }
            }
        }
        return Integer.toString(row) + " " + Integer.toString(col);
    }

}
