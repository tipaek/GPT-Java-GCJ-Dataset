import java.util.Scanner;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int[] cameronSchedule = new int[1500];
            int[] jamieSchedule = new int[1500];
            int numberOfActivities = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int activity = 0; activity < numberOfActivities; activity++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isAvailable(cameronSchedule, startTime, endTime)) {
                    markSchedule(cameronSchedule, startTime, endTime);
                    result.append("C");
                } else if (isAvailable(jamieSchedule, startTime, endTime)) {
                    markSchedule(jamieSchedule, startTime, endTime);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int time = start; time < end; time++) {
            if (schedule[time] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(int[] schedule, int start, int end) {
        for (int time = start; time < end; time++) {
            schedule[time] = 1;
        }
    }
}