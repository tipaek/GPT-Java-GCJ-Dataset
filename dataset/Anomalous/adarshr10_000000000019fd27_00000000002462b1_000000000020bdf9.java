import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            List<Pair<Integer, Integer>> intervals = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Pair<>(start, end));
            }

            String result = solve(intervals);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String solve(List<Pair<Integer, Integer>> intervals) {
        int n = intervals.size();
        StringBuilder schedule = new StringBuilder();
        List<Pair<Integer, Integer>> cameron = new ArrayList<>();
        List<Pair<Integer, Integer>> jamie = new ArrayList<>();

        for (Pair<Integer, Integer> interval : intervals) {
            if (canAssign(interval, cameron)) {
                cameron.add(interval);
                schedule.append('C');
            } else if (canAssign(interval, jamie)) {
                jamie.add(interval);
                schedule.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    private static boolean canAssign(Pair<Integer, Integer> interval, List<Pair<Integer, Integer>> assigned) {
        for (Pair<Integer, Integer> assignedInterval : assigned) {
            if (!(interval.getFirst() >= assignedInterval.getSecond() || interval.getSecond() <= assignedInterval.getFirst())) {
                return false;
            }
        }
        return true;
    }
}

class Pair<A, B> {
    private final A first;
    private final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return first.equals(pair.first) && second.equals(pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}