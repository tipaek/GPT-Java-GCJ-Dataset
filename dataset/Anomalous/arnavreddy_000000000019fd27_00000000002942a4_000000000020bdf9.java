import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = scanner.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(scanner.nextInt(), scanner.nextInt(), i);
            }

            Arrays.sort(intervals);

            Interval cam = null;
            Interval jam = null;
            String[] schedule = new String[n];
            boolean impossible = false;

            for (Interval interval : intervals) {
                if (cam == null || cam.end <= interval.start) {
                    cam = interval;
                    schedule[interval.originalIndex] = "C";
                } else if (jam == null || jam.end <= interval.start) {
                    jam = interval;
                    schedule[interval.originalIndex] = "J";
                } else {
                    impossible = true;
                    break;
                }
            }

            System.out.print("Case #" + caseNum + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (String s : schedule) {
                    System.out.print(s);
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

    public Interval(int start, int end, int originalIndex) {
        this.originalIndex = originalIndex;
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