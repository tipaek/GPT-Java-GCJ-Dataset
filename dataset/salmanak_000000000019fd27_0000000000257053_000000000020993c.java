package Codejam_2020.Round1.Vestigium;

import java.util.Scanner;

public class Solution {
    public static int toggle(int mask, int n) {
        mask^=(1<<(n-1));
        return mask;
    }
    public static void solve(int[][] M, int N) {
        int maskC, maskR;
        int rows = 0, cols = 0, trace = 0;
        for(int i = 0; i<N; i++) {
            maskR = 0; maskC = 0;
            for(int j = 0; j<N; j++) {
                if(i==j) trace+=M[i][j];
                if(toggle(maskR,M[i][j])<maskR) {
                    rows=Math.min(i+1,rows+1);
                } else maskR = toggle(maskR,M[i][j]);
                if (toggle(maskC, M[j][i]) < maskC) {
                    cols=Math.min(i+1,cols+1);
                } else maskC = toggle(maskC, M[j][i]);
            }
        }
        System.out.println(trace + " " + rows + " " + cols);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for(int t = 1; t<=T; t++) {
            int N;
            N = sc.nextInt();
            int[][] M = new int[N][N];
            for(int i = 0; i<N; i++) {
                for(int j = 0; j<N; j++) {
                    M[i][j]=sc.nextInt();
                }
            }
            System.out.print("Case #"+t+": ");
            solve(M,N);
        }
    }
}
