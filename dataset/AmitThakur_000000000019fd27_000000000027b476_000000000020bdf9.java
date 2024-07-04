import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static int [] parseTokens(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = parseInt(br.readLine());
       for (int T = 1; T <= t; T++) {
            int n = Integer.parseInt(br.readLine());
            List<Interval> intervalList = new ArrayList<>();
            while (n-- > 0) {
                int [] arr = parseTokens(br.readLine());
                intervalList.add(new Interval(arr[0], arr[1]));
            }
            solve(T, intervalList);

        }
    }

    public static class Interval implements Comparable<Interval> {

        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public int compareTo(Interval o) {
            int k = this.start - o.start;
            return k == 0 ? this.end - o.end : k;
        }
    }

    private static void solve(int i, List<Interval> intervalList) {

        Map<String, String> map = new HashMap<>();
        List<Interval> copy = new ArrayList<>(intervalList);
        Collections.sort(copy);

        int cs = 0, ce = 0;
        int js = 0, je = 0;

        for (Interval interval : copy) {
            if (interval.start >= ce) {
                map.put(interval.toString(), "C");
                cs = interval.start; ce = interval.end;
            } else if (interval.start >= je) {
                map.put(interval.toString(), "J");
                js = interval.start; je = interval.end;
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", i));
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Interval interval : intervalList) {
            sb.append(map.get(interval.toString()));
        }
        System.out.println(String.format("Case #%d: %s", i, sb));
    }
}