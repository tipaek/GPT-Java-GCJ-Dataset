import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
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
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int g = 1; g <= t; ++g) {
            int n = scanner.nextInt();
            // Add the remaining logic here
        }
    }
}