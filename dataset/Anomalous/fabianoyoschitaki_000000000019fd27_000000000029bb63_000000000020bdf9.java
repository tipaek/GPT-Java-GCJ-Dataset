import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int taskCount = scanner.nextInt();
            Integer[][] tasks = new Integer[taskCount][2];
            for (int j = 0; j < taskCount; j++) {
                tasks[j][0] = scanner.nextInt();
                tasks[j][1] = scanner.nextInt();
            }
            System.out.println("Case #" + (i + 1) + ": " + assignTasks(tasks));
        }
    }

    private static String assignTasks(Integer[][] tasks) {
        StringBuilder result = new StringBuilder();
        int cEnd = Integer.MIN_VALUE;
        int jEnd = Integer.MIN_VALUE;

        Integer[][] sortedTasks = Arrays.copyOf(tasks, tasks.length);
        Arrays.sort(sortedTasks, Comparator.comparingInt(o -> o[0]));

        for (Integer[] task : sortedTasks) {
            int start = task[0];
            int end = task[1];
            if (jEnd <= start) {
                jEnd = end;
            } else if (cEnd <= start) {
                cEnd = end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        cEnd = Integer.MIN_VALUE;
        jEnd = Integer.MIN_VALUE;
        for (Integer[] task : tasks) {
            int start = task[0];
            int end = task[1];
            if (jEnd <= start) {
                result.append("J");
                jEnd = end;
            } else if (cEnd <= start) {
                result.append("C");
                cEnd = end;
            }
        }
        return result.toString();
    }
}