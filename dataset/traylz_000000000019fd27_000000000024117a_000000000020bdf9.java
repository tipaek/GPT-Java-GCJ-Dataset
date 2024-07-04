
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;

public class Solution {

    enum Person {C, J}

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numOfCases = Integer.parseInt(in.readLine());
        for (int i = 1; i <= numOfCases; i++) {
            int numOfIntervals = Integer.parseInt(in.readLine());
            List<Interval> intervals = new ArrayList<>();
            for (int j = 0; j < numOfIntervals; j++) {
                intervals.add(Interval.parseFrom(in.readLine(), j));
            }
            List<Person> solution = solve(intervals);
            System.out.println("Case #" + i + ": " +
                (solution.isEmpty() ? "IMPOSSIBLE" : solution.stream().map(Person::toString).collect(joining())));
        }

    }

    public static List<Person> solve(List<Interval> intervalsUnsorted) {
        List<Interval> intervals = intervalsUnsorted.stream().sorted(comparing(interval -> interval.start)).collect(Collectors.toList());
        Map<Person, Interval> openIntervals = new HashMap<>();
        Map<Interval, Person> result = new LinkedHashMap<>();
        for (Interval currentInterval : intervals) {
            openIntervals = openIntervals.entrySet().stream().filter(it -> it.getValue().endExclusive > currentInterval.start).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            Optional<Person> nextPerson = findFreePerson(openIntervals);
            if (nextPerson.isPresent()) {
                openIntervals.put(nextPerson.get(), currentInterval);
                result.put(currentInterval, nextPerson.get());
            } else {
                return emptyList();
            }
        }
        return result.entrySet().stream().sorted(comparing(entry -> entry.getKey().index)).map(Map.Entry::getValue).collect(Collectors.toList());
    }

    private static Optional<Person> findFreePerson(Map<Person, Interval> openIntervals) {
        return Stream.of(Person.C, Person.J).filter(it -> !openIntervals.containsKey(it)).findFirst();
    }

    public static class Interval {
        public final Integer start;
        public final Integer endExclusive;
        public final Integer index;

        public Interval(int start, int endExclusive, Integer index) {
            this.start = start;
            this.endExclusive = endExclusive;
            this.index = index;
        }

        public static Interval parseFrom(String line, int index) {
            String[] strings = line.split(" ");
            return new Interval(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), index);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return index.equals(interval.index);
        }

        @Override
        public int hashCode() {
            return Objects.hash(index);
        }

        @Override
        public String toString() {
            return index + "=[" + start + ":" + endExclusive + ")";
        }
    }


}
