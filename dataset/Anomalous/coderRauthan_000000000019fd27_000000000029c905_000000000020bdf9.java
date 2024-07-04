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

                if (isAvailable(startingTime, endingTime, Ctasks)) {
                    ans.append("C");
                } else if (isAvailable(startingTime, endingTime, JTasks)) {
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

    private static boolean isAvailable(int startingTime, int endingTime, List<String> tasks) {
        for (String task : tasks) {
            String[] times = task.split("-");
            int taskStart = Integer.parseInt(times[0]);
            int taskEnd = Integer.parseInt(times[1]);

            if ((startingTime >= taskStart && startingTime < taskEnd) ||
                (endingTime > taskStart && endingTime <= taskEnd) ||
                (startingTime == taskStart && endingTime == taskEnd)) {
                return false;
            }
        }
        tasks.add(startingTime + "-" + endingTime);
        return true;
    }
}