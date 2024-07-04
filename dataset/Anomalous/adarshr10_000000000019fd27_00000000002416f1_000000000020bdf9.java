import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int x = 1; x <= t; ++x) {
            List<Pair<Integer, Integer>> intervals = new ArrayList<>();
            int size = in.nextInt();
            for (int i = 0; i < size; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                intervals.add(new Pair<>(start, end));
            }
            String result = solve(intervals);
            System.out.println("Case #" + x + ": " + result);
        }
    }

    static String solve(List<Pair<Integer, Integer>> intervals) {
        int n = intervals.size();
        StringBuilder ans = new StringBuilder();
        List<Pair<Integer, Integer>> cameron = new ArrayList<>();
        List<Pair<Integer, Integer>> jamie = new ArrayList<>();
        
        for (Pair<Integer, Integer> interval : intervals) {
            if (canAssign(cameron, interval)) {
                cameron.add(interval);
                ans.append("C");
            } else if (canAssign(jamie, interval)) {
                jamie.add(interval);
                ans.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return ans.toString();
    }

    static boolean canAssign(List<Pair<Integer, Integer>> schedule, Pair<Integer, Integer> interval) {
        for (Pair<Integer, Integer> existing : schedule) {
            if (!(interval.getKey() >= existing.getValue() || interval.getValue() <= existing.getKey())) {
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
        return key.equals(pair.key) && value.equals(pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}