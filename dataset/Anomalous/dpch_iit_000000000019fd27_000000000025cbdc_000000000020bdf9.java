import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Interval {
    int index;
    int start;
    int end;

    public Interval(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }
}

class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval i1, Interval i2) {
        return Integer.compare(i1.start, i2.start);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        processInput();
    }

    private static void processInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine().trim());

        for (int i = 1; i <= testCaseCount; i++) {
            handleTestCase(i, reader);
        }
    }

    private static void handleTestCase(int caseNumber, BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine().trim());
        Interval[] intervals = new Interval[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            intervals[i] = new Interval(i, start, end);
        }

        Arrays.sort(intervals, new IntervalComparator());
        char[] result = new char[n];
        int cFreeTime = 0;
        int jFreeTime = 0;

        for (Interval interval : intervals) {
            if (interval.start >= cFreeTime) {
                result[interval.index] = 'C';
                cFreeTime = interval.end;
            } else if (interval.start >= jFreeTime) {
                result[interval.index] = 'J';
                jFreeTime = interval.end;
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + new String(result));
    }
}