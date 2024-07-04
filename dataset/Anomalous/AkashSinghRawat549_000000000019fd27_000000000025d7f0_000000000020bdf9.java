import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = sc.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < cases; i++) {
            int taskCount = sc.nextInt();
            int[][] tasks = new int[taskCount][2];

            for (int j = 0; j < taskCount; j++) {
                tasks[j][0] = sc.nextInt();
                tasks[j][1] = sc.nextInt();
            }

            String result = assignTasks(tasks);
            results.add(result);
        }

        for (int i = 0; i < cases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }

        sc.close();
    }

    private static String assignTasks(int[][] tasks) {
        HashMap<Integer, String> taskAssignments = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            taskAssignments.put(i, "C");
        }

        for (int i = 1; i < tasks.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isOverlap(tasks[i], tasks[j]) && taskAssignments.get(i).equals(taskAssignments.get(j))) {
                    taskAssignments.put(i, switchTask(taskAssignments.get(i)));
                    for (int k = 0; k < i; k++) {
                        if (isOverlap(tasks[i], tasks[k]) && taskAssignments.get(i).equals(taskAssignments.get(k))) {
                            return "IMPOSSIBLE";
                        }
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tasks.length; i++) {
            result.append(taskAssignments.get(i));
        }
        return result.toString();
    }

    private static String switchTask(String currentTask) {
        return currentTask.equals("C") ? "J" : "C";
    }

    private static boolean isOverlap(int[] task1, int[] task2) {
        return !(task1[1] <= task2[0] || task2[1] <= task1[0]);
    }
}