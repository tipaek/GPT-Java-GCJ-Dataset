import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int[] cameronSchedule = new int[1500];
            int[] jamieSchedule = new int[1500];
            int numActivities = scanner.nextInt();
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();

            for (int activity = 0; activity < numActivities; activity++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                boolean assignedToCameron = false;

                if (isAvailable(cameronSchedule, startTime, endTime)) {
                    assign(cameronSchedule, startTime, endTime);
                    result.append("C");
                    assignedToCameron = true;
                } else if (isAvailable(jamieSchedule, startTime, endTime)) {
                    assign(jamieSchedule, startTime, endTime);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            System.out.println("Case #" + caseNum + ": " + result);
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

    private static void assign(int[] schedule, int start, int end) {
        for (int time = start; time < end; time++) {
            schedule[time] = 1;
        }
    }
}