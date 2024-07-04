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
            List<String> cTasks = new ArrayList<>();
            List<String> jTasks = new ArrayList<>();

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

                if (isTimeSlotAvailable(startingTime, endingTime, cTasks)) {
                    ans.append("C");
                } else if (isTimeSlotAvailable(startingTime, endingTime, jTasks)) {
                    ans.append("J");
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + (i + 1) + ": " + ans.toString());
            }
        }

        scanner.close();
    }

    private static boolean isTimeSlotAvailable(int startingTime, int endingTime, List<String> taskList) {
        for (String task : taskList) {
            String[] times = task.split("-");
            int taskStartTime = Integer.parseInt(times[0]);
            int taskEndTime = Integer.parseInt(times[1]);

            if ((startingTime >= taskStartTime && startingTime < taskEndTime) ||
                (endingTime > taskStartTime && endingTime <= taskEndTime)) {
                return false;
            }
        }

        taskList.add(startingTime + "-" + endingTime);
        return true;
    }
}