import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static final char[] PERSON = {'C', 'J'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(br.readLine());
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().trim().split("\\s+");
                intervals[i] = new Interval(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            }

            System.out.print("Case #" + t + ": ");
            Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));

            Interval[] activeIntervals = new Interval[2];
            int currentPerson = 0;
            StringBuilder result = new StringBuilder();

            boolean isPossible = true;

            for (Interval interval : intervals) {
                if (activeIntervals[currentPerson] == null || !overlaps(activeIntervals[currentPerson], interval)) {
                    activeIntervals[currentPerson] = interval;
                    result.append(PERSON[currentPerson]);
                } else if (activeIntervals[1 - currentPerson] == null || !overlaps(activeIntervals[1 - currentPerson], interval)) {
                    currentPerson = 1 - currentPerson;
                    activeIntervals[currentPerson] = interval;
                    result.append(PERSON[currentPerson]);
                } else {
                    System.out.println("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println(result.toString());
            }
        }
    }

    private static boolean overlaps(Interval active, Interval incoming) {
        return active.end > incoming.start;
    }
}