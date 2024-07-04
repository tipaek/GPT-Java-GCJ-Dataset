import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        short T = in.nextShort();
        if (T <= 0) {
            return;
        }

        StringBuilder result = new StringBuilder();

        for (int test = 1; test <= T; ++test) {
            short taskSize = in.nextShort();
            if (taskSize <= 0) {
                return;
            }

            StringBuilder lineResult = new StringBuilder();

            HashMap<Short, Short> cameron = new HashMap<>();
            HashMap<Short, Short> jamie = new HashMap<>();

            boolean possible = true;

            for (int i = 0; i < taskSize; i++) {
                short taskInit = in.nextShort();
                short taskEnd = in.nextShort();

                if (isSchedulable(jamie, taskInit, taskEnd)) {
                    lineResult.append("J");
                } else if (isSchedulable(cameron, taskInit, taskEnd)) {
                    lineResult.append("C");
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

    private static boolean isSchedulable(HashMap<Short, Short> schedule, short taskInit, short taskEnd) {
        for (Map.Entry<Short, Short> entry : schedule.entrySet()) {
            if (taskEnd > entry.getKey() && taskInit < entry.getValue()) {
                return false;
            }
        }
        schedule.put(taskInit, taskEnd);
        return true;
    }
}