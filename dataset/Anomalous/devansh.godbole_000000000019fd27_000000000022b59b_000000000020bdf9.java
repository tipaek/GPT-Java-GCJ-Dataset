import java.util.*;
import java.io.*;

class Interval {
    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean isOccupied(int start, int end) {
        return (end > this.start && start < this.end);
    }

    public static boolean assign(List<Interval> intervals, int start, int end) {
        for (Interval interval : intervals) {
            if (interval.isOccupied(start, end)) {
                return false;
            }
        }
        intervals.add(new Interval(start, end));
        return true;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            List<Interval> cList = new ArrayList<>();
            List<Interval> jList = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (Interval.assign(cList, start, end)) {
                    result.append("C");
                } else if (Interval.assign(jList, start, end)) {
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
        scanner.close();
    }
}