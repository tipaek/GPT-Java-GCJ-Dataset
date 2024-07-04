import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Solution {
    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" + "start=" + start + ", end=" + end + '}';
        }
    }

    private static final char[] PERSON = {'C', 'J'};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().trim().split("\\s+");
                intervals[i] = new Interval(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            }

            System.out.print(String.format("Case #%d: ", t));
            Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));

            Stack<Interval>[] activeIntervals = new Stack[2];
            activeIntervals[0] = new Stack<>();
            activeIntervals[1] = new Stack<>();

            StringBuilder result = new StringBuilder();
            int currentPerson = 0;

            for (Interval interval : intervals) {
                if (canAssignInterval(activeIntervals[currentPerson], interval)) {
                    activeIntervals[currentPerson].push(interval);
                    result.append(PERSON[currentPerson]);
                } else if (canAssignInterval(activeIntervals[otherPerson(currentPerson)], interval)) {
                    currentPerson = otherPerson(currentPerson);
                    activeIntervals[currentPerson].push(interval);
                    result.append(PERSON[currentPerson]);
                } else {
                    System.out.println("IMPOSSIBLE");
                    currentPerson = -1;
                    break;
                }
            }

            if (currentPerson != -1) {
                System.out.println(result.toString());
            }
        }
    }

    private static boolean canAssignInterval(Stack<Interval> activeIntervals, Interval interval) {
        return activeIntervals.isEmpty() || activeIntervals.peek().end <= interval.start;
    }

    private static int otherPerson(int currentPerson) {
        return currentPerson ^ 1;
    }
}