import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static final char[] PERSON = {'C', 'J'};

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

            System.out.print(String.format("Case #%d: ", t));
            Arrays.sort(intervals, (a, b) -> a.end != b.end ? a.end - b.end : a.start - b.start);

            Interval[] assigned = new Interval[2];
            int currentPerson = 0;
            StringBuilder result = new StringBuilder();

            for (Interval interval : intervals) {
                if (assigned[currentPerson] == null || noOverlap(assigned[currentPerson], interval)) {
                    assigned[currentPerson] = interval;
                    result.append(PERSON[currentPerson]);
                } else if (assigned[1 - currentPerson] == null || noOverlap(assigned[1 - currentPerson], interval)) {
                    currentPerson = 1 - currentPerson;
                    assigned[currentPerson] = interval;
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

    private static boolean noOverlap(Interval assignedInterval, Interval newInterval) {
        return assignedInterval.end <= newInterval.start;
    }
}