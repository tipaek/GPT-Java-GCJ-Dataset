import java.util.*;

public class Solution {
    static class Pair {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Pair[] intervals = new Pair[n];

            for (int i = 0; i < n; i++) {
                intervals[i] = new Pair(scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(intervals, new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    return Integer.compare(p1.start, p2.start);
                }
            });

            StringBuilder result = new StringBuilder();
            Pair cameron = null, jamie = null;
            boolean possible = true;

            for (Pair interval : intervals) {
                if (cameron == null || interval.start >= cameron.end) {
                    cameron = interval;
                    result.append('C');
                } else if (jamie == null || interval.start >= jamie.end) {
                    jamie = interval;
                    result.append('J');
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}