import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        StringBuilder output = new StringBuilder();

        for (int t = 1; t <= testCaseCount; t++) {
            int n = sc.nextInt();
            int[][] jTasks = new int[n][2];
            int[][] cTasks = new int[n][2];
            int jIndex = 0, cIndex = 0;
            StringBuilder result = new StringBuilder();

            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                if (i == 0) {
                    jTasks[jIndex++] = new int[]{start, end};
                    result.append("J");
                    continue;
                }

                boolean canAssignToJ = true;
                boolean canAssignToC = true;

                for (int[] task : jTasks) {
                    if (isOverlapping(task, start, end)) {
                        canAssignToJ = false;
                        break;
                    }
                }

                for (int[] task : cTasks) {
                    if (task[0] == 0 && task[1] == 0) break;
                    if (isOverlapping(task, start, end)) {
                        canAssignToC = false;
                        break;
                    }
                }

                if (!canAssignToJ && !canAssignToC) {
                    result = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                } else if (canAssignToC && !canAssignToJ) {
                    cTasks[cIndex++] = new int[]{start, end};
                    result.append("C");
                } else if (canAssignToJ && !canAssignToC) {
                    jTasks[jIndex++] = new int[]{start, end};
                    result.append("J");
                } else {
                    int jMinIndex = findMinIndex(jTasks, start);
                    int cMinIndex = findMinIndex(cTasks, start);

                    if (start - jTasks[jMinIndex][1] <= start - cTasks[cMinIndex][1]) {
                        jTasks[jIndex++] = new int[]{start, end};
                        result.append("J");
                    } else {
                        cTasks[cIndex++] = new int[]{start, end};
                        result.append("C");
                    }
                }
            }

            output.append("Case #").append(t).append(": ").append(result).append("\n");
        }

        System.out.print(output.toString());
        sc.close();
    }

    private static boolean isOverlapping(int[] task, int start, int end) {
        return (start < task[1] && end > task[0]);
    }

    private static int findMinIndex(int[][] tasks, int start) {
        int minDiff = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i][1] != 0 && start >= tasks[i][1]) {
                int diff = start - tasks[i][1];
                if (diff < minDiff) {
                    minDiff = diff;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
}