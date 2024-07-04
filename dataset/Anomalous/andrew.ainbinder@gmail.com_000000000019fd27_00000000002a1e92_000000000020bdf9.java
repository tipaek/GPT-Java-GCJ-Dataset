import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int[] cameronSchedule = new int[1440];
            int[] jamieSchedule = new int[1440];
            int numActivities = scanner.nextInt();
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();

            for (int activity = 0; activity < numActivities; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isImpossible) {
                    continue;
                }

                if (isAvailable(cameronSchedule, start, end)) {
                    markSchedule(cameronSchedule, start, end);
                    result.append("C");
                } else if (isAvailable(jamieSchedule, start, end)) {
                    markSchedule(jamieSchedule, start, end);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                }
            }

            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int time = start; time < end; time++) {
            if (schedule[time] == 1) {
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