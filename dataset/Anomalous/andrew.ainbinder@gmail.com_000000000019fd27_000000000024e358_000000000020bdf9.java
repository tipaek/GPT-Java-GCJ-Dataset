import java.util.Scanner;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int i = 1; i <= numberOfCases; i++) {
            int[] cameronSchedule = new int[2000];
            int[] jamieSchedule = new int[2000];
            int numberOfActivities = scanner.nextInt();
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < numberOfActivities; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                boolean assignedToCameron = false;

                if (isAvailable(cameronSchedule, startTime, endTime)) {
                    assignToSchedule(cameronSchedule, startTime, endTime);
                    result.append("C");
                    assignedToCameron = true;
                } else if (isAvailable(jamieSchedule, startTime, endTime)) {
                    assignToSchedule(jamieSchedule, startTime, endTime);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            if (schedule[k] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void assignToSchedule(int[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            schedule[k] = 1;
        }
    }
}