/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        List<String> solutions = new ArrayList();

        for (int i = 1; i <= numberOfTestCases; ++i) {
            final int numberOfActivities = in.nextInt();
            int[][] activities = new int[numberOfActivities][3];

            for (int row = 0; row < numberOfActivities; row++) {
                for (int col = 0; col < 2; col++) {
                    while (!in.hasNextInt()) {
                        in.next();
                    }
                    activities[row][col] = in.nextInt();
                }
                activities[row][2] = row;
            }

            solutions.add(solve(activities, numberOfActivities, i));
        }

        for (String solution : solutions) {
            System.out.println(solution);
        }
    }

    private static String solve(int[][] activities, int total, int testNum) {
        // sort first
        Arrays.sort(activities, (activity1, activity2) -> activity1[0] - activity2[0]);
        
        String[] schedule = new String[total];
        boolean ret = assignTask(activities, 0, 0, 0, schedule);
        if (ret) {
            return printSolution(testNum, String.join("", schedule));
        }
        
        return printSolution(testNum, "IMPOSSIBLE");

        /////////////////////////////////
        
    }

    private static boolean assignTask(int[][] activities, int currActivity, int lastCameronEndTime, int lastJamieEndTime, String[] schedule) {
        if (currActivity == activities.length) {
            return true;
        }

        int[] activity = activities[currActivity];
        int canAssignActivity = canAssign(activities, currActivity, lastCameronEndTime, lastJamieEndTime);

        if (canAssignActivity == -1) {
            return false;
        }

        boolean success;
        switch (canAssignActivity) {
            case 0:
                schedule[activity[2]] = "C";
                success = assignTask(activities, currActivity + 1, activity[1], lastJamieEndTime, schedule);
                break;
            case 1:
                schedule[activity[2]] = "C";
                success = assignTask(activities, currActivity + 1, activity[1], lastJamieEndTime, schedule);
                break;
            default:
                schedule[activity[2]] = "J";
                success = assignTask(activities, currActivity + 1, lastCameronEndTime, activity[1], schedule);
                break;
        }
        
        if (!success) {
            schedule[activity[2]] = null;
        }
        return success;
    }


    // return 1: cameron
    // return 2: jamie
    // return 0: both
    // return -1: cannot assign
    private static int canAssign(int[][] activities, int currActivity, int lastCameronEndTime, int lastJamieEndTime) {
        boolean cAssign = lastCameronEndTime == 0 || lastCameronEndTime <= activities[currActivity][0];
        boolean jAssign = lastJamieEndTime == 0 || lastJamieEndTime <= activities[currActivity][0];

        if (cAssign && jAssign) {
            return 0;
        } else if (cAssign) {
            return 1;
        } else if (jAssign) {
            return 2;
        } else {
            return -1;
        }
    }

    public static String printSolution(int testCaseNumber, String result) {
        return String.format("Case #%d: %s", testCaseNumber, result);
    }

}
