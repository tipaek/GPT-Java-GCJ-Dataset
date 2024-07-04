import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Interval(start, end, i);
            }

            Arrays.sort(intervals, (i1, i2) -> {
                if (i1.start == i2.start) {
                    return i1.end - i2.end;
                }
                return i1.start - i2.start;
            });

            char[] result = new char[n];
            Map<Character, Integer> scheduler = new HashMap<>();
            scheduler.put('C', intervals[0].end);
            result[intervals[0].index] = 'C';

            boolean isPossible = true;
            for (int i = 1; i < n; i++) {
                int start = intervals[i].start;
                int end = intervals[i].end;

                int cEnd = scheduler.getOrDefault('C', -1);
                int jEnd = scheduler.getOrDefault('J', -1);

                if (start < cEnd && start < jEnd) {
                    isPossible = false;
                    break;
                } else if (start >= cEnd) {
                    scheduler.put('C', end);
                    result[intervals[i].index] = 'C';
                } else {
                    scheduler.put('J', end);
                    result[intervals[i].index] = 'J';
                }
            }

            System.out.print("Case #" + t + ": ");
            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(new String(result));
            }
        }
    }

    static class Interval {
        int start, end, index;

        public Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}