import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        short testCases = scanner.nextShort();
        StringBuilder finalResult = new StringBuilder();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            short numberOfTasks = scanner.nextShort();
            StringBuilder currentResult = new StringBuilder();

            HashMap<Short, Short> cameronSchedule = new HashMap<>();
            HashMap<Short, Short> jamieSchedule = new HashMap<>();

            boolean possible = true;

            for (int i = 0; i < numberOfTasks; i++) {
                short taskStart = scanner.nextShort();
                short taskEnd = scanner.nextShort();

                if (canScheduleTask(jamieSchedule, taskStart, taskEnd)) {
                    currentResult.append("J");
                } else if (canScheduleTask(cameronSchedule, taskStart, taskEnd)) {
                    currentResult.append("C");
                } else {
                    currentResult.setLength(0);
                    currentResult.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            finalResult.append("Case #").append(testCase).append(": ").append(currentResult).append("\n");
        }
        System.out.print(finalResult);
    }

    private static boolean canScheduleTask(HashMap<Short, Short> schedule, short taskStart, short taskEnd) {
        for (Map.Entry<Short, Short> entry : schedule.entrySet()) {
            if (taskEnd > entry.getKey() && taskStart < entry.getValue()) {
                return false;
            }
        }
        schedule.put(taskStart, taskEnd);
        return true;
    }
}