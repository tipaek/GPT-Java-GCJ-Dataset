import java.util.Arrays;
import java.util.Scanner;

class Interval implements Comparable<Interval> {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval other) {
        if (this.start == other.start) {
            return this.end - other.end;
        } else {
            return this.start - other.start;
        }
    }
}

public class Solution {

    public static String assignTasks(Interval[] intervals) {
        Arrays.sort(intervals);
        int cEnd = -1;
        int jEnd = -1;
        StringBuilder result = new StringBuilder();

        for (Interval interval : intervals) {
            if (cEnd == -1 || interval.start >= cEnd) {
                cEnd = interval.end;
                result.append("C");
            } else if (jEnd == -1 || interval.start >= jEnd) {
                jEnd = interval.end;
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int intervalCount = scanner.nextInt();
            Interval[] intervals = new Interval[intervalCount];

            for (int i = 0; i < intervalCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Interval(start, end);
            }

            String result = assignTasks(intervals);
            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }
}