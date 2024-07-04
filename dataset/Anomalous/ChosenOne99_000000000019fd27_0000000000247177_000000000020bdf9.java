import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numberOfActivities = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            Map<Integer, Integer> cameronSchedule = new HashMap<>();
            Map<Integer, Integer> jamieSchedule = new HashMap<>();

            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean assigned = false;

                if (canAssignActivity(start, end, cameronSchedule)) {
                    cameronSchedule.put(start, end);
                    schedule.append("C");
                    assigned = true;
                } else if (canAssignActivity(start, end, jamieSchedule)) {
                    jamieSchedule.put(start, end);
                    schedule.append("J");
                    assigned = true;
                }

                if (!assigned) {
                    isImpossible = true;
                }
            }

            if (isImpossible) {
                schedule = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + caseNumber + ": " + schedule);
        }
    }

    private static boolean canAssignActivity(int start, int end, Map<Integer, Integer> schedule) {
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