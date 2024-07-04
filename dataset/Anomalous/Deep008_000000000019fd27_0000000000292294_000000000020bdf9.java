import java.util.*;

class Solution {

    public static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; ++t) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];
            Map<Interval, Integer> intervalIndexMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Interval(start, end);
                intervalIndexMap.put(intervals[i], i);
            }

            Arrays.sort(intervals, (a, b) -> {
                if (a.start != b.start) {
                    return a.start - b.start;
                } else {
                    return a.end - b.end;
                }
            });

            String result = assignTasks(intervals, n, intervalIndexMap);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String assignTasks(Interval[] intervals, int n, Map<Interval, Integer> intervalIndexMap) {
        char[] result = new char[n];
        int cameronEndTime = 0, jamieEndTime = 0;

        for (Interval interval : intervals) {
            if (cameronEndTime <= interval.start) {
                cameronEndTime = interval.end;
                result[intervalIndexMap.get(interval)] = 'C';
            } else if (jamieEndTime <= interval.start) {
                jamieEndTime = interval.end;
                result[intervalIndexMap.get(interval)] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(result);
    }
}