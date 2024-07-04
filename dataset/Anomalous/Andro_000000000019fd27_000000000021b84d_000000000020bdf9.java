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
    public void solve(FastReader in, OutputWriter out) {
        int t = in.nextInt();
        for (int ca = 1; ca <= t; ca++) {
            int n = in.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = in.nextInt();
                intervals[i][1] = in.nextInt();
            }
            Interval cInterval = new Interval(-1, -1);
            Interval jInterval = new Interval(-1, -1);
            StringBuilder result = new StringBuilder();
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                Interval current = new Interval(intervals[i][0], intervals[i][1]);
                if (!current.overlaps(cInterval)) {
                    result.append('C');
                    cInterval = current;
                } else if (!current.overlaps(jInterval)) {
                    result.append('J');
                    jInterval = current;
                } else {
                    possible = false;
                    break;
                }
            }
            out.print("Case #" + ca + ": ");
            if (possible) {
                out.print(result.toString());
            } else {
                out.print("IMPOSSIBLE");
            }
            out.println();
        }
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean overlaps(Interval other) {
        return !(this.end <= other.start || this.start >= other.end);
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

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