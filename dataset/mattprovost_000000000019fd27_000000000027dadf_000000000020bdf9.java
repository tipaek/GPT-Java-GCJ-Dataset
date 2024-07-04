import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            boolean possible = true;

            List<Range> times = new ArrayList<>();
            int count = in.nextInt();
            for (int j = 0; j < count; j++) {
                times.add(new Range(in.nextInt(), in.nextInt()));
            }

            Map<Range, List<Range>> overlaps = new LinkedHashMap<>();
            for (int j = 0; j < times.size(); j++) {
                Range r = times.get(j);
                overlaps.put(r, overlaps(times, r));
            }

            List<Character> chars = new ArrayList<>();
            end:
            for (Map.Entry<Range, List<Range>> e : overlaps.entrySet()) {
                for (Range r : e.getValue()) {
                    if (overlaps(e.getValue(), r).size() > 0) {
                        possible = false;
                        break end;
                    }
                }

                if (e.getValue().size() == 0) {
                    chars.add('C');
                } else {
                    int idx = times.indexOf(e.getValue().get(0));
                    if (chars.size() > idx) {
                        chars.add(chars.get(idx) == 'C' ? 'J' : 'C');
                    } else {
                        chars.add('C');
                    }
                }
            }

            if (!possible) {
                System.out.printf("Case #%d: %s\n", i, "IMPOSSIBLE");
            } else {
                System.out.printf("Case #%d: ", i);

                for (Character c : chars) {
                    System.out.print(c);
                }

                System.out.println();
            }
        }
    }

    private static List<Range> overlaps(List<Range> times, Range r) {
        List<Range> result = new ArrayList<>();

        for(Range range : times) {
            if (r.overlaps(range)) {
                result.add(range);
            }
        }

        return result;
    }

    private static class Range {
        public int start;
        public int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlaps(Range r) {
            return between(start, end, r.start) || between(start, end, r.end) || between(r.start, r.end, start) || between(r.start, r.end, end);
        }

        private boolean between(int start, int end, int value) {
            return start < value && end > value;
        }
    }
}
