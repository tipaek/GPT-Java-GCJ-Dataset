import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        short T = in.nextShort();
        StringBuilder result = new StringBuilder();

        for (int test = 1; test <= T; ++test) {
            short taskSize = in.nextShort();
            StringBuilder lineResult = new StringBuilder();

            HashMap<Short, Short> cameron = new HashMap<>();
            HashMap<Short, Short> jamie = new HashMap<>();

            for (int i=0; i<taskSize; i++) {

                Short taskInit = in.nextShort();
                Short taskEnd = in.nextShort();

                if (checkSchedule(jamie, taskInit, taskEnd)) {
                    lineResult.append("J");

                } else {
                    if (checkSchedule(cameron, taskInit, taskEnd)) {
                        lineResult.append("C");
                    } else {
                        lineResult.replace(0, lineResult.length(), "IMPOSSIBLE");
                        break;
                    }
                }
            }

            result.append("Case #" + test + ": " + lineResult.toString() + "\n");
        }
        System.out.println(result);
    }

    static boolean checkSchedule(HashMap<Short, Short> schedule, Short taskInit, Short taskEnd) {

        if (taskInit == null || taskEnd == null) {
            return false;
        }

        for (Entry<Short, Short> scheduledTask : schedule.entrySet()) {

            if (scheduledTask == null || scheduledTask.getKey() == null || scheduledTask.getValue() == null) {
                return false;
            }

            if (taskEnd > scheduledTask.getKey() && taskInit < scheduledTask.getValue()) {
                return false;
            }
        }
        schedule.put(taskInit, taskEnd);
        return true;
    }

}
