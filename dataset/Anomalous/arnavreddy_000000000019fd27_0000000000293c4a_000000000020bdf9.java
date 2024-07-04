import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(scanner.nextInt(), scanner.nextInt(), i);
            }

            Arrays.sort(intervals);
            String[] assignments = new String[n];
            Interval cameron = null, jamie = null;
            boolean isImpossible = false;

            for (Interval interval : intervals) {
                if (cameron == null || cameron.end <= interval.start) {
                    cameron = interval;
                    assignments[interval.originalIndex] = "C";
                } else if (jamie == null || jamie.end <= interval.start) {
                    jamie = interval;
                    assignments[interval.originalIndex] = "J";
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            if (!isImpossible) {
                System.out.print("Case #" + t + ": ");
                for (String assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            }
        }
    }
}

class Interval implements Comparable<Interval> {
    int originalIndex;
    int start;
    int end;

    public Interval(int start, int end, int index) {
        this.originalIndex = index;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval other) {
        if (this.start == other.start) {
            return Integer.compare(this.end, other.end);
        }
        return Integer.compare(this.start, other.start);
    }
}