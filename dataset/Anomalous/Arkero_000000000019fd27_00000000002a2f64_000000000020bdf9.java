import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        short numberOfTests = scanner.nextShort();
        StringBuilder overallResult = new StringBuilder();

        for (int testCase = 1; testCase <= numberOfTests; ++testCase) {
            short numberOfTasks = scanner.nextShort();
            StringBuilder currentResult = new StringBuilder();

            HashMap<Short, Short> cameronSchedule = new HashMap<>();
            HashMap<Short, Short> jamieSchedule = new HashMap<>();

            boolean isPossible = true;
            for (int i = 0; i < numberOfTasks; i++) {
                short taskStart = scanner.nextShort();
                short taskEnd = scanner.nextShort();

                if (isTaskSchedulable(jamieSchedule, taskStart, taskEnd)) {
                    currentResult.append("J");
                } else if (isTaskSchedulable(cameronSchedule, taskStart, taskEnd)) {
                    currentResult.append("C");
                } else {
                    currentResult.setLength(0); // Clear the current result
                    currentResult.append("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            overallResult.append("Case #").append(testCase).append(": ").append(currentResult).append("\n");
        }
        System.out.println(overallResult);
    }

    static boolean isTaskSchedulable(HashMap<Short, Short> schedule, short taskStart, short taskEnd) {
        for (Map.Entry<Short, Short> entry : schedule.entrySet()) {
            if (taskEnd > entry.getKey() && taskStart < entry.getValue()) {
                return false;
            }
        }
        schedule.put(taskStart, taskEnd);
        return true;
    }
}