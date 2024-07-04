import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; ++t) {
            int size = scanner.nextInt();
            List<Pair<Integer, Integer>> intervals = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Pair<>(start, end));
            }
            
            String result = solve(intervals);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    static String solve(List<Pair<Integer, Integer>> intervals) {
        List<Pair<Integer, Integer>> cameron = new ArrayList<>();
        List<Pair<Integer, Integer>> jamie = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();
        
        for (Pair<Integer, Integer> interval : intervals) {
            if (canBeAssigned(cameron, interval)) {
                cameron.add(interval);
                schedule.append("C");
            } else if (canBeAssigned(jamie, interval)) {
                jamie.add(interval);
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return schedule.toString();
    }

    static boolean canBeAssigned(List<Pair<Integer, Integer>> personSchedule, Pair<Integer, Integer> interval) {
        for (Pair<Integer, Integer> scheduledInterval : personSchedule) {
            if (!(interval.getKey() >= scheduledInterval.getValue() || interval.getValue() <= scheduledInterval.getKey())) {
                return false;
            }
        }
        return true;
    }
}

class Pair<A, B> {
    private final A key;
    private final B value;

    public Pair(A key, B value) {
        this.key = key;
        this.value = value;
    }

    public A getKey() {
        return key;
    }

    public B getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}