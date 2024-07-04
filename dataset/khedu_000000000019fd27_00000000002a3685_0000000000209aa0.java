package com.khedu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IndiciumCodeJam5 {
    static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    static int[][] mat;
    private static int N = 0;
    public static void main(String[] args)throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++){
            N =  Integer.parseInt(br.readLine());
            mat = new int[N][N];
            
            int right = N - 1, left = 0;
            for (int k = 0; k < N; k++){
                if (k % 2 == 0){
                    mat[k][right] = 1;
                    fillRemaining(k, right, N);
                    right--;
                }
                else{
                    mat[k][left] = 1;
                    fillRemaining(k, left, N);
                    left++;
                }
            }
//            constructMatrix(N);
            for (int l = 0; l < N; l++)
            {
                for (int j = 0 ; j < N; j++){
                    System.out.print(mat[l][j]+" ");
                }
                System.out.println();
            }
        }
    }

//    private static void constructMatrix(int n){
//        int right = n - 1, left = 0;
//        for (int i = 0; i < n; i++){
//            if (i % 2 == 0){
//                mat[i][right] = 1;
//                fillRemaining(i, right, n);
//                right--;
//            }
//            else{
//                mat[i][left] = 1;
//                fillRemaining(i, left, n);
//                left++;
//            }
//        }
//    }

    private static void fillRemaining(int i, int j, int n) {
        int x = 2;
        for (int k = i + 1; k < n; k++)
            mat[k][j] = x++;
        for (int k = 0; k < i; k++)
            mat[k][j] = x++;
    }
}
