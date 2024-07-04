import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activityCount = input.nextInt();

            Schedule busyC = new Schedule();
            Schedule busyJ = new Schedule();
            StringBuilder solution = new StringBuilder(activityCount);

            System.out.print("Case #" + t + ": ");
            boolean possible = true;
            for (int i = 0; i < activityCount; i++) {
                int startTime = input.nextInt();
                int endTime = input.nextInt();

                if (busyC.assignTask(startTime, endTime)) {
                    solution.append('C');
                } else if (busyJ.assignTask(startTime, endTime)) {
                    solution.append('J');
                } else {
                    System.out.println("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println(solution);
            }
        }
    }

    private static class Schedule {
        private Map<Integer, Integer> intervals;

        Schedule() {
            intervals = new HashMap<>();
        }

        boolean assignTask(int startTime, int endTime) {
            for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
                int start = entry.getKey();
                int end = entry.getValue();
                if ((startTime >= start && startTime < end) ||
                    (endTime > start && endTime <= end) ||
                    (startTime < start && endTime > end)) {
                    return false;
                }
            }
            intervals.put(startTime, endTime);
            return true;
        }
    }
}