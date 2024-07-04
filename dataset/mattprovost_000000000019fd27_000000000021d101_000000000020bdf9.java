import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            boolean possible = true;

            Map<Range, Character> map = new HashMap<>();

            int count = in.nextInt();
            for (int j = 0; j < count; j++) {
                Range range = new Range(in.nextInt(), in.nextInt());

                List<Character> starts = find(map, range);
                if (starts.contains('C') && starts.contains('J')) {
                    possible = false;
                    break;
                }

                if (starts.contains('C')) {
                    map.put(range, 'J');
                } else {
                    map.put(range, 'C');
                }
            }

            if (!possible) {
                System.out.printf("Case #%d: %s\n", i, "IMPOSSIBLE");
            } else {
                System.out.printf("Case #%d: ", i);

                for (Character c : map.values()) {
                    System.out.print(c);
                }

                System.out.println();
            }
        }
    }

    private static List<Character> find(Map<Range, Character> map, Range range) {
        List<Character> chars = new ArrayList<>();

        for (Map.Entry<Range, Character> entry : map.entrySet()) {
            if (entry.getKey().start < range.start && entry.getKey().end > range.start) {
                chars.add(entry.getValue());
            }
        }

        return chars;
    }

    private static class Range {
        public int start;
        public int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Range range = (Range) o;
            return start == range.start &&
                    end == range.end;
        }

        @Override
        public int hashCode() {
            return (int) Math.pow(start, end);
        }
    }
}
