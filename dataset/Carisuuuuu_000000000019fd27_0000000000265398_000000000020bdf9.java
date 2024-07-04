import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    private static final String[] PEOPLE = { "C", "J" };

    private static class Range implements Comparable<Range> {
        public int id;
        public int start;
        public int end;
        public Range(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }
        public int compareTo(Range o) {
            return o.start != start ? start - o.start : end - o.end;
        }
        public String toString() {
            return "(" + id + ": " + start + " - " + end + ")";
        }
        private static class Builder {
            private AtomicInteger ai = new AtomicInteger(0);
            public List<Range> ranges = new ArrayList<>();
            public void addRange(int start, int end) {
                ranges.add(new Range(ai.getAndIncrement(), start, end));
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int g = 1; g <= t; ++g) {
            int n = in.nextInt();
            Range.Builder builder = new Range.Builder();
            for (int m = 1; m <= n; ++m) {
                builder.addRange(in.nextInt(), in.nextInt());
            }
            String res = getOpts(builder.ranges)
                    .map(l -> IntStream.rangeClosed(0, 1)
                            .boxed()
                            .limit(l.size())
                            .collect(Collectors.toMap(p -> PEOPLE[p],
                                    l::get))
                            .entrySet().stream()
                            .map(e -> e.getValue().stream().collect(() -> new String[n],
                                    (a, r) -> a[r.id] = e.getKey(),
                                    Solution::combine))
                            .collect(() -> new String[n], Solution::combine, Solution::combine))
                    .map(ss -> String.join("", ss))
                    .orElse("IMPOSSIBLE");

            System.out.println("Case #" + g + ": " + res);
        }
    }
}
