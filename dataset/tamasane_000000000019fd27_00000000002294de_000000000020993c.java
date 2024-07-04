import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution{
    public static int[] fact = new int[101];
    public static void main(String...args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            for(int i=0; i<n; i++){
                String s[] = br.readLine().trim().split(" +");
                for(int j=0; j<n; j++)
                    mat[i][j] = Integer.parseInt(s[j]);
            }
            sb.append(solve(mat, n)).append("\n");
        }
        System.out.print(sb.toString().trim());
    }
    public static String solve(int[][] arr, int n){
        int trace = 0, rows = 0, cols = 0;
        for(int i=0; i<n; i++)
            trace += arr[i][i];
        for(int i=0; i<n; i++){
            int[] rc = new int[n];
            int[] cc = new int[n];
            for(int j=0; j<n; j++)
                rc[arr[i][j]-1]++;
            for(int j=0; j<n; j++)
                cc[arr[i][j]-1]++;
            for(int j=0; j<n; j++)
                if(rc[j] != 1){ rows++; break;}
            for(int j=0; j<n; j++)
                if(cc[j] != 1){ cols++; break;}
        }
        return trace+" "+rows+" "+cols;
    }
}