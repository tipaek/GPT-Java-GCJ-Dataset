import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            List<Pair<Integer, Integer>> intervals = new ArrayList<>();
            int size = scanner.nextInt();
            
            for (int i = 0; i < size; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Pair<>(start, end));
            }
            
            String result = solve(intervals);
            System.out.println("Case #" + t + ": " + result);
        }
    }
    
    private static String solve(List<Pair<Integer, Integer>> intervals) {
        int n = intervals.size();
        List<Pair<Integer, Integer>> cameron = new ArrayList<>();
        List<Pair<Integer, Integer>> jamie = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();
        
        for (Pair<Integer, Integer> interval : intervals) {
            if (canBeScheduled(cameron, interval)) {
                cameron.add(interval);
                schedule.append("C");
            } else if (canBeScheduled(jamie, interval)) {
                jamie.add(interval);
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return schedule.toString();
    }
    
    private static boolean canBeScheduled(List<Pair<Integer, Integer>> schedule, Pair<Integer, Integer> newInterval) {
        for (Pair<Integer, Integer> interval : schedule) {
            if (!(newInterval.a >= interval.b || newInterval.b <= interval.a)) {
                return false;
            }
        }
        return true;
    }
}

class Pair<A, B> {
    public final A a;
    public final B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;
        if (!a.equals(pair.a)) return false;
        return b.equals(pair.b);
    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = 31 * result + b.hashCode();
        return result;
    }
}