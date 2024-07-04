import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];
        for (int i = 0; i < testCases; i++) {
            int numTasks = scanner.nextInt();
            int[][] tasks = new int[numTasks][3];
            for (int j = 0; j < numTasks; j++) {
                tasks[j][0] = j;
                tasks[j][1] = scanner.nextInt();
                tasks[j][2] = scanner.nextInt();
            }
            results[i] = scheduleTasks(tasks, numTasks);
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }

    public static String scheduleTasks(int[][] tasks, int numTasks) {
        char[] schedule = new char[numTasks];
        List<int[]> cameronTasks = new ArrayList<>();
        List<int[]> jamieTasks = new ArrayList<>();
        
        tasks = sortTasks(tasks, numTasks);

        for (int i = 0; i < numTasks; i++) {
            boolean assigned = false;
            if (canAssignTask(tasks[i], cameronTasks)) {
                cameronTasks.add(tasks[i]);
                schedule[tasks[i][0]] = 'C';
                assigned = true;
            } else if (canAssignTask(tasks[i], jamieTasks)) {
                jamieTasks.add(tasks[i]);
                schedule[tasks[i][0]] = 'J';
                assigned = true;
            }
            if (!assigned) {
                return "IMPOSSIBLE";
            }
        }

        return new String(schedule);
    }

    private static boolean canAssignTask(int[] task, List<int[]> assignedTasks) {
        for (int[] assignedTask : assignedTasks) {
            if (task[1] < assignedTask[2] && task[2] > assignedTask[1]) {
                return false;
            }
        }
        return true;
    }

    public static int[][] sortTasks(int[][] tasks, int numTasks) {
        for (int i = 0; i < numTasks - 1; i++) {
            for (int j = 0; j < numTasks - i - 1; j++) {
                if (tasks[j][1] > tasks[j + 1][1] || 
                    (tasks[j][1] == tasks[j + 1][1] && tasks[j][2] > tasks[j + 1][2])) {
                    int[] temp = tasks[j];
                    tasks[j] = tasks[j + 1];
                    tasks[j + 1] = temp;
                }
            }
        }
        return tasks;
    }
}