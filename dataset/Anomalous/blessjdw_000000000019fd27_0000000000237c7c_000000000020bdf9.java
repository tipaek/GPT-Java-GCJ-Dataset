import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int[] cameronSchedule = new int[24 * 60];
            int[] jamieSchedule = new int[24 * 60];
            int tasks = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            for (int n = 1; n <= tasks; n++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (result.length() > 0) continue;
                if (isAvailable(cameronSchedule, start, end)) {
                    assignTask(cameronSchedule, start, end, n);
                } else if (isAvailable(jamieSchedule, start, end)) {
                    assignTask(jamieSchedule, start, end, n);
                } else {
                    result.append("IMPOSSIBLE");
                }
            }
            if (result.length() == 0) {
                Set<Integer> cameronTasks = new HashSet<>();
                Set<Integer> jamieTasks = new HashSet<>();
                for (int task : cameronSchedule) cameronTasks.add(task);
                for (int task : jamieSchedule) jamieTasks.add(task);
                for (int i = 1; i <= tasks; i++) {
                    if (cameronTasks.contains(i)) result.append("C");
                    if (jamieTasks.contains(i)) result.append("J");
                }
                if (result.length() != tasks) throw new RuntimeException("Task assignment error");
            }
            System.out.println("Case #" + t + ": " + result.toString());
        }
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] > 0) return false;
        }
        return true;
    }

    private static void assignTask(int[] schedule, int start, int end, int taskNumber) {
        for (int i = start; i < end; i++) {
            schedule[i] = taskNumber;
        }
    }
}