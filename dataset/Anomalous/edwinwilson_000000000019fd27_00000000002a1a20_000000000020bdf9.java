import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        for (int currentCase = 1; currentCase <= numCases; currentCase++) {
            result.append("Case #").append(currentCase).append(": ");
            int numTasks = Integer.parseInt(scanner.nextLine());
            List<int[]> cameronTasks = new ArrayList<>();
            List<int[]> jamieTasks = new ArrayList<>();
            StringBuilder currentResult = new StringBuilder();

            boolean possible = true;

            for (int i = 0; i < numTasks; i++) {
                String[] input = scanner.nextLine().split("\\s+");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);

                if (assignTask(cameronTasks, start, end)) {
                    currentResult.append("C");
                } else if (assignTask(jamieTasks, start, end)) {
                    currentResult.append("J");
                } else {
                    currentResult = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                result.append(currentResult).append("\n");
            } else {
                result.append("IMPOSSIBLE\n");
            }
        }

        System.out.print(result.toString());
    }

    private static boolean assignTask(List<int[]> tasks, int start, int end) {
        for (int[] task : tasks) {
            if (start < task[1] && end > task[0]) {
                return false;
            }
        }
        tasks.add(new int[]{start, end});
        return true;
    }
}