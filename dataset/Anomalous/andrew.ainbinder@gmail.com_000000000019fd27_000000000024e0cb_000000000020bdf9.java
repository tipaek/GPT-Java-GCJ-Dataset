import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int[] cameronSchedule = new int[2000];
            int[] jamieSchedule = new int[2000];
            int numberOfActivities = scanner.nextInt();
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();

            for (int activity = 0; activity < numberOfActivities; activity++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                boolean assignedToCameron = false;

                if (isAvailable(cameronSchedule, startTime, endTime)) {
                    markSchedule(cameronSchedule, startTime, endTime);
                    result.append("C");
                    assignedToCameron = true;
                }

                if (!assignedToCameron) {
                    if (isAvailable(jamieSchedule, startTime, endTime)) {
                        markSchedule(jamieSchedule, startTime, endTime);
                        result.append("J");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}