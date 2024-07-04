import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int taskCount = scanner.nextInt();
            Integer[][] tasks = new Integer[taskCount][2];
            for (int taskIndex = 0; taskIndex < taskCount; taskIndex++) {
                tasks[taskIndex][0] = scanner.nextInt();
                tasks[taskIndex][1] = scanner.nextInt();
            }
            System.out.println("Case #" + testCase + ": " + assignTasks(tasks));
        }
    }

    private static String assignTasks(Integer[][] tasks) {
        StringBuilder assignment = new StringBuilder();
        int endC = Integer.MIN_VALUE, endJ = Integer.MIN_VALUE;

        Integer[][] sortedTasks = Arrays.copyOf(tasks, tasks.length);
        Arrays.sort(sortedTasks, Comparator.comparingInt(task -> task[0]));

        for (Integer[] task : sortedTasks) {
            int start = task[0], end = task[1];
            if (end <= endJ || endJ <= start) {
                endJ = end;
            } else if (end <= endC || endC <= start) {
                endC = end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        endC = Integer.MIN_VALUE;
        endJ = Integer.MIN_VALUE;

        for (Integer[] task : tasks) {
            int start = task[0], end = task[1];
            if (end <= endJ || endJ <= start) {
                assignment.append("J");
                endJ = end;
            } else if (end <= endC || endC <= start) {
                assignment.append("C");
                endC = end;
            }
        }

        return assignment.toString();
    }
}