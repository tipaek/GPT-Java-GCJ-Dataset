import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int tasks = scanner.nextInt();
            StringBuilder ans = new StringBuilder();
            String[] tasksList = new String[tasks];
            List<String> Ctasks = new ArrayList<>();
            List<String> JTasks = new ArrayList<>();

            for (int j = 0; j < tasks; j++) {
                int startingTime = scanner.nextInt();
                int endingTime = scanner.nextInt();
                tasksList[j] = startingTime + "-" + endingTime;
            }

            boolean possible = true;
            for (String task : tasksList) {
                String[] times = task.split("-");
                int startingTime = Integer.parseInt(times[0]);
                int endingTime = Integer.parseInt(times[1]);

                if (isTaskAssignable(startingTime, endingTime, Ctasks)) {
                    ans.append("C");
                } else if (isTaskAssignable(startingTime, endingTime, JTasks)) {
                    ans.append("J");
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + (i + 1) + ": " + ans);
            }
        }
    }

    private static boolean isTaskAssignable(int startingTime, int endTime, List<String> assignedTasks) {
        for (String task : assignedTasks) {
            String[] times = task.split("-");
            int taskStartTime = Integer.parseInt(times[0]);
            int taskEndTime = Integer.parseInt(times[1]);

            if ((startingTime < taskEndTime && endTime > taskStartTime) || (startingTime == taskStartTime && endTime == taskEndTime)) {
                return false;
            }
        }
        assignedTasks.add(startingTime + "-" + endTime);
        return true;
    }
}