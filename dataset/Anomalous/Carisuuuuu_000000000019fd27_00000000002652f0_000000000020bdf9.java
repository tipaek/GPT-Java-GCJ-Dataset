import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    private static final String[] PEOPLE = {"C", "J"};

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
            if (this.start != o.start) {
                return Integer.compare(this.start, o.start);
            }
            return Integer.compare(this.end, o.end);
        }

        @Override
        public String toString() {
            return "(" + id + ": " + start + " - " + end + ")";
        }

        private static class Builder {
            private AtomicInteger idCounter = new AtomicInteger(0);
            public List<Range> ranges = new ArrayList<>();

            public void addRange(int start, int end) {
                ranges.add(new Range(idCounter.getAndIncrement(), start, end));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int numRanges = scanner.nextInt();
            Range.Builder builder = new Range.Builder();

            for (int i = 0; i < numRanges; ++i) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                builder.addRange(start, end);
            }

            String result = getOptions(builder.ranges)
                    .map(list -> IntStream.range(0, 2)
                            .boxed()
                            .limit(list.size())
                            .collect(Collectors.toMap(index -> PEOPLE[index], list::get))
                            .entrySet()
                            .stream()
                            .map(entry -> entry.getValue().stream()
                                    .collect(() -> new String[numRanges], 
                                            (arr, range) -> arr[range.id] = entry.getKey(), 
                                            Solution::combine))
                            .collect(() -> new String[numRanges], Solution::combine, Solution::combine))
                    .map(strings -> String.join("", strings))
                    .orElse("IMPOSSIBLE");

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static Stream<List<Range>> getOptions(List<Range> ranges) {
        // This method should be implemented to return the possible options
        // based on the ranges provided. The implementation is not provided
        // in the original code.
        return Stream.empty();
    }

    private static void combine(String[] a, String[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                a[i] = b[i];
            }
        }
    }
}