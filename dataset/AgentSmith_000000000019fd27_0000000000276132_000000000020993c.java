package com.google.codejam;

import java.util.Hashtable;
import java.util.Scanner;

public class Solution {

    private static int runTraceOnMatrix(int[][] arr, int size) {
        int sum=0;
        for(int i=0;i<size;i++) {

            for(int j=0;j<size;j++) {

                if(i==j) {

                    sum=sum+arr[i][j];

                }
            }
        }

        return sum;
    }

    private static int duplicateRowsOfMatrix(int[][] arr, int size)
    {
        Hashtable<Integer,Integer> integerHashtable = new Hashtable<>();
        int count=0;
        for(int i=0;i<size;i++)
        {
            int[] row =arr[i];

            for(int j=0;j<row.length;j++) {

                if(integerHashtable.containsKey(row[j])) {
                    count++;
                    break;
                } else {
                    integerHashtable.put(row[j],1);
                }
            }

            integerHashtable.clear();
        }

        return count;
    }

    private static int duplicateColumnsOfMatrix(int[][] arr, int size)
    {
        Hashtable<Integer,Integer> integerHashtable = new Hashtable<>();
        int count=0;

        for(int i=0; i<size; i++) {

            for(int j=0; j<size; j++) {

                int element = arr[j][i];

                if(integerHashtable.containsKey(element )) {
                    count++;
                    break;
                }
                else {
                    integerHashtable.put(element ,1);
                }
            }
            integerHashtable.clear();
        }

        return count;

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for(int idx=1; idx<=T; idx++) {

            int size = in.nextInt();
            int[][] matrix =new int[size][size];

            for(int i=0;i<size;i++) {
                for(int j=0;j<size;j++) {
                    matrix[i][j]=in.nextInt();
                }
            }

            int traceOnMatrix = runTraceOnMatrix(matrix,size);

            int rowsOfMatrix = duplicateRowsOfMatrix(matrix,size);

            int colsOfMatrix = duplicateColumnsOfMatrix(matrix,size);

            System.out.println("Case #" + idx + ":" + " " + traceOnMatrix+ " " + rowsOfMatrix + " " + colsOfMatrix);

        }
    }
}
