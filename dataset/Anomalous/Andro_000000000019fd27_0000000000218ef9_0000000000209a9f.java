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
            String s = in.nextLine();
            int n = s.length();
            int[] ar = new int[n];
            int max = Integer.MIN_VALUE;
            int index = 0;

            for (int i = 0; i < n; i++) {
                ar[i] = s.charAt(i) - '0';
                if (ar[i] > max) {
                    max = ar[i];
                    index = i;
                }
            }

            String[] res = new String[n + 1];
            int max1 = max;

            for (int i = 0; i <= index; i++) {
                StringBuilder st = new StringBuilder();
                if (i == 0) {
                    st.append("(".repeat(max));
                } else if (ar[i - 1] < ar[i]) {
                    int diff = ar[i] - ar[i - 1];
                    st.append("(".repeat(diff));
                    max -= diff;
                } else {
                    int diff = ar[i - 1] - ar[i];
                    st.append(")".repeat(diff));
                    max += diff;
                }
                res[i] = st.toString();
            }

            for (int i = index + 1; i < n; i++) {
                StringBuilder st = new StringBuilder();
                if (i == n - 1) {
                    st.append(")".repeat(max1));
                } else if (ar[i] > ar[i + 1]) {
                    int diff = ar[i] - ar[i + 1];
                    st.append(")".repeat(diff));
                    max1 -= diff;
                } else {
                    int diff = ar[i + 1] - ar[i];
                    st.append("(".repeat(diff));
                    max1 += diff;
                }
                res[i + 1] = st.toString();
            }

            out.print("Case #" + ca + ": ");
            for (int i = 0; i < n; i++) {
                out.print(res[i] + ar[i]);
            }
            out.println(res[n]);
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