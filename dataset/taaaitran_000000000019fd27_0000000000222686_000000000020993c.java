/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.io.*;

/**
 *
 * @author lap13310
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTest = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int n = 1; n <= numTest; ++n) {
            int N = in.nextInt();
            int trace = 0;
            int rowError = 0;
            int colSError = 0;
            int arr[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int data = in.nextInt();
                    arr[i][j] = data;
                }
            }
            for (int i = 0; i < N; i++) {
                trace += arr[i][i];
            }
            rowError = countErrorRow(arr);
            colSError = countErrorColumn(arr);

            System.out.println("Case #" + n + ": " + trace + " " + rowError + " " + colSError);
        }
    }

    public static int countErrorRow(int[][] arr) {
        int numRowError = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] counts = new int[arr.length]; // Occurrence of each letter
            for (int j = 0; j < arr[i].length; j++) {
                counts[arr[i][j] - 1]++;
                if (counts[arr[i][j] - 1] > 1) {
                    numRowError++;
                    break;
                }
            }
        }
        return numRowError;
    }

    public static int countErrorColumn(int[][] arr) {
        int numColError = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] counts = new int[arr[0].length]; // Occurrence of each letter
            for (int j = 0; j < arr[i].length; j++) {
                counts[arr[j][i] - 1]++;
                if (counts[arr[j][i] - 1] > 1) {
                    numColError++;
                    break;
                }
            }
        }
        return numColError;
    }
}
