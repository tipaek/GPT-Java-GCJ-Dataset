package com.jackson;

import java.util.*;

public class Solution3 {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution3().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(start, end, i));
        }

        activities.sort(Comparator.comparingInt(a -> a.start));

        int cEnd = 0, jEnd = 0;
        char[] schedule = new char[n];
        boolean isImpossible = false;

        for (Activity activity : activities) {
            if (activity.start >= cEnd) {
                cEnd = activity.end;
                schedule[activity.index] = 'C';
            } else if (activity.start >= jEnd) {
                jEnd = activity.end;
                schedule[activity.index] = 'J';
            } else {
                isImpossible = true;
                break;
            }
        }

        String result = isImpossible ? "IMPOSSIBLE" : new String(schedule);
        System.out.printf(OUTPUT_FORMAT, caseNum, result);
        System.out.println();
    }

    private static class Activity {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}