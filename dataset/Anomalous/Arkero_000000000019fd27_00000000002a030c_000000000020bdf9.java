import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        StringBuilder finalResult = new StringBuilder();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int numberOfTasks = scanner.nextInt();
            StringBuilder currentResult = new StringBuilder();

            HashMap<Integer, Integer> cameronSchedule = new HashMap<>();
            HashMap<Integer, Integer> jamieSchedule = new HashMap<>();

            boolean isPossible = true;

            for (int i = 0; i < numberOfTasks; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (canScheduleTask(cameronSchedule, start, end)) {
                    currentResult.append("C");
                } else if (canScheduleTask(jamieSchedule, start, end)) {
                    currentResult.append("J");
                } else {
                    currentResult.setLength(0);
                    currentResult.append("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                finalResult.append("Case #").append(testCase).append(": ").append(currentResult).append("\n");
            } else {
                finalResult.append("Case #").append(testCase).append(": IMPOSSIBLE\n");
            }
        }
        System.out.print(finalResult);
    }

    static boolean canScheduleTask(HashMap<Integer, Integer> schedule, int start, int end) {
        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            int scheduledStart = entry.getKey();
            int scheduledEnd = entry.getValue();
            if ((start < scheduledEnd && end > scheduledStart)) {
                return false;
            }
        }
        schedule.put(start, end);
        return true;
    }
}