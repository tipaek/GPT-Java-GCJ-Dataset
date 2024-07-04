import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String... args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            mainLoop(i + 1, reader);
        }
    }

    private static void mainLoop(int caseId, BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        List<Interval> intervals = new ArrayList<Interval>();
        for (int i = 0; i < n; i++) {
            String[] intervalStr = reader.readLine().split(" ");
            intervals.add(new Interval(Integer.parseInt(intervalStr[0]), Integer.parseInt(intervalStr[1]), i));
        }
        Collections.sort(intervals);
        char[] resultArray = new char[n];
        boolean impossible = false;
        Interval previousOverlapping = null;
        Interval previousInterval = null;
        for (Interval interval : intervals) {
            if (!interval.overlap(previousInterval)) {
                previousOverlapping = interval.overlap(previousOverlapping) ? previousOverlapping : null;
                resultArray[interval.index] = 'C';
            } else if (!interval.overlap(previousOverlapping)) {
                previousOverlapping = previousInterval;
                resultArray[interval.index] = 'J';
            } else {
                impossible = true;
                break;
            }
            previousInterval = interval;
        }
        if (impossible) {
            System.out.println("Case #" + caseId + ": IMPOSSIBLE");
        } else {
            StringBuilder result = new StringBuilder("Case #" + caseId + ": ");
            for (char c : resultArray) {
                result.append(c);
            }
            System.out.println(result.toString());
        }
    }

    private static class Interval implements Comparable<Interval> {
        private Integer start;
        private Integer end;
        private int index;

        public Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public boolean overlap(Interval interval) {
            return interval != null && ((this.start >= interval.start && this.start < interval.end) ||
                  (this.end > interval.start && this.end <= interval.end));
        }

        @Override
        public int compareTo(Interval interval) {
            int startComparison = this.start.compareTo(interval.start);
            return startComparison != 0 ? startComparison : this.end.compareTo(interval.end);
        }

        @Override
        public String toString() {
            return "[" +
                  "start=" + start +
                  ", end=" + end +
                  ']';
        }
    }
}
