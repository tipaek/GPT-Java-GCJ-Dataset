package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        try {
            matrix.createMatrix();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Matrix {
    long [] trace;
    long[] rowDuplicate;
    long[] columnDuplicate;

    public void createMatrix() throws IOException {
        int numOfCores = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(numOfCores + 1);

        int testCase;
        int[] size;
        Scanner in = new Scanner(System.in);
        testCase = in.nextInt();
        trace = new long[testCase];
        rowDuplicate = new long[testCase];
        columnDuplicate = new long[testCase];
        size = new int[testCase];
        for(int i=0; i < testCase; i++) {
            size[i] = in.nextInt();
            int[][] matrix = new int[size[i]][size[i]];
            for(int j=0; j < size[i]; j++) {
                BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
                String row;
                int k = 0;
                row = bi.readLine();
                StringTokenizer tmp = new StringTokenizer(row, " ");
                while(tmp.hasMoreElements()) {
                    matrix[j][k] = Integer.parseInt(tmp.nextToken());
                    k++;
                }
            }
            int index = i;
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    trace[index] = getTrace(matrix, size[index]);
                    rowDuplicate[index] = duplicateRow(matrix, size[index]);
                    columnDuplicate[index] = duplicateColumn(matrix, size[index]);
                    //System.out.println("Trace = " + trace[index] + " Row Duplicate = " + rowDuplicate[index] + " Column Duplicate = " + columnDuplicate[index]);
                }
            };
            pool.execute(task);
        }
        pool.shutdown();
        while (!pool.isTerminated());
        for(int i = 0; i < testCase; i++){
            //Case #x: k r c
            System.out.println("Case #" + (i + 1) + ": " + trace[i] + " " + rowDuplicate[i] + " " + columnDuplicate[i]);
        }
    }

    public long getTrace(int[][] matrix, int size) {
        long sum = 0;
        for(int i=0; i<size; i++){
            sum = sum + matrix[i][i];
        }
        return sum;
    }

    public int duplicateRow(int[][] matrix, int size) {
        Set<Integer> set = new HashSet<>();
        int totalRowDuplicate = 0;
        for(int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                boolean isUnique = set.add(matrix[i][j]);
                if (!isUnique) {
                    totalRowDuplicate = totalRowDuplicate + 1;
                    break;
                }
            }
            set.clear();
        }
        return totalRowDuplicate;
    }

    public int duplicateColumn(int[][] matrix, int size) {
        Set<Integer> set = new HashSet<>();
        int totalColumnDuplicate = 0;
        for(int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                boolean isUnique = set.add(matrix[j][i]);
                if (!isUnique) {
                    totalColumnDuplicate = totalColumnDuplicate + 1;
                    break;
                }
            }
            set.clear();
        }
        return totalColumnDuplicate;
    }
}
