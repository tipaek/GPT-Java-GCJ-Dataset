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
                int s = in.nextInt();
                int e = in.nextInt();
                intervals[i] = new Pair<>(s, e);
                indexMap.put(intervals[i], i);
            }
            char[] result = new char[n];
            Arrays.sort(intervals, Comparator.comparingInt(p -> p.first));
            boolean isPossible = true;
            Set<Integer> cSet = new HashSet<>();
            Set<Integer> jSet = new HashSet<>();
            cSet.add(0);
            int prevC = 0;
            for (int i = 1; i < n; i++) {
                if (intervals[i].first >= intervals[prevC].second) {
                    cSet.add(i);
                    prevC = i;
                }
            }
            int prevJ = -1;
            for (int i = 0; i < n; i++) {
                if (cSet.contains(i)) {
                    continue;
                }
                if (prevJ == -1 || intervals[i].first >= intervals[prevJ].second) {
                    jSet.add(i);
                    prevJ = i;
                } else {
                    isPossible = false;
                    break;
                }
            }
            out.print("Case #" + ca + ": ");
            if (!isPossible) {
                out.print("IMPOSSIBLE");
            } else {
                for (int k : cSet) {
                    result[indexMap.get(intervals[k])] = 'C';
                }
                for (int k : jSet) {
                    result[indexMap.get(intervals[k])] = 'J';
                }
                for (char c : result) {
                    out.print(c);
                }
            }
            out.println();
        }
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    FastReader() {
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