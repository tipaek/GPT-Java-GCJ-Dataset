import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static class TimeInterval implements Comparable<TimeInterval> {
        int start;
        int end;

        public TimeInterval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(TimeInterval other) {
            return Integer.compare(this.end, other.end);
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(reader.readLine());

            for (int testCase = 1; testCase <= testCases; testCase++) {
                int timeIntervalsCount = Integer.parseInt(reader.readLine());
                List<TimeInterval> timeIntervals = new ArrayList<>();

                for (int i = 0; i < timeIntervalsCount; i++) {
                    String[] times = reader.readLine().split(" ");
                    int start = Integer.parseInt(times[0]);
                    int end = Integer.parseInt(times[1]);
                    timeIntervals.add(new TimeInterval(start, end));
                }

                processTestCase(testCase, timeIntervals);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processTestCase(int testCaseNumber, List<TimeInterval> timeIntervals) {
        Collections.sort(timeIntervals);

        StringBuilder result = new StringBuilder();
        int endC = -1, endJ = -1;

        for (TimeInterval interval : timeIntervals) {
            if (interval.start >= endC) {
                result.append("C");
                endC = interval.end;
            } else if (interval.start >= endJ) {
                result.append("J");
                endJ = interval.end;
            } else {
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + result.toString());
    }
}