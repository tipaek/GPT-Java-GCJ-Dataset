import java.util.*;
import java.io.*;

public class Solution {
    public static void solve(int ks, int n, int k) {
        boolean p = possible(n,k);
        String pos = p ? "POSSIBLE" : "IMPOSSIBLE";
        System.out.println("Case #" + ks + ": "+pos);
        if(p){
            int[][] latinSquare = generateLS(n, k);
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(latinSquare[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static boolean possible(int n, int k){
        if(n==3){
            return k== 3 || k==6 || k==9;
        }else{
            return k != n+1 && k!= n*n-1;
        }
    }
    public static int[][] generateLS(int n, int k){
        int [][] ls = new int [n][n];
        int avg = k/n;
        int mod = k%n;
        for(int i=0;i<n; i++){
            ls[i][i]= avg;
        }
        if (mod == 1) {
            ls[n-2][n-2]--;
            ls[n-1][n-1]+=2;
        }else if(mod>1){
            for(int i=0;i<mod; i++){
                ls[i][i]++;
            }
        }
        int [][]cy = cyclicN(n);
        for(int i=0;i<n; i++){
            int temp = ls[i][i];
            for(int j=0;j<n; j++){
                if(cy[j][i]==temp){
                    ls[i]= cy[j];
                    break;
                }
            }

        }
        return ls;
    }

    public static int[][] cyclicN(int N){
        int [][] cN = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0;j<N; j++){
                    cN[i][j] = (i+j)%N+1;
            }
        }
        return cN;
    }


    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        //T test cases
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            //N by N matrix
            int N = input.nextInt();
            //K desired trace
            int K = input.nextInt();
            solve(ks, N, K);
        }
    }
}
