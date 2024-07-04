import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution{
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
        int rep = n*(n+1)/2;
        int trace = 0, rows = 0, cols = 0;
        for(int i=0; i<n; i++)
            trace += arr[i][i];
        for(int i=0; i<n; i++){
            int xor1 = 0, xor2 = 0;
            for(int j=0; j<n; j++)
                xor1 += arr[i][j];
            for(int j=0; j<n; j++)
                xor2 += arr[j][i];
            if(xor1 != rep) rows++;
            if(xor2 != rep) cols++;
        }
        return trace+" "+rows+" "+cols;
    }
}