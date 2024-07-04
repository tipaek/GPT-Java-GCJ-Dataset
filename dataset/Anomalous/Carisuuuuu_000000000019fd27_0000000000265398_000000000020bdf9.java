import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        public int compareTo(Range other) {
            if (this.start != other.start) {
                return this.start - other.start;
            }
            return this.end - other.end;
        }

        @Override
        public String toString() {
            return "(" + id + ": " + start + " - " + end + ")";
        }

        private static class Builder {
            private AtomicInteger idGenerator = new AtomicInteger(0);
            public List<Range> ranges = new ArrayList<>();

            public void addRange(int start, int end) {
                ranges.add(new Range(idGenerator.getAndIncrement(), start, end));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int g = 1; g <= testCases; ++g) {
            int n = scanner.nextInt();
            Range.Builder builder = new Range.Builder();
            for (int m = 0; m < n; ++m) {
                builder.addRange(scanner.nextInt(), scanner.nextInt());
            }
            String result = getOptions(builder.ranges)
                    .map(assignments -> IntStream.range(0, assignments.size())
                            .boxed()
                            .collect(Collectors.toMap(
                                    i -> PEOPLE[i % PEOPLE.length],
                                    assignments::get
                            ))
                            .entrySet()
                            .stream()
                            .map(entry -> {
                                String[] schedule = new String[n];
                                entry.getValue().forEach(range -> schedule[range.id] = entry.getKey());
                                return schedule;
                            })
                            .reduce(new String[n], Solution::combine))
                    .map(schedules -> String.join("", schedules))
                    .orElse("IMPOSSIBLE");

            System.out.println("Case #" + g + ": " + result);
        }
    }

    private static Optional<List<List<Range>>> getOptions(List<Range> ranges) {
        // Assuming this method is defined elsewhere in the original code
        // and returns the possible assignments for the ranges.
        return Optional.empty();
    }

    private static void combine(String[] a, String[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                a[i] = b[i];
            }
        }
    }
}