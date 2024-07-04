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
            int[] cameronSchedule = new int[60 * 24 + 1];
            int[] jamieSchedule = new int[60 * 24 + 1];
            int numActivities = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (int i = 1; i <= numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (isAvailable(cameronSchedule, start, end)) {
                    bookSchedule(cameronSchedule, start, end, i);
                } else if (isAvailable(jamieSchedule, start, end)) {
                    bookSchedule(jamieSchedule, start, end, i);
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
                Set<Integer> jamieTasks = new HashSet<>();
                for (int task : jamieSchedule) {
                    jamieTasks.add(task);
                }
                for (int i = 1; i <= numActivities; i++) {
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

    private static void bookSchedule(int[] schedule, int start, int end, int taskId) {
        for (int i = start; i < end; i++) {
            schedule[i] = taskId;
        }
    }
}