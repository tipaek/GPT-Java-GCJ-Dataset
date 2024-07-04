package com.google;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public void solve() {
        HashSet<Integer> map = new HashSet<>();
        int[][] m = new int[100][100];
        Scanner scan = new Scanner(System.in);
        int inputCases = scan.nextInt();

        for (int i = 1; i <= inputCases; i++) {
            int sum = 0, nrPeCol = 0, nrPeLin = 0;
            int nrMatrice = scan.nextInt();

            for (int linie = 0; linie < nrMatrice; linie++) {
                for (int col = 0; col < nrMatrice; col++) {
                    m[linie][col] = scan.nextInt();
                }
            }
            for(int k = 0 ; k < nrMatrice ;k ++){
                sum+=m[k][k];
            }
            for (int linie = 0; linie < nrMatrice; linie++) {
                for (int col = 0; col < nrMatrice; col++) {
                    map.add(m[linie][col]);

                }
                if(map.size()!=nrMatrice) nrPeLin++;
                map.clear();
            }
            for (int linie = 0; linie < nrMatrice; linie++) {
                for (int col = 0; col < nrMatrice; col++) {
                    map.add(m[col][linie]);

                }
                if(map.size()!=nrMatrice) nrPeCol++;
                map.clear();
            }
            System.out.println();
            System.out.println("Case #"+i+":"+sum+" "+nrPeLin+" "+" "+nrPeCol);
        }
    }


}

