package com.hegdes.ctci.impl.linked_lists;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n;

        Set<Integer> seen = new HashSet<>();

        int trace;
        int r;
        int c;
        while (t-- > 0) {
            n = scanner.nextInt();
            int[][] mat = new int[n][n];

            // compute trace
            trace = 0;
            for (int i = 0; i < n; i++) {
                trace += mat[i][i];
            }

            // compute row reps
            r = 0;
            for (int i = 0; i < n; i++) {
                seen.clear();
                for (int j = 0; j < n; j++) {
                    int val = mat[i][j];
                    if (seen.contains(val)) {
                        ++r;
                        break;
                    } else {
                        seen.add(val);
                    }
                }
            }

            // compute col reps
            c = 0;
            for (int j = 0; j < n; j++) {
                seen.clear();
                for (int i = 0; i < n; i++) {
                    int val = mat[i][j];
                    if (seen.contains(val)) {
                        ++c;
                        break;
                    } else {
                        seen.add(val);
                    }
                }
            }

            System.out.println("Case#" + t + ": " + trace + " " + r + " " + c);
        }
    }
}
