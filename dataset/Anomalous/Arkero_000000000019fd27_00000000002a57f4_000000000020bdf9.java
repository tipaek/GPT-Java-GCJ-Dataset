import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

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

            TreeMap<Short, Short> cameronSchedule = new TreeMap<>();
            TreeMap<Short, Short> jamieSchedule = new TreeMap<>();

            boolean possible = true;

            for (int i = 0; i < taskCount; i++) {
                short taskStart = scanner.nextShort();
                short taskEnd = scanner.nextShort();

                if (isScheduleAvailable(jamieSchedule, taskStart, taskEnd)) {
                    lineResult.append("J");
                } else if (isScheduleAvailable(cameronSchedule, taskStart, taskEnd)) {
                    lineResult.append("C");
                } else {
                    lineResult = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                result.append("Case #").append(test).append(": ").append(lineResult).append("\n");
            } else {
                result.append("Case #").append(test).append(": IMPOSSIBLE\n");
            }
        }
        System.out.println(result);
    }

    static boolean isScheduleAvailable(TreeMap<Short, Short> schedule, short taskStart, short taskEnd) {
        for (Entry<Short, Short> entry : schedule.entrySet()) {
            if (taskEnd > entry.getKey() && taskStart < entry.getValue()) {
                return false;
            }
        }
        schedule.put(taskStart, taskEnd);
        return true;
    }
}