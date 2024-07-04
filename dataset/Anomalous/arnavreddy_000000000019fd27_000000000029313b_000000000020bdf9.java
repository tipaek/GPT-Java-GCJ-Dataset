import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];
            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(scanner.nextInt(), scanner.nextInt(), i);
            }

            Arrays.sort(intervals);

            Interval cameron = null, jamie = null;
            String[] result = new String[n];
            boolean impossible = false;

            for (int i = 0; i < intervals.length; i++) {
                if (cameron == null || cameron.end <= intervals[i].start) {
                    cameron = intervals[i];
                    result[intervals[i].originalIndex] = "C";
                } else if (jamie == null || jamie.end <= intervals[i].start) {
                    jamie = intervals[i];
                    result[intervals[i].originalIndex] = "J";
                } else {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                System.out.print("Case #" + caseNumber + ": ");
                for (String res : result) {
                    System.out.print(res);
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