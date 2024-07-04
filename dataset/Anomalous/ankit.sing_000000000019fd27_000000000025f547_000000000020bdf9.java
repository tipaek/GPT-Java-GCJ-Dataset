import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numSchedules = scanner.nextInt();
            int[][] schedules = new int[numSchedules][2];
            
            for (int i = 0; i < numSchedules; i++) {
                schedules[i][0] = scanner.nextInt();
                schedules[i][1] = scanner.nextInt();
            }
            
            String result = findSchedules(schedules);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static String findSchedules(int[][] schedules) {
        int endC = 0, endJ = 0;
        StringBuilder scheduleBuilder = new StringBuilder();
        HashSet<Integer> startTimes = new HashSet<>();
        int duplicateCount = 0;

        for (int[] schedule : schedules) {
            int start = schedule[0];
            int end = schedule[1];

            if (!startTimes.add(start)) {
                duplicateCount++;
                if (duplicateCount >= 2) {
                    return "IMPOSSIBLE";
                }
            }

            if (start >= endC) {
                scheduleBuilder.append("C");
                endC = end;
            } else if (start >= endJ) {
                scheduleBuilder.append("J");
                endJ = end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return scheduleBuilder.toString();
    }
}