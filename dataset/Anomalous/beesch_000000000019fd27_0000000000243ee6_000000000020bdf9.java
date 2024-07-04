import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();

            for (int testCase = 1; testCase <= testCases; testCase++) {
                int numActivities = scanner.nextInt();
                byte[] cameronSchedule = new byte[1440];
                byte[] jamieSchedule = new byte[1440];
                StringBuilder schedule = new StringBuilder();
                boolean impossible = false;

                for (int activity = 0; activity < numActivities; activity++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();

                    if (impossible) {
                        continue;
                    }

                    if (!hasConflict(cameronSchedule, start, end)) {
                        markSchedule(cameronSchedule, start, end);
                        schedule.append('C');
                    } else if (!hasConflict(jamieSchedule, start, end)) {
                        markSchedule(jamieSchedule, start, end);
                        schedule.append('J');
                    } else {
                        impossible = true;
                    }
                }

                System.out.println("Case #" + testCase + ": " + (impossible ? "IMPOSSIBLE" : schedule.toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean hasConflict(byte[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) {
                return true;
            }
        }
        return false;
    }

    private static void markSchedule(byte[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}