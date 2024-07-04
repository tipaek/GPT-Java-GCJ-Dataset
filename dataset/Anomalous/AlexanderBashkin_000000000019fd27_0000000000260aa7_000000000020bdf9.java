import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().execute();
    }

    private void execute() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            Interval[] intervals = new Interval[n];
            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(reader.readLine(), i);
            }
            processTestCase(t, n, intervals);
        }
    }

    private void processTestCase(int testCaseNumber, int n, Interval[] intervals) {
        Arrays.sort(intervals);
        int jEnd = -1, cEnd = -1;
        boolean isImpossible = false;
        char[] assignment = new char[n];
        for (int i = 0; i < n; i++) {
            if (jEnd <= intervals[i].start) {
                assignment[intervals[i].index] = 'J';
                jEnd = intervals[i].end;
            } else if (cEnd <= intervals[i].start) {
                assignment[intervals[i].index] = 'C';
                cEnd = intervals[i].end;
            } else {
                isImpossible = true;
                break;
            }
        }
        System.out.printf("Case #%d: %s\n", testCaseNumber, isImpossible ? "IMPOSSIBLE" : new String(assignment));
    }

    private static class Interval implements Comparable<Interval> {
        final int start, end, index;

        Interval(String input, int index) {
            StringTokenizer tokenizer = new StringTokenizer(input);
            this.start = Integer.parseInt(tokenizer.nextToken());
            this.end = Integer.parseInt(tokenizer.nextToken());
            this.index = index;
        }

        @Override
        public int compareTo(@NotNull Interval other) {
            int startComparison = Integer.compare(this.start, other.start);
            return startComparison != 0 ? startComparison : Integer.compare(this.end, other.end);
        }
    }
}