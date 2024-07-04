package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int cases = scanner.nextInt();

        for(int i=0;i<cases;i++){
            int n = scanner.nextInt();

            int[][] arr = new int[n][n];

            for(int j=0;j<n;j++) {
                for(int k=0;k<n;k++){
                    arr[j][k] = scanner.nextInt();
                }
            }

            solve(n, arr);

        }

    }

    private static void solve(int n, int[][] arr) {
        int trace = 0;
        int repeatedRows = 0;
        int repeatedColumns = 0;


        for(int i=0;i<n; i++) {
            trace += arr[i][i];
        }


        for(int x =0;x<n;x++) {
            boolean[] column = new boolean[n];
            for (int y=0;y<n;y++) {
                int index = arr[x][y];
                if(column[index - 1]) {
                    repeatedRows++;
                    break;
                }
                column[index - 1] = true;
            }
        }

        for(int x =0;x<n;x++) {
            boolean[] rows = new boolean[n];
            for (int y=0;y<n;y++) {
                int index = arr[y][x];
                if(rows[index - 1] ) {
                    repeatedColumns++;
                    break;
                }
                rows[index - 1] = true;
            }
        }


        System.out.println(String.format("Case #1: %d %d %d", trace, repeatedRows, repeatedColumns));
    }
}
