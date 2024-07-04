import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        OutputWriter out = new OutputWriter(System.out);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
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

    public void solve(FastReader in, OutputWriter out) {
        int t = in.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = in.nextInt();
            Pair<Integer, Integer>[] intervals = new Pair[n];
            Map<Pair<Integer, Integer>, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                intervals[i] = new Pair<>(start, end);
                indexMap.put(intervals[i], i);
            }

            Arrays.sort(intervals, Comparator.comparingInt((Pair<Integer, Integer> p) -> p.first)
                    .thenComparingInt(p -> p.second));

            int[] cameronSchedule = new int[1441];
            int[] jamieSchedule = new int[1441];
            Arrays.fill(cameronSchedule, 0);
            Arrays.fill(jamieSchedule, 0);

            char[] result = new char[n];
            boolean isPossible = true;

            for (Pair<Integer, Integer> interval : intervals) {
                int start = interval.first;
                int end = interval.second;
                int index = indexMap.get(interval);

                if (!hasOverlap(cameronSchedule, start, end)) {
                    Arrays.fill(cameronSchedule, start, end, 1);
                    result[index] = 'C';
                } else if (!hasOverlap(jamieSchedule, start, end)) {
                    Arrays.fill(jamieSchedule, start, end, 1);
                    result[index] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }

            out.print("Case #" + caseNum + ": ");
            if (isPossible) {
                out.print(new String(result));
            } else {
                out.print("IMPOSSIBLE");
            }
            out.println();
        }
    }
}

class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
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
        String line = "";
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}

class OutputWriter extends PrintWriter {
    public OutputWriter(OutputStream outputStream) {
        super(new BufferedWriter(new OutputStreamWriter(outputStream)));
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

    public static <U, V> Pair<U, V> of(U first, V second) {
        return new Pair<>(first, second);
    }
}