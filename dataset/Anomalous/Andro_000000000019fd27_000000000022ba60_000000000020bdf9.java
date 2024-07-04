import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        PrintWriter writer = new PrintWriter(System.out);
        Task solver = new Task();
        solver.solve(reader, writer);
        writer.close();
    }
}

class Task {
    private boolean hasOverlap(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) {
                return true;
            }
        }
        return false;
    }

    public void solve(FastReader reader, PrintWriter writer) {
        int testCases = reader.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = reader.nextInt();
            Pair<Integer, Integer>[] intervals = new Pair[n];
            for (int i = 0; i < n; i++) {
                int start = reader.nextInt();
                int end = reader.nextInt();
                intervals[i] = new Pair<>(start, end);
            }
            int[] cameron = new int[1441];
            int[] jamie = new int[1441];
            StringBuilder result = new StringBuilder();
            boolean possible = true;
            Arrays.fill(cameron, 0);
            Arrays.fill(jamie, 0);
            for (Pair<Integer, Integer> interval : intervals) {
                int start = interval.first;
                int end = interval.second;
                if (!hasOverlap(cameron, start, end)) {
                    Arrays.fill(cameron, start, end, 1);
                    result.append('C');
                } else if (!hasOverlap(jamie, start, end)) {
                    Arrays.fill(jamie, start, end, 1);
                    result.append('J');
                } else {
                    possible = false;
                    break;
                }
            }
            writer.printf("Case #%d: %s\n", t, possible ? result.toString() : "IMPOSSIBLE");
        }
    }
}

class FastReader {
    private final BufferedReader br;
    private StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

class Pair<U, V> {
    final U first;
    final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return first.equals(pair.first) && second.equals(pair.second);
    }

    @Override
    public int hashCode() {
        return 31 * first.hashCode() + second.hashCode();
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static <U, V> Pair<U, V> of(U a, V b) {
        return new Pair<>(a, b);
    }
}