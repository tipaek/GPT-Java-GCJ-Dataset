import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        short testCases = scanner.nextShort();
        if (testCases <= 0) {
            return;
        }

        StringBuilder result = new StringBuilder();

        for (int test = 1; test <= testCases; ++test) {
            short taskCount = scanner.nextShort();
            if (taskCount <= 0) {
                return;
            }

            StringBuilder lineResult = new StringBuilder();
            HashMap<Short, Short> cameronSchedule = new HashMap<>();
            HashMap<Short, Short> jamieSchedule = new HashMap<>();

            boolean isPossible = true;

            for (int i = 0; i < taskCount; i++) {
                short taskStart = scanner.nextShort();
                short taskEnd = scanner.nextShort();

                if (canSchedule(jamieSchedule, taskStart, taskEnd)) {
                    lineResult.append("J");
                } else if (canSchedule(cameronSchedule, taskStart, taskEnd)) {
                    lineResult.append("C");
                } else {
                    lineResult = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            result.append("Case #").append(test).append(": ").append(lineResult).append("\n");
        }
        System.out.print(result);
    }

    private static boolean canSchedule(HashMap<Short, Short> schedule, short taskStart, short taskEnd) {
        if (schedule.containsKey(taskStart)) {
            return false;
        }

        for (Map.Entry<Short, Short> entry : schedule.entrySet()) {
            if (taskEnd > entry.getKey() && taskStart < entry.getValue()) {
                return false;
            }
        }

        schedule.put(taskStart, taskEnd);
        return true;
    }
}