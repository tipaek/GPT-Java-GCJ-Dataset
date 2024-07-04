import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int T = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int test = 1; test <= T; ++test) {
            int taskSize = scanner.nextInt();
            StringBuilder lineResult = new StringBuilder();

            HashMap<Integer, Integer> cameron = new HashMap<>();
            HashMap<Integer, Integer> jamie = new HashMap<>();

            boolean possible = true;

            for (int i = 0; i < taskSize; i++) {
                int taskStart = scanner.nextInt();
                int taskEnd = scanner.nextInt();

                if (isSchedulable(jamie, taskStart, taskEnd)) {
                    lineResult.append("J");
                } else if (isSchedulable(cameron, taskStart, taskEnd)) {
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

    static boolean isSchedulable(HashMap<Integer, Integer> schedule, int taskStart, int taskEnd) {
        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            if (taskEnd > entry.getKey() && taskStart < entry.getValue()) {
                return false;
            }
        }
        schedule.put(taskStart, taskEnd);
        return true;
    }
}