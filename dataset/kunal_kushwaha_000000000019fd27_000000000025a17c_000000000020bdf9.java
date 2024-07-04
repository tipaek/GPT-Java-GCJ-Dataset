import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
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
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            for (int t = 1; t <= testNumber ; t++) {
                int n = in.nextInt();
                int[][] time = new int[n][2];
                for (int i = 0; i < n; i++) {
                    int a = in.nextInt();
                    int b = in.nextInt();
                    if (a < b) {
                        time[i][0] = a;
                        time[i][1] = b;
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
            for (Integer integer : a) {
                int startA = orignal[integer][0];
                int endA = orignal[integer][1];
                if (startA >= s) {
                    if (!(e <= startA)) {
                        return false;
                    }
                } else {
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
            reader = new BufferedReader(new InputStreamReader(stream));
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

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
