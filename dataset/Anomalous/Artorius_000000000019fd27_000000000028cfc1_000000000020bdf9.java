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
            boolean impossible = false;
            for (int i = 0; i < activityCount; i++) {
                int startTime = input.nextInt();
                int endTime = input.nextInt();

                if (busyC.pickUpTask(startTime, endTime)) {
                    solution.append('C');
                } else if (busyJ.pickUpTask(startTime, endTime)) {
                    solution.append('J');
                } else {
                    impossible = true;
                    System.out.println("IMPOSSIBLE");
                    break;
                }
            }

            if (!impossible) {
                System.out.println(solution);
            }
        }
    }

    private static class Intervals {
        private Map<Integer, Integer> busyIntervals;

        Intervals() {
            busyIntervals = new HashMap<>();
        }

        boolean pickUpTask(int startTime, int endTime) {
            boolean isFree = busyIntervals.entrySet().stream()
                    .noneMatch(entry -> overlaps(startTime, endTime, entry.getKey(), entry.getValue()));

            if (isFree) {
                busyIntervals.put(startTime, endTime);
            }

            return isFree;
        }

        private boolean overlaps(int s1, int e1, int s2, int e2) {
            return !(e1 <= s2 || s1 >= e2);
        }
    }
}