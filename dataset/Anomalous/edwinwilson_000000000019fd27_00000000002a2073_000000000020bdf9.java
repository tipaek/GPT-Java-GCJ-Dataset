import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        for (int caseNumber = 1; caseNumber <= numCases; caseNumber++) {
            result.append("Case #").append(caseNumber).append(": ");
            int numTasks = Integer.parseInt(scanner.nextLine());
            List<int[]> cTasks = new ArrayList<>();
            List<int[]> jTasks = new ArrayList<>();
            StringBuilder caseResult = new StringBuilder();

            for (int i = 0; i < numTasks; i++) {
                String[] task = scanner.nextLine().split("\\s+");
                int start = Integer.parseInt(task[0]);
                int end = Integer.parseInt(task[1]);

                if (canAssignTask(cTasks, start, end)) {
                    cTasks.add(new int[]{start, end});
                    caseResult.append("C");
                } else if (canAssignTask(jTasks, start, end)) {
                    jTasks.add(new int[]{start, end});
                    caseResult.append("J");
                } else {
                    caseResult = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            result.append(caseResult).append("\n");
        }

        System.out.print(result);
    }

    private static boolean canAssignTask(List<int[]> tasks, int start, int end) {
        for (int[] task : tasks) {
            if (start < task[1] && end > task[0]) {
                return false;
            }
        }
        return true;
    }
}