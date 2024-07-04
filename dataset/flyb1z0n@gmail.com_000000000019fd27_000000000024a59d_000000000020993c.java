package com.flyb1z0n.education.java.exercises.codejam.cj_2020;

import java.util.Scanner;

/**
 * Problem
 * Vestigium means "trace" in Latin. In this problem we work with Latin squares and matrix traces.
 * <p>
 * The trace of a square matrix is the sum of the values on the main diagonal (which runs from the upper left to the lower right).
 * <p>
 * An N-by-N square matrix is a Latin square if each cell contains one of N different values, and no value is repeated within a row or a column. In this problem, we will deal only with "natural Latin squares" in which the N values are the integers between 1 and N.
 * <p>
 * Given a matrix that contains only integers between 1 and N, we want to compute its trace and check whether it is a natural Latin square. To give some additional information, instead of simply telling us whether the matrix is a natural Latin square or not, please compute the number of rows and the number of columns that contain repeated values.
 * <p>
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow. Each starts with a line containing a single integer N: the size of the matrix to explore. Then, N lines follow. The i-th of these lines contains N integers Mi,1, Mi,2 ..., Mi,N. Mi,j is the integer in the i-th row and j-th column of the matrix.
 * <p>
 * Output
 * For each test case, output one line containing Case #x: k r c, where x is the test case number (starting from 1), k is the trace of the matrix, r is the number of rows of the matrix that contain repeated elements, and c is the number of columns of the matrix that contain repeated elements.
 * <p>
 * Limits
 * Test set 1 (Visible Verdict)
 * Time limit: 20 seconds per test set.
 * Memory limit: 1GB.
 * 1 ≤ T ≤ 100.
 * 2 ≤ N ≤ 100.
 * 1 ≤ Mi,j ≤ N, for all i, j.
 * <p>
 * Sample
 * <p>
 * Input
 * <p>
 * Output
 * <p>
 * 3
 * 4
 * 1 2 3 4
 * 2 1 4 3
 * 3 4 1 2
 * 4 3 2 1
 * 4
 * 2 2 2 2
 * 2 3 2 3
 * 2 2 2 3
 * 2 2 2 2
 * 3
 * 2 1 3
 * 1 3 2
 * 1 2 3
 * <p>
 * <p>
 * Case #1: 4 0 0
 * Case #2: 9 4 4
 * Case #3: 8 0 2
 * <p>
 * <p>
 * In Sample Case #1, the input is a natural Latin square, which means no row or column has repeated elements. All four values in the main diagonal are 1, and so the trace (their sum) is 4.
 * <p>
 * In Sample Case #2, all rows and columns have repeated elements. Notice that each row or column with repeated elements is counted only once regardless of the number of elements that are repeated or how often they are repeated within the row or column. In addition, notice that some integers in the range 1 through N may be absent from the input.
 * <p>
 * In Sample Case #3, the leftmost and rightmost columns have repeated elements.
 * <p>
 * <p>
 * Syntax pre-check
 * Show Test Input
 */
public class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        for (int t = 1; t <= testCaseCount; t++) {
            int matrixSize = sc.nextInt();
            int[][] arr = new int[matrixSize][matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int[] result = solve(arr);
            System.out.println("Case #" + t + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }

    public static int[] solve(int[][] arr) {
        int trace = 0;
        int[][] rows = new int[arr.length][arr.length];
        int[][] cols = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    trace += arr[i][j];
                }
                rows[i][arr[i][j]-1]++;
                cols[j][arr[i][j]-1]++;
            }
        }

        int misRows = 0;
        int misCols= 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(rows[i][j] > 1)
                {
                    misRows ++;
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(cols[i][j] > 1)
                {
                    misCols ++;
                    break;
                }
            }
        }

        return new int[]{trace, misRows, misCols};
    }
}
