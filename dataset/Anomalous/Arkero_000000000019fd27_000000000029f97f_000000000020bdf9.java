import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        StringBuilder output = new StringBuilder();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int taskCount = scanner.nextInt();
            StringBuilder taskAllocation = new StringBuilder();

            HashMap<Integer, Integer> cameronSchedule = new HashMap<>();
            HashMap<Integer, Integer> jamieSchedule = new HashMap<>();

            boolean possible = true;

            for (int i = 0; i < taskCount; i++) {
                int taskStart = scanner.nextInt();
                int taskEnd = scanner.nextInt();

                if (isSchedulable(cameronSchedule, taskStart, taskEnd)) {
                    taskAllocation.append("C");
                } else if (isSchedulable(jamieSchedule, taskStart, taskEnd)) {
                    taskAllocation.append("J");
                } else {
                    taskAllocation.setLength(0);
                    taskAllocation.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            output.append("Case #").append(testCase).append(": ").append(taskAllocation).append("\n");
        }
        System.out.print(output);
    }

    private static boolean isSchedulable(HashMap<Integer, Integer> schedule, int taskStart, int taskEnd) {
        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            int scheduledStart = entry.getKey();
            int scheduledEnd = entry.getValue();

            if ((taskStart < scheduledEnd && taskStart >= scheduledStart) || 
                (taskEnd > scheduledStart && taskEnd <= scheduledEnd)) {
                return false;
            }
        }
        schedule.put(taskStart, taskEnd);
        return true;
    }
}