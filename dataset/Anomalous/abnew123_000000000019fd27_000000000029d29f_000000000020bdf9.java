import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            List<int[]> events = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events.add(new int[]{start, end, i});
            }

            Collections.sort(events, Comparator.comparingInt(event -> event[0]));

            List<int[]> cameronSchedule = new ArrayList<>();
            List<int[]> jamieSchedule = new ArrayList<>();
            String[] assignments = new String[n];
            boolean impossible = false;

            for (int[] event : events) {
                boolean cameronAvailable = isAvailable(event, cameronSchedule);
                boolean jamieAvailable = isAvailable(event, jamieSchedule);

                if (cameronAvailable && jamieAvailable) {
                    impossible = true;
                    break;
                } else if (cameronAvailable) {
                    jamieSchedule.add(event);
                    assignments[event[2]] = "J";
                } else {
                    cameronSchedule.add(event);
                    assignments[event[2]] = "C";
                }
            }

            String result = impossible ? "IMPOSSIBLE" : String.join("", assignments);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static boolean isAvailable(int[] event, List<int[]> schedule) {
        for (int[] scheduledEvent : schedule) {
            if (overlaps(scheduledEvent, event)) {
                return true;
            }
        }
        return false;
    }

    private static boolean overlaps(int[] event1, int[] event2) {
        return event1[0] < event2[1] && event1[1] > event2[0];
    }
}