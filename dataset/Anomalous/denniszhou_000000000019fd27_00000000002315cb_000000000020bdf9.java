import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(in.nextLine());
            int[][] intervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                String[] input = in.nextLine().split(" ");
                intervals[j][0] = Integer.parseInt(input[0]);
                intervals[j][1] = Integer.parseInt(input[1]);
            }

            boolean isPossible = true;
            int[] timeSlots = new int[1441];

            for (int[] interval : intervals) {
                for (int time = interval[0] + 1; time <= interval[1]; time++) {
                    timeSlots[time]++;
                    if (timeSlots[time] > 2) {
                        isPossible = false;
                        break;
                    }
                }
                if (!isPossible) break;
            }

            if (isPossible) {
                StringBuilder schedule = new StringBuilder();
                Map<Integer, Integer> assignedIntervals = new HashMap<>();

                for (int[] interval : intervals) {
                    boolean isOverlapping = false;

                    for (Map.Entry<Integer, Integer> entry : assignedIntervals.entrySet()) {
                        if ((interval[0] <= entry.getKey() && interval[1] > entry.getKey()) ||
                            (interval[0] < entry.getValue() && interval[1] >= entry.getValue())) {
                            schedule.append("J");
                            isOverlapping = true;
                            break;
                        }
                    }

                    if (!isOverlapping) {
                        assignedIntervals.put(interval[0], interval[1]);
                        schedule.append("C");
                    }
                }

                System.out.println("Case #" + i + ": " + schedule.toString());
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}