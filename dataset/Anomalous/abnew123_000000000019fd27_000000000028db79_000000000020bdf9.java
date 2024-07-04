import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            List<int[]> cameronSchedule = new ArrayList<>();
            List<int[]> jamieSchedule = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();

            boolean isImpossible = false;

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                int[] event = new int[]{start, end};

                boolean cameronConflict = hasConflict(event, cameronSchedule);
                boolean jamieConflict = hasConflict(event, jamieSchedule);

                if (cameronConflict && jamieConflict) {
                    isImpossible = true;
                    break;
                }

                if (!cameronConflict) {
                    cameronSchedule.add(event);
                    schedule.append("C");
                } else {
                    jamieSchedule.add(event);
                    schedule.append("J");
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + schedule.toString());
            }
        }
    }

    private static boolean hasConflict(int[] event, List<int[]> schedule) {
        for (int[] existingEvent : schedule) {
            if (isOverlap(existingEvent, event)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOverlap(int[] event1, int[] event2) {
        return !(event1[0] >= event2[1] || event1[1] <= event2[0]);
    }
}