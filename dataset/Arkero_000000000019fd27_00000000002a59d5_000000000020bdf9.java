import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        Short T = in.nextShort();
        if (T == null && T == 0 ) {
            return;
        }

        StringBuilder result = new StringBuilder();

        for (int test = 1; test <= T; ++test) {
            Short taskSize = in.nextShort();
            if (taskSize == null && taskSize == 0 ) {
                return;
            }

            StringBuilder lineResult = new StringBuilder();

            TreeMap<Short, Short> cameron = new TreeMap<>();
            TreeMap<Short, Short> jamie = new TreeMap<>();

            for (int i=0; i<taskSize; i++) {

                Short taskInit = in.nextShort();
                Short taskEnd = in.nextShort();

                if (checkSchedule(jamie, taskInit, taskEnd)) {
                    lineResult.append("J");

                } else {
                    if (checkSchedule(cameron, taskInit, taskEnd)) {
                        lineResult.append("C");
                    } else {
                        lineResult = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }

            result.append("Case #" + test + ": " + lineResult.toString() + "\n");
        }
        System.out.println(result.toString());
    }

    static boolean checkSchedule(TreeMap<Short, Short> schedule, Short taskInit, Short taskEnd) {

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
        schedule.putIfAbsent(taskInit, taskEnd);
        return true;
    }

}
