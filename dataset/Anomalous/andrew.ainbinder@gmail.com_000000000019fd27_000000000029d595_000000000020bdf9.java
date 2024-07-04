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
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean addedToCameron = false;

                if (isAvailable(cameronSchedule, start, end)) {
                    fillSchedule(cameronSchedule, start, end);
                    result.append("C");
                    addedToCameron = true;
                }

                if (!addedToCameron) {
                    if (isAvailable(jamieSchedule, start, end)) {
                        fillSchedule(jamieSchedule, start, end);
                        result.append("J");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + result);
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

    private static void fillSchedule(int[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            schedule[k] = 1;
        }
    }
}