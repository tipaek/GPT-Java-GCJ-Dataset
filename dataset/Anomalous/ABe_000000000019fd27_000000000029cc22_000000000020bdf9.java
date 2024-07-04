import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            boolean possible = true;
            int n = scanner.nextInt();
            int endC = 0, endJ = 0;

            int[][] tasks = new int[n][2];
            for (int j = 0; j < n; j++) {
                tasks[j][0] = scanner.nextInt();
                tasks[j][1] = scanner.nextInt();
            }

            char[] assignments = new char[n];
            Arrays.fill(assignments, '?');

            for (int m = 0; m < n; m++) {
                int earliestStartTime = Integer.MAX_VALUE;
                int taskIndex = -1;

                for (int o = 0; o < n; o++) {
                    if (tasks[o][0] < earliestStartTime) {
                        earliestStartTime = tasks[o][0];
                        taskIndex = o;
                    }
                }

                if (endC <= tasks[taskIndex][0]) {
                    assignments[taskIndex] = 'C';
                    endC = tasks[taskIndex][1];
                    tasks[taskIndex][0] = Integer.MAX_VALUE;
                } else if (endJ <= tasks[taskIndex][0]) {
                    assignments[taskIndex] = 'J';
                    endJ = tasks[taskIndex][1];
                    tasks[taskIndex][0] = Integer.MAX_VALUE;
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? new String(assignments) : "IMPOSSIBLE";
            System.out.println("Case #" + i + ": " + result);
        }
    }
}