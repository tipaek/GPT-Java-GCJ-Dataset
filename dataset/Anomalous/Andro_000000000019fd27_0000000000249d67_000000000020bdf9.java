import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        OutputWriter writer = new OutputWriter(System.out);
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

    public void solve(FastReader reader, OutputWriter writer) {
        int testCases = reader.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = reader.nextInt();
            Pair<Integer, Integer>[] intervals = new Pair[n];
            Map<Pair<Integer, Integer>, Integer> indexMap = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                int start = reader.nextInt();
                int end = reader.nextInt();
                intervals[i] = new Pair<>(start, end);
                indexMap.put(intervals[i], i);
            }

            Arrays.sort(intervals, Comparator.comparingInt(p -> p.second));

            int[] cameron = new int[1441];
            int[] jamie = new int[1441];
            Arrays.fill(cameron, 0);
            Arrays.fill(jamie, 0);
            char[] result = new char[n];
            boolean possible = true;

            for (Pair<Integer, Integer> interval : intervals) {
                if (!hasOverlap(cameron, interval.first, interval.second)) {
                    Arrays.fill(cameron, interval.first, interval.second, 1);
                    result[indexMap.get(interval)] = 'C';
                } else if (!hasOverlap(jamie, interval.first, interval.second)) {
                    Arrays.fill(jamie, interval.first, interval.second, 1);
                    result[indexMap.get(interval)] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            writer.print("Case #" + t + ": ");
            if (possible) {
                writer.print(new String(result));
            } else {
                writer.print("IMPOSSIBLE");
            }
            writer.println();
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

class OutputWriter extends PrintWriter {
    public OutputWriter(OutputStream outputStream) {
        super(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }
}

class Pair<U, V> {
    final U first;
    final V second;

    Pair(U first, V second) {
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