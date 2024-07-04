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
    public boolean doesOverlap(int[] ar, int s, int e) {
        for (int i = s; i < e; i++) {
            if (ar[i] == 1) {
                return true;
            }
        }
        return false;
    }

    public void solve(FastReader in, OutputWriter out) {
        int t = in.nextInt();
        for (int ca = 1; ca <= t; ca++) {
            int n = in.nextInt();
            Pair<Integer, Integer>[] intervals = new Pair[n];
            Map<Pair<Integer, Integer>, Integer> indexMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                intervals[i] = new Pair<>(start, end);
                indexMap.put(intervals[i], i);
            }

            char[] result = new char[n];
            Arrays.sort(intervals, Comparator.comparingInt((Pair<Integer, Integer> p) -> p.first)
                    .thenComparingInt(p -> p.second));

            boolean possible = true;
            Set<Integer> setC = new HashSet<>();
            Set<Integer> setJ = new HashSet<>();
            int lastC = -1, lastJ = -1;

            for (int i = 0; i < n; i++) {
                if (lastC == -1 || intervals[i].first >= intervals[lastC].second) {
                    setC.add(i);
                    lastC = i;
                } else if (lastJ == -1 || intervals[i].first >= intervals[lastJ].second) {
                    setJ.add(i);
                    lastJ = i;
                } else {
                    possible = false;
                    break;
                }
            }

            out.print("Case #" + ca + ": ");
            if (!possible) {
                out.print("IMPOSSIBLE");
            } else {
                for (int i : setC) {
                    result[indexMap.get(intervals[i])] = 'C';
                }
                for (int i : setJ) {
                    result[indexMap.get(intervals[i])] = 'J';
                }
                out.print(new String(result));
            }
            out.println();
        }
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