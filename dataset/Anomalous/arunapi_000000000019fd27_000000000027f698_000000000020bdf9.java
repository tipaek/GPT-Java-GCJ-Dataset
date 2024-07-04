import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activitiesCount = scanner.nextInt();
            int[][] activities = new int[activitiesCount][2];
            String[] schedule = new String[activitiesCount];
            String result = "";

            for (int i = 0; i < activitiesCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                schedule = assignActivity(activities, schedule, i);

                if (schedule[i] == null) {
                    result = "IMPOSSIBLE";
                    break;
                }
                result += schedule[i];
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static String[] assignActivity(int[][] activities, String[] schedule, int currentIndex) {
        if (currentIndex == 0) {
            schedule[currentIndex] = "J";
            return schedule;
        }

        schedule[currentIndex] = null;
        int currentStart = activities[currentIndex][0];
        int currentEnd = activities[currentIndex][1];
        boolean isJOccupied = false;

        for (int i = 0; i < currentIndex; i++) {
            int start = activities[i][0];
            int end = activities[i][1];

            if (!(currentStart >= end || currentEnd <= start)) {
                if (isJOccupied) {
                    schedule[currentIndex] = null;
                    return schedule;
                } else if ("J".equals(schedule[i])) {
                    isJOccupied = true;
                }
            }
        }

        schedule[currentIndex] = isJOccupied ? "C" : "J";
        return schedule;
    }
}