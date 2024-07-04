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

        @Override
        public int compareTo(Range o) {
            return this.start != o.start ? this.start - o.start : this.end - o.end;
        }

        @Override
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
            String result = getOptions(builder.ranges)
                    .map(options -> IntStream.rangeClosed(0, 1)
                            .boxed()
                            .limit(options.size())
                            .collect(Collectors.toMap(p -> PEOPLE[p], options::get))
                            .entrySet().stream()
                            .map(entry -> entry.getValue().stream()
                                    .collect(() -> new String[n],
                                            (arr, range) -> arr[range.id] = entry.getKey(),
                                            Solution::combine))
                            .collect(() -> new String[n], Solution::combine, Solution::combine))
                    .map(strings -> String.join("", strings))
                    .orElse("IMPOSSIBLE");

            System.out.println("Case #" + g + ": " + result);
        }
    }

    private static Optional<List<Set<Range>>> getOptions(List<Range> ranges) {
        List<Set<Range>> options = ranges.stream()
                .sorted()
                .collect(ArrayList::new, (list, range) -> {
                    Optional<Set<Range>> possibleSet = list.stream()
                            .filter(set -> set.stream().noneMatch(existingRange ->
                                    (range.start >= existingRange.start && range.start < existingRange.end) ||
                                            (range.end > existingRange.start && range.end <= existingRange.end)))
                            .findFirst();
                    possibleSet.ifPresent(set -> set.add(range));
                    possibleSet.orElseGet(() -> list.add(Stream.of(range).collect(Collectors.toSet())) ? null : null);
                }, ArrayList::addAll);

        if (options.size() > 2) {
            return Optional.empty();
        }
        return Optional.of(options);
    }

    private static void combine(String[] into, String[] from) {
        IntStream.range(0, from.length)
                .forEach(i -> into[i] = into[i] != null ? into[i] : from[i]);
    }
}