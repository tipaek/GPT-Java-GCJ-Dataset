import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        short numberOfCases = scanner.nextShort();
        StringBuilder overallResult = new StringBuilder();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            short numberOfTasks = scanner.nextShort();
            StringBuilder caseResult = new StringBuilder();

            HashMap<Short, Short> cameronSchedule = new HashMap<>();
            HashMap<Short, Short> jamieSchedule = new HashMap<>();

            boolean isPossible = true;

            for (int i = 0; i < numberOfTasks; i++) {
                short taskStart = scanner.nextShort();
                short taskEnd = scanner.nextShort();

                if (canScheduleTask(jamieSchedule, taskStart, taskEnd)) {
                    caseResult.append("J");
                } else if (canScheduleTask(cameronSchedule, taskStart, taskEnd)) {
                    caseResult.append("C");
                } else {
                    caseResult.setLength(0);
                    caseResult.append("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            overallResult.append("Case #").append(caseNumber).append(": ").append(caseResult).append("\n");
        }

        System.out.print(overallResult);
    }

    static boolean canScheduleTask(HashMap<Short, Short> schedule, short taskStart, short taskEnd) {
        for (Map.Entry<Short, Short> entry : schedule.entrySet()) {
            short scheduledStart = entry.getKey();
            short scheduledEnd = entry.getValue();
            if (taskStart < scheduledEnd && taskEnd > scheduledStart) {
                return false;
            }
        }
        schedule.put(taskStart, taskEnd);
        return true;
    }
}