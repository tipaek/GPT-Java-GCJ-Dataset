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
            String result = "";
            int n = scanner.nextInt();
            List<int[]> cameronSchedule = new ArrayList<>();
            List<int[]> jamieSchedule = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                int[] event = {scanner.nextInt(), scanner.nextInt()};
                boolean cameronConflict = hasConflict(event, cameronSchedule);
                boolean jamieConflict = hasConflict(event, jamieSchedule);

                if (cameronConflict && jamieConflict) {
                    result = "IMPOSSIBLE";
                    break;
                }
                if (!cameronConflict) {
                    cameronSchedule.add(event);
                    result += "C";
                } else {
                    jamieSchedule.add(event);
                    result += "J";
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static boolean hasConflict(int[] event, List<int[]> schedule) {
        for (int[] scheduledEvent : schedule) {
            if (isOverlapping(scheduledEvent, event)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOverlapping(int[] event1, int[] event2) {
        return !(event1[1] <= event2[0] || event1[0] >= event2[1]);
    }
}