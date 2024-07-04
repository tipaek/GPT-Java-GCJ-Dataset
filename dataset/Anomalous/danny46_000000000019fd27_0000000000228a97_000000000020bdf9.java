package com.danny.playground.collection;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int numSegments = scanner.nextInt();
                int[][] segments = new int[numSegments][2];
                for (int i = 0; i < numSegments; i++) {
                    segments[i][0] = scanner.nextInt();
                    segments[i][1] = scanner.nextInt();
                }
                String result = findSchedule(numSegments, segments);
                System.out.printf("Case #%d: %s%n", caseNumber, result);
            }
        }
    }

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static String findSchedule(int numSegments, int[][] segments) {
        Arrays.sort(segments, Comparator.comparingInt(a -> a[0]));
        StringBuilder schedule = new StringBuilder();
        int cameronEnd = 0;
        int jamieEnd = 0;

        for (int[] segment : segments) {
            int start = segment[0];
            int end = segment[1];

            if (start >= cameronEnd) {
                schedule.append('C');
                cameronEnd = end;
            } else if (start >= jamieEnd) {
                schedule.append('J');
                jamieEnd = end;
            } else {
                return IMPOSSIBLE;
            }
        }
        return schedule.toString();
    }
}