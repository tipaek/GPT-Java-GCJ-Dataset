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
        List<Pair<Integer, Integer>> cam = new ArrayList<>();
        List<Pair<Integer, Integer>> jam = new ArrayList<>();
        StringBuilder ans = new StringBuilder();

        for (Pair<Integer, Integer> interval : intervals) {
            if (canAddToSchedule(cam, interval)) {
                cam.add(interval);
                ans.append("C");
            } else if (canAddToSchedule(jam, interval)) {
                jam.add(interval);
                ans.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return ans.toString();
    }

    static boolean canAddToSchedule(List<Pair<Integer, Integer>> schedule, Pair<Integer, Integer> interval) {
        for (Pair<Integer, Integer> scheduled : schedule) {
            if (!(interval.a < scheduled.a && interval.b <= scheduled.a || interval.a >= scheduled.b && interval.b > scheduled.b)) {
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
        return a.equals(pair.a) && b.equals(pair.b);
    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = 31 * result + b.hashCode();
        return result;
    }
}