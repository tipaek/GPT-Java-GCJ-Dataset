import java.util.*;
import java.io.*;

public class Solution {

    static class TimePeriod implements Comparable<TimePeriod> {
        private final int startTime;
        private final int endTime;
        private final int index;

        public TimePeriod(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(TimePeriod other) {
            if (this.startTime == other.startTime) {
                return Integer.compare(this.endTime, other.endTime);
            }
            return Integer.compare(this.startTime, other.startTime);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int ti = 1; ti <= t; ti++) {
            int n = scanner.nextInt();
            List<TimePeriod> timePeriods = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                timePeriods.add(new TimePeriod(startTime, endTime, i));
            }

            Collections.sort(timePeriods);

            String[] assignments = new String[n];
            int endTimeC = 0;
            int endTimeJ = 0;
            boolean possible = true;

            for (TimePeriod timePeriod : timePeriods) {
                int startTime = timePeriod.getStartTime();
                int endTime = timePeriod.getEndTime();
                int index = timePeriod.getIndex();

                if (endTimeC <= startTime) {
                    endTimeC = endTime;
                    assignments[index] = "C";
                } else if (endTimeJ <= startTime) {
                    endTimeJ = endTime;
                    assignments[index] = "J";
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? String.join("", assignments) : "IMPOSSIBLE";
            System.out.println("Case #" + ti + ": " + result);
        }
    }
}