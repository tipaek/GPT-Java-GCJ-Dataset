import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i=1;i<=t;i++){
            solve(s, i);
        }
    }

    private static void solve(Scanner s, int testCases) {
        int n = s.nextInt();
        int[][] m = new int[n][n];
        int k = 0;
        int dr = 0;
        int dc = 0;
        boolean idr = false;
        boolean[] idcMap = new boolean[n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                int rc = s.nextInt();
                m[i][j] = rc;
                if (!idr && j>0 && contains(m[i], j, rc)){
                    idr = true;
                    dr++;
                }
                if (i==j){
                    k += rc;
                }

                if (!idcMap[j] && i>0 && contains(m,j,i, rc)){
                    idcMap[j] = true;
                    dc++;
                }
            }
            idr = false;
        }

        System.out.println(String.format("Case #%d: %d %d %d", testCases, k, dr, dc));
    }

    private static boolean contains(int[] a, int li, int val){

        for (int i=0;i<li;i++){
            if (val==a[i]){
                return true;
            }
        }
        return false;
    }

    private static boolean contains(int[][] a, int col, int li, int val){

        for (int i=0;i<li;i++){
            if (val==a[i][col]){
                return true;
            }
        }
        return false;
    }
}