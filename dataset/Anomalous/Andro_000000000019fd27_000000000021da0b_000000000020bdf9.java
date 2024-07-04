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
    private boolean isOverlap(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) {
                return true;
            }
        }
        return false;
    }

    public void solve(FastReader in, OutputWriter out) {
        int testCases = in.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = in.nextInt();
            Pair<Integer, Integer>[] intervals = new Pair[n];
            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                intervals[i] = new Pair<>(start, end);
            }

            int[] camSchedule = new int[1500];
            int[] jamSchedule = new int[1500];
            StringBuilder result = new StringBuilder();
            boolean possible = true;
            Arrays.fill(camSchedule, 0);
            Arrays.fill(jamSchedule, 0);

            for (int i = 0; i < n; i++) {
                if (!isOverlap(camSchedule, intervals[i].first, intervals[i].second)) {
                    Arrays.fill(camSchedule, intervals[i].first, intervals[i].second, 1);
                    result.append('C');
                } else if (!isOverlap(jamSchedule, intervals[i].first, intervals[i].second)) {
                    Arrays.fill(jamSchedule, intervals[i].first, intervals[i].second, 1);
                    result.append('J');
                } else {
                    possible = false;
                    break;
                }
            }

            out.print("Case #" + caseNum + ": ");
            if (possible) {
                out.print(result.toString());
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
    public final U first;
    public final V second;

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