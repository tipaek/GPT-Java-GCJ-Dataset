import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();

        for (int i = 1; i <= numCases; i++) {
            int[] cameronSchedule = new int[1500];
            int[] jamieSchedule = new int[1500];
            int numActivities = scanner.nextInt();
            boolean impossible = false;
            StringBuilder solution = new StringBuilder();

            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean assignedToCameron = false;

                if (impossible) {
                    continue;
                }

                if (isAvailable(cameronSchedule, start, end)) {
                    assignSchedule(cameronSchedule, start, end);
                    solution.append("C");
                    assignedToCameron = true;
                }

                if (!assignedToCameron) {
                    if (isAvailable(jamieSchedule, start, end)) {
                        assignSchedule(jamieSchedule, start, end);
                        solution.append("J");
                    } else {
                        solution = new StringBuilder("IMPOSSIBLE");
                        impossible = true;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + solution);
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

    private static void assignSchedule(int[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            schedule[k] = 1;
        }
    }
}