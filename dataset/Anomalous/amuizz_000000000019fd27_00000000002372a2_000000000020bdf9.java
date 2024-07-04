import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            List<int[]> cameronSchedule = new ArrayList<>();
            List<int[]> jamieSchedule = new ArrayList<>();
            int taskCount = Integer.parseInt(scanner.nextLine());
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < taskCount; i++) {
                int[] task = parseTask(scanner.nextLine());

                if (!hasOverlap(jamieSchedule, task)) {
                    jamieSchedule.add(task);
                    result.append("J");
                } else if (!hasOverlap(cameronSchedule, task)) {
                    cameronSchedule.add(task);
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static int[] parseTask(String input) {
        String[] parts = input.split(" ");
        return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
    }

    private static boolean hasOverlap(List<int[]> schedule, int[] task) {
        for (int[] scheduledTask : schedule) {
            if (isOverlapping(scheduledTask, task)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOverlapping(int[] task1, int[] task2) {
        return (task1[0] < task2[1] && task1[1] > task2[0]);
    }
}