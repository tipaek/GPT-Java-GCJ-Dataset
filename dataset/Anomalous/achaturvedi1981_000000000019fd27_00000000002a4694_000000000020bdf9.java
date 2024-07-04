import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            String[] data = new String[N];
            for (int j = 0; j < N; j++) {
                data[j] = scanner.nextLine();
            }
            System.out.println("Case #" + (i + 1) + ": " + processSchedule(N, data));
        }
        scanner.close();
    }

    private static String processSchedule(int n, String[] tasks) {
        int[][] timetable = new int[1440][2];
        for (int i = 0; i < n; i++) {
            String[] data = tasks[i].split(" ");
            int startTime = Integer.parseInt(data[0]);
            int endTime = Integer.parseInt(data[1]);
            if (!prepareTimeTable(timetable, startTime, endTime, i + 1)) {
                return "IMPOSSIBLE";
            }
        }
        return prepareSchedule(timetable, n);
    }

    private static String prepareSchedule(int[][] timetable, int n) {
        Map<Integer, Character> taskAssignment = new HashMap<>();
        for (int i = 0; i < 1440; i++) {
            int[] resources = new int[2];
            int[] tasks = timetable[i];
            for (int taskId : tasks) {
                if (taskAssignment.containsKey(taskId)) {
                    char c = taskAssignment.get(taskId);
                    if (c == 'C') {
                        resources[0] = taskId;
                    } else {
                        resources[1] = taskId;
                    }
                }
            }
            assignTask(taskAssignment, resources, tasks[0]);
            assignTask(taskAssignment, resources, tasks[1]);
        }
        return buildScheduleString(taskAssignment, n);
    }

    private static void assignTask(Map<Integer, Character> taskAssignment, int[] resources, int taskId) {
        if (taskId > 0) {
            if (taskAssignment.containsKey(taskId)) {
                char c = taskAssignment.get(taskId);
                if (c == 'C') {
                    resources[0] = taskId;
                } else {
                    resources[1] = taskId;
                }
            } else {
                char c = getResource(resources);
                if (c == 'C') {
                    resources[0] = taskId;
                } else {
                    resources[1] = taskId;
                }
                taskAssignment.put(taskId, c);
            }
        }
    }

    private static String buildScheduleString(Map<Integer, Character> taskAssignment, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(taskAssignment.get(i));
        }
        return sb.toString();
    }

    private static Character getResource(int[] resources) {
        return resources[0] == 0 ? 'C' : 'J';
    }

    private static boolean prepareTimeTable(int[][] timetable, int startTime, int endTime, int taskId) {
        for (int i = startTime; i < endTime; i++) {
            int[] slots = timetable[i];
            if (slots[0] == 0) {
                slots[0] = taskId;
            } else if (slots[1] == 0) {
                slots[1] = taskId;
            } else {
                return false;
            }
        }
        return true;
    }
}