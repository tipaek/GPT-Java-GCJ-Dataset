import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        StringBuilder result = new StringBuilder();

        for (int test = 1; test <= T; ++test) {
            int taskSize = in.nextInt();
            StringBuilder lineResult = new StringBuilder();

            HashMap<Integer, Integer> cameron = new HashMap<>();
            HashMap<Integer, Integer> jamie = new HashMap<>();

            for (int i=0; i<taskSize; i++) {

                int taskInit = in.nextInt();
                int taskEnd = in.nextInt();

                if (checkSchedule(cameron, taskInit, taskEnd)) {
                    lineResult.append("C");

                } else {
                    if (checkSchedule(jamie, taskInit, taskEnd)) {
                        lineResult.append("J");
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

    static boolean checkSchedule(HashMap<Integer, Integer> schedule, int taskInit, int taskEnd) {

        if (schedule.containsKey(taskInit)) {
            return false;
        }

        if (schedule.containsValue(taskEnd)) {
            return false;
        }

        for (Entry<Integer, Integer> scheduledTask : schedule.entrySet()) {

            if ((taskEnd > scheduledTask.getKey() && taskEnd <= scheduledTask.getValue())
                || (taskInit >= scheduledTask.getKey() && taskInit < scheduledTask.getValue())) {
                return false;
            }
        }
        schedule.put(taskInit, taskEnd);
        return true;
    }

}
