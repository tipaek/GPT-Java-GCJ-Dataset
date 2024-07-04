import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int test = 1; test <= T; ++test) {
            int taskCount = scanner.nextInt();
            StringBuilder lineResult = new StringBuilder();

            HashMap<Integer, Integer> cameronSchedule = new HashMap<>();
            HashMap<Integer, Integer> jamieSchedule = new HashMap<>();

            boolean possible = true;
            for (int i = 0; i < taskCount; i++) {
                int taskStart = scanner.nextInt();
                int taskEnd = scanner.nextInt();

                if (isSchedulable(cameronSchedule, taskStart, taskEnd)) {
                    lineResult.append("C");
                } else if (isSchedulable(jamieSchedule, taskStart, taskEnd)) {
                    lineResult.append("J");
                } else {
                    lineResult.setLength(0);
                    lineResult.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            result.append("Case #").append(test).append(": ").append(lineResult).append("\n");
        }
        System.out.print(result);
    }

    private static boolean isSchedulable(HashMap<Integer, Integer> schedule, int taskStart, int taskEnd) {
        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            if (!(taskEnd <= entry.getKey() || taskStart >= entry.getValue())) {
                return false;
            }
        }
        schedule.put(taskStart, taskEnd);
        return true;
    }
}