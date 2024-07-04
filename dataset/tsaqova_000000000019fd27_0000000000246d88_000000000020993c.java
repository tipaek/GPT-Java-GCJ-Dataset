package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    int t = scanner.nextInt();
	    for (int a=0; a<t; a++) {
	        int n = scanner.nextInt();
	        int[][] matrix = new int[n][n];
	        for (int i=0; i<n; i++) {
	            for (int j=0; j<n; j++) {
	                matrix[i][j] = scanner.nextInt();
                }
            }
	        int ansa = 0;
	        for (int i=0; i<n; i++) {
	            ansa += matrix[i][i];
            }
	        int[] cek = new int[n];
	        int ansb = 0;
            for (int i=0; i<n; i++) {
                Arrays.fill(cek, 0);
                for (int j=0; j<n; j++) {
                    cek[matrix[i][j]-1]++;
                }
                boolean flag = false;
                for (int j=0; j<n; j++) {
                    if (cek[j] != 1) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    ansb++;
                }
            }
            int ansc = 0;
            for (int i=0; i<n; i++) {
                Arrays.fill(cek, 0);
                for (int j=0; j<n; j++) {
                    cek[matrix[j][i]-1]++;
                }
                boolean flag = false;
                for (int j=0; j<n; j++) {
                    if (cek[j] != 1) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    ansc++;
                }
            }
            System.out.println("Case #" + (a + 1) + ": " + ansa + " " + ansb + " " + ansc);
        }
    }
}
