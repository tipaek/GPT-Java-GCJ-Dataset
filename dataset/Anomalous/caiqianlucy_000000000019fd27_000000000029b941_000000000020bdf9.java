import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());

        for (int k = 1; k <= t; k++) {
            int n = Integer.parseInt(scanner.nextLine());
            List<int[]> cSchedule = new ArrayList<>();
            List<int[]> jSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split("\\s");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                int[] timeSlot = {start, end};

                if (canInsert(cSchedule, timeSlot)) {
                    result.append('C');
                } else if (canInsert(jSchedule, timeSlot)) {
                    result.append('J');
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + k + ": " + result.toString());
        }
    }

    public static boolean canInsert(List<int[]> schedule, int[] timeSlot) {
        if (schedule.isEmpty()) {
            schedule.add(timeSlot);
            return true;
        }

        int start = timeSlot[0];
        int end = timeSlot[1];

        for (int i = 0; i < schedule.size(); i++) {
            int[] existingSlot = schedule.get(i);
            if (start < existingSlot[0]) {
                if (end <= existingSlot[0]) {
                    schedule.add(i, timeSlot);
                    return true;
                } else {
                    return false;
                }
            } else if (start < existingSlot[1]) {
                return false;
            }
        }

        int[] lastSlot = schedule.get(schedule.size() - 1);
        if (lastSlot[1] <= start) {
            schedule.add(timeSlot);
            return true;
        }

        return false;
    }
}