import java.util.*;

public class Solution {
    
    static Scanner scanner = new Scanner(System.in);
    
    static String assignTasks(int taskCount, int[][] tasks) {
        StringBuilder result = new StringBuilder();
        int jEndTime = 0;
        int cEndTime = 0;

        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));

        for (int i = 0; i < taskCount; ++i) {
            if (jEndTime > cEndTime) {
                if (tasks[i][0] < cEndTime) {
                    return "IMPOSSIBLE";
                }
                if (tasks[i][0] < jEndTime) {
                    result.append('C');
                    cEndTime = tasks[i][1];
                } else {
                    result.append('J');
                    jEndTime = tasks[i][1];
                }
            } else {
                if (tasks[i][0] < jEndTime) {
                    return "IMPOSSIBLE";
                }
                if (tasks[i][0] < cEndTime) {
                    result.append('J');
                    jEndTime = tasks[i][1];
                } else {
                    result.append('C');
                    cEndTime = tasks[i][1];
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; ++t) {
            int taskCount = scanner.nextInt();
            int[][] tasks = new int[taskCount][2];

            for (int i = 0; i < taskCount; ++i) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }

            String result = assignTasks(taskCount, tasks);
            System.out.printf("Case #%d: %s\n", t, result);
        }

        scanner.close();
    }
}