import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        String[] results = new String[t];

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] tasks = new int[n][2];

            for (int j = 0; j < n; j++) {
                tasks[j][0] = scanner.nextInt();
                tasks[j][1] = scanner.nextInt();
            }

            results[i] = assignTasks(tasks, n);
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }

    public static String assignTasks(int[][] tasks, int n) {
        StringBuilder result = new StringBuilder();
        List<int[]> cameronTasks = new ArrayList<>();
        List<int[]> jamieTasks = new ArrayList<>();
        boolean isImpossible = false;

        for (int i = 0; i < n && !isImpossible; i++) {
            boolean isCameronAvailable = true;

            for (int[] task : cameronTasks) {
                if (tasks[i][0] < task[1] && tasks[i][1] > task[0]) {
                    isCameronAvailable = false;
                    break;
                }
            }

            if (isCameronAvailable) {
                cameronTasks.add(tasks[i]);
                result.append("C");
            } else {
                boolean isJamieAvailable = true;

                for (int[] task : jamieTasks) {
                    if (tasks[i][0] < task[1] && tasks[i][1] > task[0]) {
                        isJamieAvailable = false;
                        break;
                    }
                }

                if (isJamieAvailable) {
                    jamieTasks.add(tasks[i]);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                }
            }
        }

        return result.toString();
    }
}