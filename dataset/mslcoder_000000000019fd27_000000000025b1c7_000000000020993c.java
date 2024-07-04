//package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] v = new int[n][n];
            int row = 0, col = 0, sum = 0;

            boolean colarr[] = new boolean[n];
            boolean arr[][] = new boolean[n + 1][n + 1];
            boolean brr[][] = new boolean[n + 1][n + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    v[i][j] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                boolean rowFound = false;
                for (int j = 0; j < n; j++) {
                    // System.out.print(arr[i+1][v[i][j]] + " ");
                    if (arr[i + 1][v[i][j]])
                        rowFound = true;
                    else
                        arr[i + 1][v[i][j]] = true;


                    if (brr[v[i][j]][j + 1]) {
                        if (!colarr[j]) {
                            col++;
                            colarr[j] = true;
                        }
                    } else {
                        brr[v[i][j]][j + 1] = true;
                    }

                }
                if (rowFound)
                    row++;
                sum += v[i][i];

                //  System.out.println();

            }
            System.out.println(sum + " "+ row + " " + col);
        }
    }
}
