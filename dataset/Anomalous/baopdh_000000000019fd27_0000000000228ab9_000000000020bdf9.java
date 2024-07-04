import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();
            int[][] tasks = new int[n][3];

            for (int j = 0; j < n; ++j) {
                tasks[j][0] = scanner.nextInt();
                tasks[j][1] = scanner.nextInt();
                tasks[j][2] = j;
            }

            Arrays.sort(tasks, (task1, task2) -> Integer.compare(task1[0], task2[0]));

            int cEnd = 0, jEnd = 0;
            boolean[] assignedToC = new boolean[n];
            boolean possible = true;

            for (int k = 0; k < n; ++k) {
                if (tasks[k][0] >= cEnd) {
                    assignedToC[tasks[k][2]] = true;
                    cEnd = tasks[k][1];
                } else if (tasks[k][0] >= jEnd) {
                    jEnd = tasks[k][1];
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                StringBuilder result = new StringBuilder();
                for (boolean isC : assignedToC) {
                    result.append(isC ? "C" : "J");
                }
                System.out.printf("Case #%d: %s\n", i, result.toString());
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", i);
            }
        }

        scanner.close();
    }
}