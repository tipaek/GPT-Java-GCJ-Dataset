import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<int[]> events = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                events.add(new int[]{scanner.nextInt(), scanner.nextInt(), i});
            }

            Collections.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

            String[] schedule = new String[n];
            List<int[]> cameronSchedule = new ArrayList<>();
            List<int[]> jamieSchedule = new ArrayList<>();
            boolean impossible = false;

            for (int[] event : events) {
                boolean cameronConflict = hasConflict(event, cameronSchedule);
                boolean jamieConflict = hasConflict(event, jamieSchedule);

                if (cameronConflict && jamieConflict) {
                    impossible = true;
                    break;
                }

                if (!cameronConflict) {
                    cameronSchedule.add(event);
                    schedule[event[2]] = "C";
                } else {
                    jamieSchedule.add(event);
                    schedule[event[2]] = "J";
                }
            }

            String result = impossible ? "IMPOSSIBLE" : String.join("", schedule);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static boolean hasConflict(int[] event, List<int[]> schedule) {
        for (int[] scheduledEvent : schedule) {
            if (overlaps(event, scheduledEvent)) {
                return true;
            }
        }
        return false;
    }

    private static boolean overlaps(int[] event1, int[] event2) {
        return !(event1[1] <= event2[0] || event1[0] >= event2[1]);
    }
}