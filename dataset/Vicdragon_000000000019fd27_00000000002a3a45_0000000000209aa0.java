import java.util.*;
import java.io.*;

public class Solution {
    private static int[][] getEqualMat(int n, int val) {
        int mat[][] = new int[n][n];
        for (int i=0; i<n; i++) {
            mat[i][i] = val;
            int j = i+1 == n ? 0 : i+1;
            val++;
            while (j != i) {
                mat[i][j] = val;
                j++;
                val++;
                if (j==n) {
                    j = 0;
                    val = 1;
                }
            } 
        }
        return mat;
    }
    
    private static int[][] getAllMat(int n) {
        return getEqualMat(n, 1);
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int t=1; t<=T; t++) {
            int n = input.nextInt();
            int k = input.nextInt();
            int mat[][] = new int[n][n];
            boolean works = false;
            int val = 0;
            int c = n;
            while (c > 0) {
                if (c*n == k) {
                    works = true;
                    val = c;
                    break;
                }
                c--;
            }
            if (works) {
                mat = getEqualMat(n, val);
            } else {
                int sum = 0;
                for (int i=1; i<=n; i++)
                    sum += i;
                if (sum == k) {
                    works = true;
                    mat = getAllMat(n);
                }
            }
            if (works) {
                System.out.println(String.format("Case #%d: POSSIBLE", t));
                for (int i=0; i<n; i++) {
                    String row = "";
                    for (int j=0; j<n; j++) {
                        row += mat[i][j];
                    }
                    System.out.println(row);
                }
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
            }
        }
    }
}