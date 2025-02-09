import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int t = in.nextInt();
        solver.solve(t, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
            for (int t = 1; t <= testNumber ; t++) {
                int n = in.nextInt();
                int[][] time = new int[n][2];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < 2; j++) {
                        time[i][j] = in.nextInt();
                    }
                }
                ArrayList<Integer> c = new ArrayList<>();
                ArrayList<Integer> j = new ArrayList<>();
                c.add(0);
                StringBuilder builder = new StringBuilder();
                builder.append("C");
                for (int i = 1; i < n; i++) {
                    int currentS = time[i][0];
                    int currentE = time[i][1];
                    if (check(c, currentS, currentE, time)) {
                        builder.append("C");
                        c.add(i);
                    } else if(check(j, currentS, currentE, time)) {
                        builder.append("J");
                        j.add(i);
                    }
                }
                String ans = builder.toString();
                if (ans.length() != n) {
                    ans = "IMPOSSIBLE";
                }
                out.println("Case #" + t + ": " + ans);
            }
        }
        public static boolean check(ArrayList<Integer> a, int s, int e, int[][] orignal) {
            for (int i = 0; i < a.size(); i++) {
                int startA = orignal[a.get(i)][0];
                int endA = orignal[a.get(i)][1];
                if (startA >= s) {
                    if (!(e <= startA)) {
                        return false;
                    }
                }else {
                    if (!(endA <= s)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public char nextChar() {
            return next().charAt(0);
        }

        public String nextLine() throws IOException {
            return reader.readLine().trim();
        }
    }
}
