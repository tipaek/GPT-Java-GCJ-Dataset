import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        short testCases = scanner.nextShort();
        if (testCases == 0) {
            return;
        }

        StringBuilder result = new StringBuilder();

        for (int test = 1; test <= testCases; ++test) {
            short taskCount = scanner.nextShort();
            if (taskCount == 0) {
                return;
            }

            StringBuilder lineResult = new StringBuilder();

            HashMap<Short, Short> cameronSchedule = new HashMap<>();
            HashMap<Short, Short> jamieSchedule = new HashMap<>();

            boolean possible = true;

            for (int i = 0; i < taskCount; i++) {

                short taskStart = scanner.nextShort();
                short taskEnd = scanner.nextShort();

                if (canSchedule(jamieSchedule, taskStart, taskEnd)) {
                    lineResult.append("J");
                } else if (canSchedule(cameronSchedule, taskStart, taskEnd)) {
                    lineResult.append("C");
                } else {
                    lineResult = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                result.append("Case #").append(test).append(": ").append(lineResult.toString()).append("\n");
            } else {
                result.append("Case #").append(test).append(": IMPOSSIBLE\n");
            }
        }
        System.out.println(result.toString());
    }

    static boolean canSchedule(HashMap<Short, Short> schedule, short taskStart, short taskEnd) {

        for (Map.Entry<Short, Short> scheduledTask : schedule.entrySet()) {
            if (taskEnd > scheduledTask.getKey() && taskStart < scheduledTask.getValue()) {
                return false;
            }
        }
        schedule.put(taskStart, taskEnd);
        return true;
    }
}