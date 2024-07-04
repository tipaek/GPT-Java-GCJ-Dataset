import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int T = 1; T <= t; T++) {
            int n = Integer.parseInt(br.readLine());
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] tokens = br.readLine().split(" ");
                int start = Integer.parseInt(tokens[0]);
                int end = Integer.parseInt(tokens[1]);
                intervals.add(new Interval(start, end));
            }

            solve(T, intervals);
        }
    }

    public static class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval other) {
            if (this.start != other.start) {
                return this.start - other.start;
            }
            return this.end - other.end;
        }

        @Override
        public String toString() {
            return start + " " + end;
        }
    }

    private static void solve(int caseNumber, List<Interval> intervals) {
        Map<Interval, Character> assignment = new HashMap<>();
        List<Interval> sortedIntervals = new ArrayList<>(intervals);
        Collections.sort(sortedIntervals);

        int cEnd = 0;
        int jEnd = 0;

        for (Interval interval : sortedIntervals) {
            if (interval.start >= cEnd) {
                assignment.put(interval, 'C');
                cEnd = interval.end;
            } else if (interval.start >= jEnd) {
                assignment.put(interval, 'J');
                jEnd = interval.end;
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        StringBuilder result = new StringBuilder();
        for (Interval interval : intervals) {
            result.append(assignment.get(interval));
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }
}