import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; ++testCase) {
            int taskCount = scanner.nextInt();
            StringBuilder result = new StringBuilder();

            HashMap<Integer, Integer> cameronSchedule = new HashMap<>();
            HashMap<Integer, Integer> jamieSchedule = new HashMap<>();

            boolean isPossible = true;

            for (int i = 0; i < taskCount; i++) {
                int taskStart = scanner.nextInt();
                int taskEnd = scanner.nextInt();

                if (canSchedule(cameronSchedule, taskStart, taskEnd)) {
                    result.append("C");
                } else if (canSchedule(jamieSchedule, taskStart, taskEnd)) {
                    result.append("J");
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }

    static boolean canSchedule(HashMap<Integer, Integer> schedule, int taskStart, int taskEnd) {
        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            int scheduledStart = entry.getKey();
            int scheduledEnd = entry.getValue();
            if ((taskStart < scheduledEnd && taskEnd > scheduledStart)) {
                return false;
            }
        }
        schedule.put(taskStart, taskEnd);
        return true;
    }
}