import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = sc.nextInt();
        Solution sol = new Solution();

        for (int i = 0; i < cases; i++) {
            int taskCount = sc.nextInt();
            int[][] tasks = new int[taskCount][2];

            for (int j = 0; j < taskCount; j++) {
                tasks[j][0] = sc.nextInt();
                tasks[j][1] = sc.nextInt();
            }

            String result = sol.scheduleTasks(tasks);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        sc.close();
    }

    private String scheduleTasks(int[][] tasks) {
        int taskCount = tasks.length;
        HashMap<Integer, String> taskAssignment = new HashMap<>();

        for (int i = 0; i < taskCount; i++) {
            taskAssignment.put(i, "C");
        }

        int minStartTime = tasks[0][0];
        int minIndex = 0;

        for (int i = 1; i < taskCount; i++) {
            if (tasks[i][0] < minStartTime) {
                minStartTime = tasks[i][0];
                minIndex = i;
            }
        }

        boolean impossible = false;

        for (int i = 1; i < taskCount; i++) {
            for (int j = 0; j < i; j++) {
                if (isOverlap(tasks[i], tasks[j]) && taskAssignment.get(i).equals(taskAssignment.get(j))) {
                    taskAssignment.put(i, switchTask(taskAssignment.get(i)));
                    for (int k = 0; k < i; k++) {
                        if (isOverlap(tasks[i], tasks[k]) && taskAssignment.get(i).equals(taskAssignment.get(k))) {
                            impossible = true;
                            taskAssignment.put(0, "IMPOSSIBLE");
                            break;
                        }
                    }
                }
            }
        }

        if (!taskAssignment.get(0).equals("IMPOSSIBLE")) {
            if (taskAssignment.get(minIndex).equals("J")) {
                for (int i = 0; i < taskCount; i++) {
                    taskAssignment.put(i, switchTask(taskAssignment.get(i)));
                }
            }
        }

        StringBuilder output = new StringBuilder();
        if (!taskAssignment.get(0).equals("IMPOSSIBLE")) {
            for (int i = 0; i < taskCount; i++) {
                output.append(taskAssignment.get(i));
            }
        } else {
            output.append("IMPOSSIBLE");
        }

        return output.toString();
    }

    private String switchTask(String task) {
        return task.equals("C") ? "J" : "C";
    }

    private boolean isOverlap(int[] task1, int[] task2) {
        return !(task1[1] <= task2[0] || task2[1] <= task1[0]);
    }
}