/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vestigiumapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Pamathi Gunaratne
 */
class Solution {

    /**
     * @param args the command line arguments
     *
     */
    private int T;
    private int N;
    private int[][] matrix;

    Solution(int cases) {
        T = cases;

    }

    void input() {
        int[][] test;
        test = new int[3][3];
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        for (int i = 1; i <= T; i++) {
//            System.out.println("Please enter the size of matrix");
            N = sc.nextInt();
            int x;
            if (N >= 2 && N <= 100) {
                matrix = new int[N][N];
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        x = sc.nextInt();
                        if (x >= 1 && x <= N) {
                            matrix[r][c] = x;
                        }
                    }

                }
                test[i-1][0]=trace(matrix, N);
                test[i-1][1]=reprow(matrix, N);
                test[i-1][2]=repcol(matrix, N);
//                System.out.println("case #" + i + " :" + trace(matrix, N) + " " + reprow(matrix, N) + " " + repcol(matrix, N));

            }
            
            
        }
        for(int i=0;i<T;i++){
            System.out.println("case #"+(i+1)+" :"+test[i][0]+" "+test[i][1]+" "+test[i][2]);
        }
    }

    int reprow(int matrix[][], int size) {
        int r = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (matrix[i][j] == matrix[i][j + 1]) {
                    r++;
                    break;
                }
            }

        }
        return r;

    }

    int repcol(int matrix[][], int size) {
        int c = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (matrix[j][i] == matrix[j + 1][i]) {
                    c++;
                    break;
                }
            }

        }
        return c;

    }

    int trace(int matrix[][], int size) {
        int k = 0;
        for (int r = 0; r < size; r++) {
            k = k + matrix[r][r];
        }
        return k;

    }

    public static void main(String[] args) {
        // TODO code application logic here
        long beginTime = System.nanoTime();
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//
//        System.out.println("Please enter the no of test cases");
        int T = sc.nextInt();

        if (T >= 1 && T <= 100) {
            Solution object = new Solution(T);
            object.input();
             
        }
        
//        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
        System.exit(0);
    }
    
    
}
