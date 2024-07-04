import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; ++t) {
            int[] cameronSchedule = new int[1441];
            int[] jamieSchedule = new int[1441];
            int numTasks = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (int n = 1; n <= numTasks; n++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (start < 0 || start >= cameronSchedule.length || end < 0 || end >= cameronSchedule.length) {
                    result.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }

                if (isAvailable(cameronSchedule, start, end)) {
                    bookTask(cameronSchedule, start, end, n);
                } else if (isAvailable(jamieSchedule, start, end)) {
                    bookTask(jamieSchedule, start, end, n);
                } else {
                    result.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                Set<Integer> cameronTasks = new HashSet<>();
                for (int task : cameronSchedule) {
                    cameronTasks.add(task);
                }
                for (int i = 1; i <= numTasks; i++) {
                    if (cameronTasks.contains(i)) {
                        result.append("C");
                    } else {
                        result.append("J");
                    }
                }
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private static void bookTask(int[] schedule, int start, int end, int taskNumber) {
        for (int i = start; i < end; i++) {
            schedule[i] = taskNumber;
        }
    }
}