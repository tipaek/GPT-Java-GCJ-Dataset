package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Cameron {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];

            for (int j = 0; j < numActivities; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }

            results.add(Scheduler.solve(activities, numActivities));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
}

class Scheduler {
    public static String solve(int[][] activities, int n) {
        StringBuilder output = new StringBuilder();
        int cameronEnd = 0, jamieEnd = 0;
        int cameronStart = 0, jamieStart = 0;
        ArrayList<String> assignments = new ArrayList<>();

        for (int[] activity : activities) {
            if (cameronEnd <= activity[0] || cameronStart >= activity[1]) {
                assignments.add("C");
                cameronStart = activity[0];
                cameronEnd = activity[1];
            } else if (jamieEnd <= activity[0] || jamieStart >= activity[1]) {
                assignments.add("J");
                jamieStart = activity[0];
                jamieEnd = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (String assignment : assignments) {
            output.append(assignment);
        }

        return output.toString();
    }
}