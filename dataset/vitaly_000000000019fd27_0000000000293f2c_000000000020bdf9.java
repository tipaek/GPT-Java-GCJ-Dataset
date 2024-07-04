import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    private static final int JAMMIE = 1;
    private static final int CAMERON = 2;

    private static final int MINUTES_PER_DAY = 1441;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int test = 1; test <= t; test++) {
            int n = in.nextInt();

            List<TimeRange> timeRangeList = new ArrayList<>(n);
            List<List<Integer>> busyMinutes = new ArrayList<>(MINUTES_PER_DAY);
            for (int i = 0; i < n; i++) {
                timeRangeList.add(new TimeRange(in.nextInt(), in.nextInt()));
            }

            for (int i = 0; i < MINUTES_PER_DAY; i++) {
                busyMinutes.add(new ArrayList<>());
            }

            for (int rangeIndex = 0; rangeIndex < n; rangeIndex++) {
                TimeRange currentRange = timeRangeList.get(rangeIndex);
                int currentRangeStart = currentRange.start;
                int currentRangeEnd = currentRange.end;
                for (int time = currentRangeStart; time < currentRangeEnd; time++) {
                    busyMinutes.get(time).add(rangeIndex);
                }
            }

            boolean possible = true;
            for (List<Integer> activities : busyMinutes) {
                if (activities.size() > 2) {
                    possible = false;
                    break;
                }
            }

            String result;
            if (possible) {
                List<Integer> responsibilities = new ArrayList<>(n);
                List<Boolean> responsibilityAssigned = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    responsibilities.add(0);
                    responsibilityAssigned.add(false);
                }

                for (List<Integer> activities : busyMinutes) {
                    if (activities.size() == 2) {
                        int firstActivity = activities.get(0);
                        int secondActivity = activities.get(1);

                        if (!responsibilityAssigned.get(firstActivity)) {
                            responsibilities.set(firstActivity, responsibilities.get(secondActivity) == JAMMIE ? CAMERON : JAMMIE);
                            responsibilityAssigned.set(firstActivity, true);
                        }

                        if (!responsibilityAssigned.get(secondActivity)) {
                            responsibilities.set(secondActivity, responsibilities.get(firstActivity) == JAMMIE ? CAMERON : JAMMIE);
                            responsibilityAssigned.set(secondActivity, true);
                        }

                    }
                }

                result = responsibilities.stream().map((owner) -> owner == JAMMIE ? "J" : "C").collect(Collectors.joining());
            } else {
                result = "IMPOSSIBLE";
            }
            System.out.println(String.format("Case #%d: %s", test, result));
        }
    }

    private static final class TimeRange {
        private final int start;
        private final int end;

        public TimeRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "[" + start + "-" + end + "]";
        }
    }
}
