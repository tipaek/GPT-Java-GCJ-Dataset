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
                boolean assigned = false;

                // Check Cameron's availability
                if (isAvailable(cameronSchedule, start, end)) {
                    assignTime(cameronSchedule, start, end);
                    result.append("C");
                    assigned = true;
                }

                // If not assigned to Cameron, check Jamie's availability
                if (!assigned) {
                    if (isAvailable(jamieSchedule, start, end)) {
                        assignTime(jamieSchedule, start, end);
                        result.append("J");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    // Helper method to check availability
    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) {
                return false;
            }
        }
        return true;
    }

    // Helper method to assign time to a schedule
    private static void assignTime(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}