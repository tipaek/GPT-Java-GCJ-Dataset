import java.io.*;
import java.util.*;

public class Solution {

    public static FastReader fr = new FastReader();
    public static OutputWriter op = new OutputWriter();

    public static void main(String[] args) throws IOException {
        int T = fr.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            int N = fr.nextInt();
            int Q = fr.nextInt();
            String S = fr.next();
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < N; j++) {
                    if (fr.nextInt() != 1) {
                        return;
                    }
                }
            }

            int[][] P = new int[Q][2];
            for (int i = 0; i < Q; i++) {
                P[i][0] = fr.nextInt();
            }
            for (int i = 0; i < Q; i++) {
                P[i][1] = fr.nextInt();
            }

            Stack<Integer> stack = new Stack<>();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                if (S.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    int j = stack.pop();
                    A[i] = j;
                    A[j] = i;
                }
            }

            long ans = 0;
            for (int i = 0; i < Q; i++) {
                ans += calculateMinOperations(P[i][0] - 1, P[i][1] - 1, A);
            }

            System.out.println("Case #" + cs + ": " + ans);
        }
    }

    private static long calculateMinOperations(int s, int e, int[] a) {
        if (s > e) {
            int temp = s;
            s = e;
            e = temp;
        }

        int minOperations = e - s;
        int currentOperations = 0;
        for (int i = s; i < e;) {
            if (a[i] > i && a[i] <= e) {
                i = a[i];
                currentOperations++;
                continue;
            }
            if (a[i] > i && a[i] > e) {
                minOperations = Math.min(minOperations, currentOperations + 1 + a[i] - e);
            }
            i++;
            currentOperations++;
        }

        if (i == e) {
            minOperations = Math.min(minOperations, currentOperations);
        }

        return minOperations;
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }

    static class FastReader {
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
}