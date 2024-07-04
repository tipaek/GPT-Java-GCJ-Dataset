import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            List<Pair> intervals = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Pair(start, end));
            }
            String result = solve(intervals);
            System.out.printf("Case #%d: %s%n", t, result);
        }
    }

    static String solve(List<Pair> intervals) {
        List<Pair> cam = new ArrayList<>();
        List<Pair> jam = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        
        for (Pair interval : intervals) {
            if (canAssign(cam, interval)) {
                cam.add(interval);
                result.append('C');
            } else if (canAssign(jam, interval)) {
                jam.add(interval);
                result.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    static boolean canAssign(List<Pair> schedule, Pair interval) {
        for (Pair p : schedule) {
            if (interval.start < p.end && interval.end > p.start) {
                return false;
            }
        }
        return true;
    }

    static class Pair {
        int start, end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return start == pair.start && end == pair.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}