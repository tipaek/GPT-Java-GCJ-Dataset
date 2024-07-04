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
            StringBuilder caseResult = new StringBuilder();

            HashMap<Integer, Integer> cameronSchedule = new HashMap<>();
            HashMap<Integer, Integer> jamieSchedule = new HashMap<>();

            boolean possible = true;

            for (int i = 0; i < taskCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isSchedulable(cameronSchedule, start, end)) {
                    caseResult.append("C");
                } else if (isSchedulable(jamieSchedule, start, end)) {
                    caseResult.append("J");
                } else {
                    caseResult.setLength(0);
                    caseResult.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            output.append("Case #").append(testCase).append(": ").append(caseResult).append("\n");
        }

        System.out.print(output);
    }

    private static boolean isSchedulable(HashMap<Integer, Integer> schedule, int start, int end) {
        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            int scheduledStart = entry.getKey();
            int scheduledEnd = entry.getValue();
            if ((start < scheduledEnd && end > scheduledStart) || (start >= scheduledStart && start < scheduledEnd)) {
                return false;
            }
        }
        schedule.put(start, end);
        return true;
    }
}