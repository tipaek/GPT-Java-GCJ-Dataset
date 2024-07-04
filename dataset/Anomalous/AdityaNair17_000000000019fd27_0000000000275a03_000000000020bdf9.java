import java.util.*;
import java.io.*;

public class Solution {

    public static boolean isInRange(Map<Integer, Integer> schedule, int[] timeSlot) {
        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            int start = entry.getKey();
            int end = entry.getValue();
            if (!(end <= timeSlot[0] || start >= timeSlot[1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = input.nextInt();

        for (int t = 1; t <= testCaseCount; t++) {
            StringBuilder result = new StringBuilder();
            Map<Integer, Integer> scheduleJ = new HashMap<>();
            Map<Integer, Integer> scheduleC = new HashMap<>();
            int N = input.nextInt();
            boolean isPossible = true;

            for (int n = 0; n < N; n++) {
                int start = input.nextInt();
                int end = input.nextInt();
                int[] timeSlot = {start, end};

                if (isInRange(scheduleJ, timeSlot)) {
                    scheduleJ.put(start, end);
                    result.append("J");
                } else if (isInRange(scheduleC, timeSlot)) {
                    scheduleC.put(start, end);
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}