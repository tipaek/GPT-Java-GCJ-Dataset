import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static class Interval implements Comparable<Interval> {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval other) {
            // Sort by end, then by start
            if (end == other.end) {
                return Integer.compare(start, other.start);
            }

            return Integer.compare(end, other.end);
        }
    }

    public static void main(String[] args) throws IOException {
        // Scheduling problem, two people, no overlaps allowed

        // Find any schedule that does not require the same person to cover overlapping activites or say that it is impossible

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numTestCases = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer;

        for (int x = 1; x <= numTestCases; x++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            Interval[] unsortedIntervals = new Interval[n];
            Interval[] sortedIntervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int start = Integer.parseInt(stringTokenizer.nextToken());
                int end = Integer.parseInt(stringTokenizer.nextToken());

                unsortedIntervals[i] = new Interval(start, end);
                sortedIntervals[i] = new Interval(start, end);
            }


            Arrays.sort(sortedIntervals); // Now sorted by end

            Map<Integer, Integer> map = new TreeMap<>();
            // Create map from sorted to base
            for (int i = 0; i < n; i++) {
                // Find index in sorted
                int newIndex = Arrays.binarySearch(sortedIntervals, unsortedIntervals[i]);
                map.put(newIndex, i);
            }

            char[] res = new char[n];
            int cEnd = 0;
            int jEnd = 0;
            boolean skip = false;
            for (int i = 0; i < n; i++) {
                if (sortedIntervals[i].start >= cEnd) {
                    cEnd = sortedIntervals[i].end;
                    // Add this as a c to res
                    res[map.get(i)] = 'C';
                } else if (sortedIntervals[i].start >= jEnd) {
                    jEnd = sortedIntervals[i].end;
                    res[map.get(i)] = 'J';
                } else {
                    // Impossible
                    System.out.println("Case #" + x + ": Impossible");
                    skip = true;
                    break;
                }
            }
            if (!skip)
                System.out.println("Case #" + x + ": " + new String(res));
        }
    }
}
