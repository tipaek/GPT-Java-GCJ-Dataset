import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

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

            HashMap<Short, Short> cameron = new HashMap<>();
            HashMap<Short, Short> jamie = new HashMap<>();

            boolean isPossible = true;

            for (int i = 0; i < taskSize; i++) {
                short taskInit = scanner.nextShort();
                short taskEnd = scanner.nextShort();

                if (isPossible && canSchedule(jamie, taskInit, taskEnd)) {
                    lineResult.append("J");
                } else if (isPossible && canSchedule(cameron, taskInit, taskEnd)) {
                    lineResult.append("C");
                } else {
                    lineResult = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                }
            }

            result.append("Case #").append(test).append(": ").append(lineResult).append("\n");
        }
        System.out.print(result);
    }

    private static boolean canSchedule(HashMap<Short, Short> schedule, short taskInit, short taskEnd) {
        for (Map.Entry<Short, Short> entry : schedule.entrySet()) {
            if (taskEnd > entry.getKey() && taskInit < entry.getValue()) {
                return false;
            }
        }
        schedule.put(taskInit, taskEnd);
        return true;
    }
}