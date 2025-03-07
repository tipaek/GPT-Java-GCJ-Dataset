import java.util.*;

public class Solution {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final int testCases = input.nextInt();

        for (int t = 1; t <= testCases; t++) {
            final int activityCount = input.nextInt();

            final Intervals busyC = new Intervals();
            final Intervals busyJ = new Intervals();
            final StringBuilder solution = new StringBuilder(activityCount);

            System.out.print(String.format("Case #%d: ", t));
            for(int i = 0; i < activityCount; ++i) {
                final int startTime = input.nextInt();
                final int endTime = input.nextInt();

                if(busyC.pickUpTask(startTime, endTime)) {
                    solution.append('C');
                }
                else if(busyJ.pickUpTask(startTime, endTime)) {
                    solution.append('J');
                }
                else {
                    System.out.println("IMPOSSIBLE");
                    break;
                }
            }

            if(solution.length() == activityCount)
                System.out.println(solution);
        }
    }

    private static class Intervals {
        //Exclusive interval of when someone is busy
        private Map<Integer, Integer> busyIntervals;

        Intervals() {
            busyIntervals = new HashMap<>();
        }

        boolean pickUpTask(final int startTime, final int endTime) {
            boolean isFree = busyIntervals.entrySet().stream()
                    .noneMatch(e -> overlaps(startTime, endTime, e.getKey(), e.getValue()));

            if(isFree) {
                busyIntervals.put(startTime, endTime);
            }

            return isFree;
        }

        private static boolean overlaps(final int s1, final int e1, final int s2, final int e2) {
            final boolean completelyBefore = e1 <= s2;
            final boolean completelyAfter = s1 >= e2;

            return !completelyBefore && !completelyAfter;
        }
    }
}