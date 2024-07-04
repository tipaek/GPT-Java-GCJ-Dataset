import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] tasks = new int[n][3];

            for (int i = 0; i < n; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
                tasks[i][2] = i;
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task[0]));

            String[] assignment = new String[n];
            int cEnd = tasks[0][1];
            assignment[tasks[0][2]] = "C";

            for (int i = 1; i < n; i++) {
                if (tasks[i][0] >= cEnd) {
                    assignment[tasks[i][2]] = "C";
                    cEnd = tasks[i][1];
                } else {
                    assignment[tasks[i][2]] = "J";
                }
            }

            int jEnd = 0;
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                if ("J".equals(assignment[tasks[i][2]])) {
                    if (tasks[i][0] < jEnd) {
                        possible = false;
                        break;
                    } else {
                        jEnd = tasks[i][1];
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            if (!possible) {
                result.append("IMPOSSIBLE");
            } else {
                for (String s : assignment) {
                    result.append(s);
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}