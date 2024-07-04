package com.isograd.exercise;

import java.util.Scanner;


import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] argv) throws Exception {
        int nbCases = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= nbCases; i++) {
            doCase(i);
        }
    }

    private static void doCase(int caseNumber) {
        int trace = 0, rowWithDup = 0, colWithDup = 0;

        int n = Integer.parseInt(sc.nextLine());
        int verifNum = n * (n + 1) / 2;

        int[] colSum = new int[n];

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            int sumLine = 0;
            for (int j = 0; j <n; j++) {
                int curr = Integer.parseInt(line[j]);
                sumLine += curr;
                colSum[j] += curr;
                if (i == j || i == n - j) {
                    trace += curr;
                }
            }
            
            if (sumLine != verifNum) {
                rowWithDup++;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (colSum[i] != verifNum) {
                colWithDup++;
            }
        }

        System.out.println("Case #" + Integer.toString(caseNumber)
                + ": " + Integer.toString(trace)
                + " " + Integer.toString(rowWithDup)
                + " " + Integer.toString(colWithDup)
        );
    }

}
