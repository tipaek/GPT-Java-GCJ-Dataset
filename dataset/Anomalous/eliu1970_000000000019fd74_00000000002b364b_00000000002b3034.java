import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int numberOfCases = Integer.parseInt(br.readLine());

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int numTasks = Integer.parseInt(br.readLine());
            int[][] tasks = new int[numTasks][2];
            int[][] originalTasks = new int[numTasks][2];
            String[] assignments = new String[numTasks];

            for (int i = 0; i < numTasks; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                tasks[i][0] = Integer.parseInt(st.nextToken());
                tasks[i][1] = Integer.parseInt(st.nextToken());
                originalTasks[i][0] = tasks[i][0];
                originalTasks[i][1] = tasks[i][1];
            }

            Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

            int cEndTime = 0, jEndTime = 0;
            String result = "";

            for (int[] task : tasks) {
                int originalIndex = findOriginalIndex(originalTasks, task);
                if (task[0] >= cEndTime) {
                    assignments[originalIndex] = "C";
                    cEndTime = task[1];
                } else if (task[0] >= jEndTime) {
                    assignments[originalIndex] = "J";
                    jEndTime = task[1];
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                result = String.join("", assignments);
            }

            out.println("Case #" + caseIndex + ": " + result);
        }
        out.close();
    }

    private static int findOriginalIndex(int[][] originalTasks, int[] task) {
        for (int i = 0; i < originalTasks.length; i++) {
            if (originalTasks[i][0] == task[0] && originalTasks[i][1] == task[1]) {
                originalTasks[i][0] = Integer.MAX_VALUE; // Mark as visited
                return i;
            }
        }
        return -1; // Should never reach here
    }
}