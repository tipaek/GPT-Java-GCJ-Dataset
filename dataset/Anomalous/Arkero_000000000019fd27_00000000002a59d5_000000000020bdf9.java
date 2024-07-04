import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        short T = in.nextShort();
        if (T == 0) {
            return;
        }

        StringBuilder result = new StringBuilder();

        for (int test = 1; test <= T; ++test) {
            short taskSize = in.nextShort();
            if (taskSize == 0) {
                return;
            }

            StringBuilder lineResult = new StringBuilder();

            TreeMap<Short, Short> cameron = new TreeMap<>();
            TreeMap<Short, Short> jamie = new TreeMap<>();

            boolean possible = true;

            for (int i = 0; i < taskSize; i++) {

                short taskInit = in.nextShort();
                short taskEnd = in.nextShort();

                if (canSchedule(jamie, taskInit, taskEnd)) {
                    lineResult.append("J");
                } else if (canSchedule(cameron, taskInit, taskEnd)) {
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

    static boolean canSchedule(TreeMap<Short, Short> schedule, short taskInit, short taskEnd) {

        for (Entry<Short, Short> scheduledTask : schedule.entrySet()) {
            if (taskEnd > scheduledTask.getKey() && taskInit < scheduledTask.getValue()) {
                return false;
            }
        }
        schedule.put(taskInit, taskEnd);
        return true;
    }
}