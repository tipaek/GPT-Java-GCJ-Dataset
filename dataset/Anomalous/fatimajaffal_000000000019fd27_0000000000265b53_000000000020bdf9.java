import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder resultBuilder = new StringBuilder();
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            Map<Integer, Integer> cSchedule = new HashMap<>();
            Map<Integer, Integer> jSchedule = new HashMap<>();
            StringBuilder scheduleResult = new StringBuilder();

            for (int activityIndex = 0; activityIndex < n; activityIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (activityIndex == 0) {
                    cSchedule.put(start, end);
                    scheduleResult.append("C");
                } else {
                    boolean canAssignToC = isAssignable(cSchedule, start, end);
                    if (canAssignToC) {
                        scheduleResult.append("C");
                        cSchedule.put(start, end);
                    } else {
                        boolean canAssignToJ = isAssignable(jSchedule, start, end);
                        if (canAssignToJ) {
                            scheduleResult.append("J");
                            jSchedule.put(start, end);
                        } else {
                            scheduleResult = new StringBuilder("IMPOSSIBLE");
                            break;
                        }
                    }
                }
            }
            resultBuilder.append("Case #").append(caseNumber).append(": ").append(scheduleResult).append("\n");
        }
        System.out.print(resultBuilder);
    }

    private static boolean isAssignable(Map<Integer, Integer> schedule, int start, int end) {
        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            int scheduledStart = entry.getKey();
            int scheduledEnd = entry.getValue();
            if (!(end <= scheduledStart || start >= scheduledEnd)) {
                return false;
            }
        }
        return true;
    }
}