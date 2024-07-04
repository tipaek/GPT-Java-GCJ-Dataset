import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

    static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        short testCases = scanner.nextShort();
        if (testCases <= 0) {
            return;
        }

        StringBuilder output = new StringBuilder();

        for (int test = 1; test <= testCases; ++test) {
            short taskCount = scanner.nextShort();
            if (taskCount <= 0) {
                return;
            }

            StringBuilder caseResult = new StringBuilder();
            TreeMap<Short, Short> cameronSchedule = new TreeMap<>();
            TreeMap<Short, Short> jamieSchedule = new TreeMap<>();

            boolean possible = true;

            for (int i = 0; i < taskCount; i++) {
                short taskStart = scanner.nextShort();
                short taskEnd = scanner.nextShort();

                if (isSchedulable(jamieSchedule, taskStart, taskEnd)) {
                    caseResult.append("J");
                } else if (isSchedulable(cameronSchedule, taskStart, taskEnd)) {
                    caseResult.append("C");
                } else {
                    caseResult = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            output.append("Case #").append(test).append(": ").append(caseResult).append("\n");
        }
        System.out.print(output.toString());
    }

    static boolean isSchedulable(TreeMap<Short, Short> schedule, short taskStart, short taskEnd) {
        for (Entry<Short, Short> entry : schedule.entrySet()) {
            if (taskEnd > entry.getKey() && taskStart < entry.getValue()) {
                return false;
            }
        }
        schedule.put(taskStart, taskEnd);
        return true;
    }
}