import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numberOfActivities = scanner.nextInt();
            StringBuilder answer = new StringBuilder();
            Map<Integer, Integer> jMap = new HashMap<>();
            Map<Integer, Integer> cMap = new HashMap<>();
            boolean impossible = false;

            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean assigned = false;

                if (isAvailable(jMap, start, end)) {
                    jMap.put(start, end);
                    answer.append("J");
                    assigned = true;
                } else if (isAvailable(cMap, start, end)) {
                    cMap.put(start, end);
                    answer.append("C");
                    assigned = true;
                }

                if (!assigned) {
                    answer = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + answer);
        }
    }

    private static boolean isAvailable(Map<Integer, Integer> schedule, int start, int end) {
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