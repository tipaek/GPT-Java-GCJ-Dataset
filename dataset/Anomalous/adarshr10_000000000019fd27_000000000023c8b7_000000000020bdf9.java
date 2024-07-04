import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            List<Tuple<Integer, Integer>> intervals = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Tuple<>(start, end));
            }

            String result = solve(intervals);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    static String solve(List<Tuple<Integer, Integer>> intervals) {
        int n = intervals.size();
        List<Tuple<Integer, Integer>> cameron = new ArrayList<>();
        List<Tuple<Integer, Integer>> jamie = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();

        for (Tuple<Integer, Integer> interval : intervals) {
            if (canAddInterval(cameron, interval)) {
                cameron.add(interval);
                schedule.append('C');
            } else if (canAddInterval(jamie, interval)) {
                jamie.add(interval);
                schedule.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    static boolean canAddInterval(List<Tuple<Integer, Integer>> intervals, Tuple<Integer, Integer> newInterval) {
        for (Tuple<Integer, Integer> interval : intervals) {
            if (!(newInterval.b <= interval.a || newInterval.a >= interval.b)) {
                return false;
            }
        }
        return true;
    }
}

class Tuple<A, B> {
    public final A a;
    public final B b;

    public Tuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple<?, ?> tuple = (Tuple<?, ?>) o;
        return a.equals(tuple.a) && b.equals(tuple.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}