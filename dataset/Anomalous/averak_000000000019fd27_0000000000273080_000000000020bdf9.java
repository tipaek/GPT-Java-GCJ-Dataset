import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            if (scanner.hasNext()) {
                int numActivities = scanner.nextInt();
                boolean[] cameronSchedule = new boolean[1441];
                boolean[] jamieSchedule = new boolean[1441];
                StringBuilder result = new StringBuilder();

                boolean possible = true;
                for (int j = 0; j < numActivities; j++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt() - 1;

                    if (isAvailable(cameronSchedule, start, end)) {
                        result.append("C");
                        markSchedule(cameronSchedule, start, end);
                    } else if (isAvailable(jamieSchedule, start, end)) {
                        result.append("J");
                        markSchedule(jamieSchedule, start, end);
                    } else {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    System.out.println("Case #" + t + ": " + result.toString());
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                }
            }
        }
    }

    private static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i <= end; i++) {
            schedule[i] = true;
        }
    }
}