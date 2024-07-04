import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        short T = scanner.nextShort();
        if (T == 0) {
            return;
        }

        StringBuilder result = new StringBuilder();

        for (int test = 1; test <= T; ++test) {
            short taskSize = scanner.nextShort();
            if (taskSize == 0) {
                return;
            }

            StringBuilder lineResult = new StringBuilder();
            HashMap<Short, Short> cameronSchedule = new HashMap<>();
            HashMap<Short, Short> jamieSchedule = new HashMap<>();

            boolean isPossible = true;

            for (int i = 0; i < taskSize; i++) {
                short taskStart = scanner.nextShort();
                short taskEnd = scanner.nextShort();

                if (canSchedule(jamieSchedule, taskStart, taskEnd)) {
                    lineResult.append("J");
                } else if (canSchedule(cameronSchedule, taskStart, taskEnd)) {
                    lineResult.append("C");
                } else {
                    lineResult.setLength(0);
                    lineResult.append("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            result.append("Case #").append(test).append(": ").append(lineResult).append("\n");
        }

        System.out.print(result);
    }

    static boolean canSchedule(HashMap<Short, Short> schedule, short taskStart, short taskEnd) {
        for (Map.Entry<Short, Short> entry : schedule.entrySet()) {
            if (taskEnd > entry.getKey() && taskStart < entry.getValue()) {
                return false;
            }
        }
        schedule.put(taskStart, taskEnd);
        return true;
    }
}