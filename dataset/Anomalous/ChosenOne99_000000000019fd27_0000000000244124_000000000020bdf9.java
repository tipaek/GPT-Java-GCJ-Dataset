import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activityCount = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            Map<Integer, Integer> jSchedule = new HashMap<>();
            Map<Integer, Integer> cSchedule = new HashMap<>();

            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean assigned = false;

                if (canAssign(jSchedule, start, end)) {
                    jSchedule.put(start, end);
                    result.append("J");
                    assigned = true;
                } else if (canAssign(cSchedule, start, end)) {
                    cSchedule.put(start, end);
                    result.append("C");
                    assigned = true;
                }

                if (!assigned) {
                    isImpossible = true;
                }
            }

            if (isImpossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static boolean canAssign(Map<Integer, Integer> schedule, int start, int end) {
        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            int scheduledStart = entry.getKey();
            int scheduledEnd = entry.getValue();
            if ((start < scheduledEnd && end > scheduledStart) || start == scheduledStart) {
                return false;
            }
        }
        return true;
    }
}