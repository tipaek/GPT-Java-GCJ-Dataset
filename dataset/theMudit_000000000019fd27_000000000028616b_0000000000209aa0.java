package com.amazon.dbopgsppaymentprocessorpluginservice.aws.dao.dto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Indicium {

     int[][] square = new int[60][60];
     boolean[][] isRowSafe = new boolean[60][60];
     boolean[][] isColumnSafe = new boolean[60][60];
     int n , k, t;
     boolean solved;


    void solver(int row, int col, int m) {
        if (row == n && col == n + 1 && m == k && !solved) {
            solved = true;
            System.out.println("Case #" + t + ": " + "POSSIBLE");
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    System.out.print(square[i][j] + " ");
                }
                System.out.println();
            }
            return;
        } else if (row > n) {
            return;
        } else if (col > n) {
            solver(row + 1, 1, m);
        }
        for (int i = 1; i <= n && !solved; ++i) {
            if (!isRowSafe[row][i] && !isColumnSafe[col][i]) {
                isRowSafe[row][i] = isColumnSafe[col][i] = true;
                if (row == col) {
                    m += i;
                }
                square[row][col] = i;

                solver(row, col + 1, m);

                isRowSafe[row][i] = isColumnSafe[col][i] = false;
                if (row == col) {
                    m -= i;
                }
                square[row][col] = 0;
            }
        }
    }

    private void findSolution(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer stringTokenizer;
            for (t = 1; t <= numberOfTestCases; ++t) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                n = Integer.parseInt(stringTokenizer.nextToken());
                k = Integer.parseInt(stringTokenizer.nextToken());
                solver(1, 1, 0);
                if (!solved) {
                    System.out.println("Case #"+t+": "+"IMPOSSIBLE");
                }
                solved = false;
            }
        } catch (IOException e) {
            System.out.println("Jai Baba Kelker !!!");
        }
    }

    public static void main(String[] args){
        Indicium indicium = new Indicium();
        indicium.findSolution();
    }

}
