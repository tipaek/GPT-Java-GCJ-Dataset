import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public final class Solution {
    private BufferedReader br;
    private StringTokenizer stk;

    public static void main(String[] args) throws Exception {
        new Thread(null, () -> {
            try {
                new Solution().run();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }, "solution", 1 << 26).start();
    }

    public Solution() {
        this.stk = null;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    private final long MOD = 1000000007L;

    private void run() throws Exception {
        int testCases = ni();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int[] intervals = new int[1500];
            int n = ni();
            List<TimeSlot> timeSlots = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                int from = ni(), to = ni() - 1;
                timeSlots.add(new TimeSlot(from, to, i));
                intervals[from]++;
                intervals[to + 1]--;
            }

            for (int i = 1; i < intervals.length; i++) {
                intervals[i] += intervals[i - 1];
            }

            boolean impossible = Arrays.stream(intervals).anyMatch(interval -> interval > 2);

            if (impossible) {
                pl("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                Collections.sort(timeSlots);
                Stack<TimeSlot> stack = new Stack<>();
                stack.push(timeSlots.get(0));

                for (int i = 1; i < n; i++) {
                    TimeSlot current = timeSlots.get(i);
                    if (overlaps(current, stack.peek())) {
                        if (current.to < stack.peek().to) {
                            stack.pop();
                            stack.push(current);
                        }
                    } else {
                        stack.push(current);
                    }
                }

                Set<Integer> cameron = new HashSet<>();
                while (!stack.isEmpty()) {
                    cameron.add(stack.pop().index);
                }

                StringBuilder result = new StringBuilder(n);
                for (int i = 0; i < n; i++) {
                    result.append(cameron.contains(i) ? "C" : "J");
                }

                pl("Case #" + testCase + ": " + result.toString());
            }
        }
    }

    private boolean overlaps(TimeSlot p, TimeSlot q) {
        return (q.from >= p.from && q.from <= p.to) || (p.from >= q.from && p.from <= q.to);
    }

    private static class TimeSlot implements Comparable<TimeSlot> {
        int from, to, index;

        public TimeSlot(int from, int to, int index) {
            this.from = from;
            this.to = to;
            this.index = index;
        }

        @Override
        public int compareTo(TimeSlot other) {
            if (this.from == other.from) {
                return Integer.compare(this.to, other.to);
            }
            return Integer.compare(this.from, other.from);
        }

        @Override
        public String toString() {
            return "[" + from + ", " + to + "]";
        }
    }

    private String nextToken() throws Exception {
        if (stk == null || !stk.hasMoreTokens()) {
            stk = new StringTokenizer(br.readLine(), " ");
        }
        return stk.nextToken();
    }

    private String nt() throws Exception {
        return nextToken();
    }

    private String ns() throws Exception {
        return br.readLine();
    }

    private int ni() throws Exception {
        return Integer.parseInt(nextToken());
    }

    private long nl() throws Exception {
        return Long.parseLong(nextToken());
    }

    private double nd() throws Exception {
        return Double.parseDouble(nextToken());
    }

    private void p(Object o) {
        System.out.print(o);
    }

    private void pl(Object o) {
        System.out.println(o);
    }
}