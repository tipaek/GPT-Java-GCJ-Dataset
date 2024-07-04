import java.util.*;
import java.io.*;

public class Solution {

    public static boolean inRange(Map<Integer, Integer> map, int[] timeSlot) {
        if (map.isEmpty()) {
            return true;
        } else {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int start = entry.getKey();
                int end = entry.getValue();
                if (!(end <= timeSlot[0] || start >= timeSlot[1])) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = input.nextInt();
        for (int t = 1; t <= testCase; t++) {
            StringBuilder result = new StringBuilder();
            Map<Integer, Integer> scheduleJ = new HashMap<>();
            Map<Integer, Integer> scheduleC = new HashMap<>();
            int N = input.nextInt();
            boolean possible = true;

            for (int n = 0; n < N; n++) {
                int start = input.nextInt();
                int end = input.nextInt();
                int[] timeSlot = {start, end};

                if (inRange(scheduleJ, timeSlot)) {
                    scheduleJ.put(start, end);
                    result.append("J");
                } else if (inRange(scheduleC, timeSlot)) {
                    scheduleC.put(start, end);
                    result.append("C");
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + result.toString());
            }
        }
    }
}