package com.jyoti.myproject.codejam;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        while(testCase-->0){
            int size = scanner.nextInt();
            int [][] m = new int[size][size];
            int caseNo=0;
            while (scanner.hasNextLine()){
                for(int i=0; i<m.length; i++){
                    String[] line = scanner.nextLine().trim().split(" ");
                    for(int j=0; j<line.length; j++){
                        m[i][j] = Integer.parseInt(line[j]);
                    }
                }
                int trace = getTrace(m, size);
                int repeatRows = getRowRepeat(m, size);
                int colRepeat = getColRepeat(m, size);
                System.out.println("Case #"+ ++caseNo +": "+ trace+ " "+repeatRows+" "+colRepeat);
            }
        }
    }

    private static int getTrace(int[][] m, int size) {
        int trace=0;
        int row=size-1, column = size-1;
        for(int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                trace = trace + m[i][j];
            }
        }
        return trace;
    }

    private static int getRowRepeat(int[][] m, int size){
        int r=0;
        int row=size-1, column = size-1;
        for(int i=0; i<row; i++){
            for (int j=0; j<column-1; j++){
                if(m[i][j] == m[i][j+1]){
                    r += 1;
                }
            }
        }
        return r;
    }

    private static int getColRepeat(int[][] m, int size){
        int c=0;
        int row=size-1, column = size-1;
        for (int j=0; j<column; j++){
            for(int i=0; i<row-1; i++){
                if(m[i][j] == m[i+1][j]){
                    c += 1;
                }
            }
        }
        return c;
    }


}
