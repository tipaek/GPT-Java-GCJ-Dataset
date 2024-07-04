import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            List<int[]> cameronTasks = new ArrayList<>();
            List<int[]> jamieTasks = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();
            String result = "";

            int numberOfTasks = scanner.nextInt();
            for (int taskIndex = 0; taskIndex < numberOfTasks; taskIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                int[] currentTask = {start, end};

                if (isOverlapping(start, end, jamieTasks)) {
                    if (isOverlapping(start, end, cameronTasks)) {
                        result = "IMPOSSIBLE";
                        break;
                    } else {
                        cameronTasks.add(currentTask);
                        schedule.append('C');
                    }
                } else {
                    jamieTasks.add(currentTask);
                    schedule.append('J');
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                result = schedule.toString();
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }

    private static boolean isOverlapping(int start, int end, List<int[]> tasks) {
        for (int[] task : tasks) {
            int taskStart = task[0];
            int taskEnd = task[1];

            if ((taskStart == start && taskEnd == end) ||
                (taskStart < end && taskEnd > start) ||
                (taskStart > start && taskEnd < end) ||
                (taskStart < start && taskEnd > end)) {
                return true;
            }
        }
        return false;
    }
}