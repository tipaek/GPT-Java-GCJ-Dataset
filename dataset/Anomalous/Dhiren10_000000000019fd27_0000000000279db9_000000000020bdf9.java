import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int testCaseNumber = 0;

        while (t-- > 0) {
            testCaseNumber++;
            int n = sc.nextInt();
            Pair[] intervals = new Pair[n];
            Pair[] original = new Pair[n];

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals[i] = new Pair(start, end);
                original[i] = new Pair(start, end);
            }

            Arrays.sort(intervals, Comparator.comparingInt(p -> p.start));

            boolean isPossible = true;
            Map<Pair, Character> assignmentC = new HashMap<>();
            Map<Pair, Character> assignmentJ = new HashMap<>();
            int maxCEnd = intervals[0].end;
            int maxJEnd = 0;

            assignmentC.put(new Pair(intervals[0].start, intervals[0].end), 'C');

            for (int i = 1; i < n; i++) {
                int currentStart = intervals[i].start;
                int currentEnd = intervals[i].end;

                if (maxCEnd <= currentStart && !assignmentC.containsKey(new Pair(currentStart, currentEnd))) {
                    assignmentC.put(new Pair(currentStart, currentEnd), 'C');
                    maxCEnd = currentEnd;
                } else if (maxJEnd <= currentStart && !assignmentJ.containsKey(new Pair(currentStart, currentEnd))) {
                    assignmentJ.put(new Pair(currentStart, currentEnd), 'J');
                    maxJEnd = currentEnd;
                } else {
                    isPossible = false;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (!isPossible || (assignmentC.size() + assignmentJ.size()) != n) {
                result.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    Pair p = original[i];
                    if (assignmentC.containsKey(p)) {
                        result.append(assignmentC.get(new Pair(p.start, p.end)));
                        assignmentC.remove(p);
                    } else {
                        result.append(assignmentJ.get(new Pair(p.start, p.end)));
                        assignmentJ.remove(p);
                    }
                }
            }

            System.out.println("Case #" + testCaseNumber + ": " + result.toString());
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
        if (!(o instanceof Pair)) return false;
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