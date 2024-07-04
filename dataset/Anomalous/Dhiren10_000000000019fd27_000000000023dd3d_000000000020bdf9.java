import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int testCase = 0;

        while (t-- > 0) {
            testCase++;
            int n = sc.nextInt();
            Pair[] intervals = new Pair[n];
            Pair[] originalIntervals = new Pair[n];

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals[i] = new Pair(start, end);
                originalIntervals[i] = new Pair(start, end);
            }

            Arrays.sort(intervals, (p1, p2) -> {
                if (p1.start != p2.start) {
                    return p1.start - p2.start;
                }
                return p1.end - p2.end;
            });

            boolean isImpossible = false;
            Map<Pair, Character> scheduleMap = new HashMap<>();
            int maxC = intervals[0].end;
            int maxJ = intervals[1].end;
            scheduleMap.put(new Pair(intervals[0].start, intervals[0].end), 'C');
            scheduleMap.put(new Pair(intervals[1].start, intervals[1].end), 'J');

            for (int i = 2; i < n; i++) {
                int start = intervals[i].start;
                int end = intervals[i].end;

                if (start < maxC && start < maxJ) {
                    isImpossible = true;
                    break;
                } else if (start >= maxC) {
                    scheduleMap.put(new Pair(start, end), 'C');
                    maxC = Math.max(maxC, end);
                } else if (start >= maxJ) {
                    scheduleMap.put(new Pair(start, end), 'J');
                    maxJ = Math.max(maxJ, end);
                }
            }

            StringBuilder result = new StringBuilder();
            if (isImpossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (Pair p : originalIntervals) {
                    result.append(scheduleMap.get(new Pair(p.start, p.end)));
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}

class Pair {
    int start;
    int end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return start == pair.start && end == pair.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}