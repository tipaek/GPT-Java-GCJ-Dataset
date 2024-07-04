package Vestigium;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = sc.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < cases; i++) {
            int matrixSize = sc.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int j = 0; j < matrixSize; j++) {
                trace += matrix[j][j];
                if (hasDuplicates(matrix[j])) {
                    duplicateRows++;
                }

                int[] col = new int[matrixSize];
                for (int k = 0; k < matrixSize; k++) {
                    col[k] = matrix[k][j];
                }
                if (hasDuplicates(col)) {
                    duplicateCols++;
                }
            }

            results.add("Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        sc.close();

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int num : array) {
            if (seen[num]) {
                return true;
            }
            seen[num] = true;
        }
        return false;
    }
}