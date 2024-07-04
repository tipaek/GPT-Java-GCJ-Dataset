import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            int trace = 0;
            int rows = 0;
            int cols = 0;
            int[] f;
            boolean row;
            boolean col;
            for(int i=0;i<n;i++){
                f = new int[n];
                row = false;
                for(int j=0;j<n;j++){
                    a[i][j] = sc.nextInt();
                    f[a[i][j]-1]++;
                    if(f[a[i][j]-1]>1) row = true;
                    if(i==j) trace += a[i][j];
                }
                if (row) rows++;
            }
            for(int j=0;j<n;j++){
                f = new int[n];
                col = false;
                for(int i=0;i<n;i++){
                    f[a[i][j]-1]++;
                    if(f[a[i][j]-1]>1) col = true;
                }
                if (col) cols++;
            }
            System.out.println("Case #" + t + ": " + trace + " " + rows + " " + cols);
        }
    }
}