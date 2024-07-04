import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            List<int[]> cameronTasks = new ArrayList<>();
            List<int[]> jamieTasks = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();
            String result = "";

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                int[] task = {start, end};

                if (isOverlapping(start, end, jamieTasks)) {
                    if (isOverlapping(start, end, cameronTasks)) {
                        result = "IMPOSSIBLE";
                        break;
                    } else {
                        cameronTasks.add(task);
                        schedule.append('C');
                    }
                } else {
                    jamieTasks.add(task);
                    schedule.append('J');
                }
            }

            result = result.equals("IMPOSSIBLE") ? "IMPOSSIBLE" : schedule.toString();
            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }

    private static boolean isOverlapping(int start, int end, List<int[]> tasks) {
        for (int[] task : tasks) {
            int taskStart = task[0];
            int taskEnd = task[1];

            if ((taskStart < end && taskEnd > start) || (taskStart == start && taskEnd == end)) {
                return true;
            }
        }
        return false;
    }
}