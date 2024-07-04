
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static class Interval {
        int id;
        int start;
        int end;
        char assignment = 0;

        public Interval(int i, int s, int e) {
            id = i;
            start = s;
            end = e;
        }

        public void assign(char s) {
            assignment = s;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(reader);

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            List<Interval> list = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                int s = in.nextInt();
                int e = in.nextInt();
                list.add(new Interval(j, s, e));
            }
            String res = solve(list);

            System.out.println("Case #" + i + ": " + res);
        }
    }

    private static String solve(List<Interval> list) {
        char [] result = new char[list.size()];
        list.sort(Comparator.comparingInt(i -> i.start));
        PriorityQueue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.end));
        Deque<Character> availableParents = new ArrayDeque<>();
        availableParents.push('C');
        availableParents.push('J');
        for (Interval interval : list) {
            while (!pq.isEmpty() && pq.peek().end <= interval.start) {
                Interval prev = pq.poll();
                availableParents.push(prev.assignment);
            }

            if (availableParents.isEmpty()) return "IMPOSSIBLE";
            Character parent = availableParents.pop();
            result[interval.id] = parent;
            interval.assign(parent);
            pq.offer(interval);

        }
        return new String(result);
    }
}
