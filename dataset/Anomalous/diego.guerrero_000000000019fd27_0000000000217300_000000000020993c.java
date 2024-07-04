package vestigium;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static final String CASE_TEMPLATE = "Case #%d: %d %d %d";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            int[][] matrix = new int[n][n];
            Set<Integer>[] rowSets = new Set[n];
            Set<Integer>[] colSets = new Set[n];

            for (int i = 0; i < n; i++) {
                rowSets[i] = new HashSet<>();
                colSets[i] = new HashSet<>();
            }

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;

                    if (row == col) {
                        trace += value;
                    }

                    rowSets[row].add(value);
                    colSets[col].add(value);
                }
            }

            for (int i = 0; i < n; i++) {
                if (rowSets[i].size() != n) {
                    rowRepeats++;
                }
                if (colSets[i].size() != n) {
                    colRepeats++;
                }
            }

            System.out.printf(CASE_TEMPLATE, testCase, trace, rowRepeats, colRepeats);
            System.out.println();
        }
    }
}