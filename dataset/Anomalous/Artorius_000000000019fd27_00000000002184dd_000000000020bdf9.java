import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activityCount = input.nextInt();
            Intervals busyC = new Intervals();
            Intervals busyJ = new Intervals();
            StringBuilder solution = new StringBuilder(activityCount);

            System.out.print("Case #" + t + ": ");
            boolean possible = true;

            for (int i = 0; i < activityCount; i++) {
                int startTime = input.nextInt();
                int endTime = input.nextInt();

                if (busyC.canSchedule(startTime, endTime)) {
                    solution.append('C');
                } else if (busyJ.canSchedule(startTime, endTime)) {
                    solution.append('J');
                } else {
                    possible = false;
                    System.out.println("IMPOSSIBLE");
                    break;
                }
            }

            if (possible) {
                System.out.println(solution);
            }
        }
    }

    private static class Intervals {
        private Map<Integer, Integer> busyIntervals;

        Intervals() {
            busyIntervals = new HashMap<>();
        }

        boolean canSchedule(int startTime, int endTime) {
            for (Map.Entry<Integer, Integer> entry : busyIntervals.entrySet()) {
                if (overlaps(startTime, endTime, entry.getKey(), entry.getValue())) {
                    return false;
                }
            }
            busyIntervals.put(startTime, endTime);
            return true;
        }

        private boolean overlaps(int s1, int e1, int s2, int e2) {
            return !(e1 <= s2 || s1 >= e2);
        }
    }
}