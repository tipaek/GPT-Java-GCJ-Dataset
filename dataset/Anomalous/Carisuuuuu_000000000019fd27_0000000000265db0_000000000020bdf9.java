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
        public int compareTo(Range other) {
            return this.start != other.start ? this.start - other.start : this.end - other.end;
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

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            Range.Builder rangeBuilder = new Range.Builder();

            for (int i = 0; i < n; i++) {
                rangeBuilder.addRange(scanner.nextInt(), scanner.nextInt());
            }

            String result = getOptions(rangeBuilder.ranges)
                    .map(optionList -> IntStream.range(0, 2)
                            .boxed()
                            .limit(optionList.size())
                            .collect(Collectors.toMap(index -> PEOPLE[index], optionList::get))
                            .entrySet().stream()
                            .map(entry -> {
                                String[] schedule = new String[n];
                                entry.getValue().forEach(range -> schedule[range.id] = entry.getKey());
                                return schedule;
                            })
                            .reduce(new String[n], (combined, current) -> combineSchedules(combined, current)))
                    .map(schedule -> String.join("", schedule))
                    .orElse("IMPOSSIBLE");

            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static Optional<List<Set<Range>>> getOptions(List<Range> ranges) {
        List<Set<Range>> options = ranges.stream()
                .sorted()
                .collect(ArrayList::new, (list, currentRange) -> {
                    Optional<Set<Range>> possibleSet = list.stream()
                            .filter(set -> set.stream()
                                    .noneMatch(existingRange -> (currentRange.start < existingRange.end && currentRange.end > existingRange.start)))
                            .findFirst();
                    possibleSet.ifPresentOrElse(set -> set.add(currentRange), () -> list.add(Stream.of(currentRange).collect(Collectors.toSet())));
                }, ArrayList::addAll);

        return options.size() > 2 ? Optional.empty() : Optional.of(options);
    }

    private static String[] combineSchedules(String[] baseSchedule, String[] newSchedule) {
        IntStream.range(0, newSchedule.length)
                .forEach(index -> baseSchedule[index] = baseSchedule[index] != null ? baseSchedule[index] : newSchedule[index]);
        return baseSchedule;
    }
}