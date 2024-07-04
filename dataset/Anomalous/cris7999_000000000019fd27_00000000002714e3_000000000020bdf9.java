import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numTestCases; testCase++) {
            int numActivities = scanner.nextInt();
            List<int[]> jaimeTasks = new ArrayList<>();
            List<int[]> cameronTasks = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            boolean isImpossible = false;
            scanner.nextLine();

            for (int i = 0; i < numActivities; i++) {
                String[] taskDetails = scanner.nextLine().split(" ");
                int start = Integer.parseInt(taskDetails[0]);
                int finish = Integer.parseInt(taskDetails[1]);

                if (canAssignTask(cameronTasks, start, finish)) {
                    cameronTasks.add(new int[]{start, finish});
                    result.append('C');
                } else if (canAssignTask(jaimeTasks, start, finish)) {
                    jaimeTasks.add(new int[]{start, finish});
                    result.append('J');
                } else {
                    isImpossible = true;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + result.toString());
            }
        }

        scanner.close();
    }

    private static boolean canAssignTask(List<int[]> taskList, int start, int finish) {
        for (int[] task : taskList) {
            if ((start >= task[0] && start < task[1]) || (finish > task[0] && finish <= task[1])) {
                return false;
            }
        }
        return true;
    }
}