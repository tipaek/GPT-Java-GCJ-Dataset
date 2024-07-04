//package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] res = new String[T];

        for(int i=0; i< T; i++){
            int N = Integer.parseInt(br.readLine());
            int total = N*(N+1)/2;
            int[][] M = new int[N][N];

            for(int j=0; j<N; j++){
                String input = br.readLine();
                String[] ips = input.trim().split(" ");
                for(int k=0; k<N; k++)
                    M[j][k] = Integer.parseInt(ips[k]);
            }
            int rowCount = 0, colCount = 0;
            int sum=0;
            //compute for rows
            for(int n=0; n<N; n++){
                for(int l=0; l< N; l++){
                    sum += M[n][l];
                }
                if(sum != total)
                    rowCount++;
                sum = 0;
            }

            //compute for cols
            for(int n=0; n<N; n++){
                for(int l=0; l< N; l++){
                    sum += M[l][n];
                }
                if(sum != total)
                    colCount++;
                sum = 0;
            }

            res[i] = "Case #"+ (i+1) + ": " + N + " " + rowCount + " " + colCount;
        }
    }
}
