import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        short testCases = scanner.nextShort();
        StringBuilder finalResult = new StringBuilder();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            short numberOfTasks = scanner.nextShort();
            StringBuilder caseResult = new StringBuilder();

            HashMap<Short, Short> cameronSchedule = new HashMap<>();
            HashMap<Short, Short> jamieSchedule = new HashMap<>();

            boolean possible = true;

            for (int task = 0; task < numberOfTasks; task++) {

                short taskStart = scanner.nextShort();
                short taskEnd = scanner.nextShort();

                if (isSchedulable(jamieSchedule, taskStart, taskEnd)) {
                    caseResult.append("J");

                } else if (isSchedulable(cameronSchedule, taskStart, taskEnd)) {
                    caseResult.append("C");

                } else {
                    caseResult.setLength(0);
                    caseResult.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            finalResult.append("Case #").append(testCase).append(": ").append(caseResult).append("\n");
        }
        System.out.print(finalResult);
    }

    static boolean isSchedulable(HashMap<Short, Short> schedule, short taskStart, short taskEnd) {
        
        if (schedule.containsKey(taskStart)) {
            return false;
        }

        for (Map.Entry<Short, Short> scheduledTask : schedule.entrySet()) {
            if (taskEnd > scheduledTask.getKey() && taskStart < scheduledTask.getValue()) {
                return false;
            }
        }
        schedule.put(taskStart, taskEnd);
        return true;
    }

}