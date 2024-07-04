import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();

            for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
                int activities = scanner.nextInt();
                int[][] schedule = new int[1441][2];
                boolean isImpossible = false;

                for (int activity = 1; activity <= activities; ++activity) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();

                    for (int time = start; time < end; time++) {
                        if (schedule(time, activity, schedule)) {
                            isImpossible = true;
                            break;
                        }
                    }

                    if (isImpossible) break;
                }

                if (isImpossible) {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + caseNumber + ": " + getScheduleResult(activities, schedule));
                }
            }
        }
    }

    private static boolean schedule(int time, int activity, int[][] schedule) {
        if (schedule[time][0] == 0) {
            schedule[time][0] = activity;
        } else if (schedule[time][1] == 0) {
            schedule[time][1] = activity;
        } else {
            return true;
        }
        return false;
    }

    private static String getScheduleResult(int activities, int[][] schedule) {
        char[] result = new char[activities];

        for (int time = 1; time < 1441; time++) {
            swapIfNeeded(schedule, time);

            if (schedule[time - 1][0] != schedule[time][0] && schedule[time - 1][0] != 0) {
                result[schedule[time - 1][0] - 1] = 'C';
            }
            if (schedule[time - 1][1] != schedule[time][1] && schedule[time - 1][1] != 0) {
                result[schedule[time - 1][1] - 1] = 'J';
            }
        }
        return new String(result);
    }

    private static void swapIfNeeded(int[][] schedule, int time) {
        if (schedule[time - 1][1] == schedule[time][0]) {
            int temp = schedule[time][0];
            schedule[time][0] = schedule[time][1];
            schedule[time][1] = temp;
        } else if (schedule[time - 1][0] == schedule[time][1]) {
            int temp = schedule[time][1];
            schedule[time][1] = schedule[time][0];
            schedule[time][0] = temp;
        }
    }
}