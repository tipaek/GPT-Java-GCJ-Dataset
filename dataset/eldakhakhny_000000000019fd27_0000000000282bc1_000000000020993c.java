//package com.company;

import java.util.*;
 class Main {

    public static void main(String[] args) {

        //File file = new File("/Users/ahmed/Development/CompetitiveProgramming\ git java/src/com/company/in.txt");
        //Scanner scanner = new Scanner(file);
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.next());

        for (int i = 0; i < t; i++) {
            //read input
            int n = Integer.parseInt(scanner.next());
            int[][] matrix = new int[n][n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = Integer.parseInt(scanner.next());
                }
            }

            int k = calculateTrace(matrix,n);
            int r = rowsWithRepeatedElements(matrix,n);
            int c = colsWithRepeatedElements(matrix,n);
            int x = i+1;
            System.out.println("Case #"+x+": "+k+" "+r+" "+c);
        }

    }

    static int calculateTrace(int[][]matrix, int dimen){
        int trace = 0;
        for (int i = 0; i <dimen ; i++) {
                trace += matrix[i][i];
        }
        return trace;
    }
    static int colsWithRepeatedElements(int[][]matrix, int dimen){
        int colsCount = 0;
        for (int j = 0; j <dimen ; j++) {
            HashMap<Integer,Integer> hash=  new HashMap<>();
            for (int i = 0; i < dimen; i++) {
                Integer currentV = hash.get(matrix[i][j]);
                if (currentV != null && currentV > 0){
                    colsCount++;
                    break;
                }else {
                    hash.put(matrix[i][j],1);
                }
            }

        }
        return colsCount;
    }

    static int rowsWithRepeatedElements(int[][]matrix, int dimen){
        int rowsCount = 0;
        for (int i = 0; i <dimen ; i++) {
            HashMap<Integer,Integer> hash=  new HashMap<>();
            for (int j = 0; j < dimen; j++) {
                Integer currentV = hash.get(matrix[i][j]);
                if (currentV != null && currentV > 0){
                    rowsCount++;
                    break;
                }else {
                    hash.put(matrix[i][j],1);
                }
            }

        }
        return rowsCount;
    }
}
