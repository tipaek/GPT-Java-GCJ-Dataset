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
    public boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }

    public char getAlternatePerson(char current) {
        return current == 'J' ? 'C' : 'J';
    }

    public void solve(FastReader in, OutputWriter out) {
        int t = in.nextInt();
        for (int ca = 1; ca <= t; ca++) {
            int n = in.nextInt();
            int[][] intervals = new int[n][2];
            Map<int[], Integer> indexMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                intervals[i][0] = start;
                intervals[i][1] = end;
                indexMap.put(intervals[i], i);
            }
            char[] result = new char[n];
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            boolean impossible = false;
            Stack<int[]> cStack = new Stack<>();
            Stack<int[]> jStack = new Stack<>();
            char currentPerson = 'J';

            for (int i = 0; i < n; i++) {
                result[indexMap.get(intervals[i])] = currentPerson;
                if (i < n - 1 && doesOverlap(intervals[i], intervals[i + 1])) {
                    if (currentPerson == 'J') {
                        jStack.push(intervals[i]);
                        currentPerson = getAlternatePerson(currentPerson);
                        if (!cStack.isEmpty() && doesOverlap(cStack.peek(), intervals[i + 1])) {
                            impossible = true;
                            break;
                        }
                    } else {
                        cStack.push(intervals[i]);
                        currentPerson = getAlternatePerson(currentPerson);
                        if (!jStack.isEmpty() && doesOverlap(jStack.peek(), intervals[i + 1])) {
                            impossible = true;
                            break;
                        }
                    }
                } else {
                    if (currentPerson == 'J') {
                        jStack.push(intervals[i]);
                    } else {
                        cStack.push(intervals[i]);
                    }
                }
            }
            out.println("Case #" + ca + ": " + (impossible ? "IMPOSSIBLE" : new String(result)));
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
    private final U first;
    private final V second;

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