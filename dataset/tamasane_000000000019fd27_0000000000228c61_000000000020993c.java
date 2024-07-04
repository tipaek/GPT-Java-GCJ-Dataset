import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution{
    public static int[] fact = new int[101];
    public static void main(String...args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        init();
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
        int rep = fact[n];
        int trace = 0, rows = 0, cols = 0;
        for(int i=0; i<n; i++)
            trace += arr[i][i];
        for(int i=0; i<n; i++){
            int p1 = 0, p2 = 0;
            for(int j=0; j<n; j++)
                p1 = (p1 * arr[i][j])%1000000007;
            for(int j=0; j<n; j++)
                p2 = (p2 * arr[j][i])%1000000007;
            if(p1 != rep) rows++;
            if(p2 != rep) cols++;
        }
        return trace+" "+rows+" "+cols;
    }
    public static void init(){
        fact[0] = 1;
        fact[1] = 1;
        for(int i=2; i<101; i++)
            fact[i] = (fact[i-1]*i)%1000000007;
    }
}