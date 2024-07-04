import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt(); // Number of test cases

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            String result = assignTasks(n, intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignTasks(int n, int[][] intervals) {
        StringBuilder schedule = new StringBuilder("C"); // Start with 'C'
        List<Integer> cameronTasks = new ArrayList<>();
        List<Integer> jamieTasks = new ArrayList<>();
        cameronTasks.add(0);

        for (int x = 1; x < n; x++) {
            boolean assigned = false;

            for (int camTask : cameronTasks) {
                if (intervals[x][0] >= intervals[camTask][1]) {
                    schedule.append('C');
                    cameronTasks.add(x);
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                for (int jamTask : jamieTasks) {
                    if (intervals[x][0] >= intervals[jamTask][1]) {
                        schedule.append('J');
                        jamieTasks.add(x);
                        assigned = true;
                        break;
                    }
                }
            }

            if (!assigned) {
                if (jamieTasks.isEmpty() || intervals[x][0] >= intervals[jamieTasks.get(jamieTasks.size() - 1)][1]) {
                    schedule.append('J');
                    jamieTasks.add(x);
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }

        return schedule.toString();
    }
}