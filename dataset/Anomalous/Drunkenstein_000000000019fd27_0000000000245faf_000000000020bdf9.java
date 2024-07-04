import java.io.*;
import java.util.*;

public class Solution {
    static InputStream inputStream;
    static PrintWriter out;
    static InputReader in;
    static int test;

    static void solve() throws Exception {
        int n = in.nextInt();
        List<Tree> trees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            trees.add(new Tree(start, end, i));
        }

        Collections.sort(trees);
        int[] assignments = new int[n];
        assignments[0] = 1;
        Tree jim = trees.get(0);
        Tree tim = null;

        for (int i = 1; i < n; i++) {
            if (trees.get(i).start >= jim.end) {
                jim = trees.get(i);
                assignments[i] = 1;
            } else if (tim == null || trees.get(i).start >= tim.end) {
                tim = trees.get(i);
                assignments[i] = 2;
            } else {
                out.println("IMPOSSIBLE");
                return;
            }
        }

        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            result[trees.get(i).num] = (assignments[i] == 1) ? 'J' : 'C';
        }

        out.println(new String(result));
    }

    static class Tree implements Comparable<Tree> {
        int start;
        int end;
        int num;

        Tree(int start, int end, int num) {
            this.start = start;
            this.end = end;
            this.num = num;
        }

        @Override
        public int compareTo(Tree other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    public static void main(String[] args) {
        try {
            inputStream = System.in;
            out = new PrintWriter(System.out);
            in = new InputReader(inputStream);

            int tests = in.nextInt();
            for (test = 1; test <= tests; test++) {
                printCase();
                solve();
            }
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String str = reader.readLine();
                    if (str == null) {
                        return "";
                    }
                    tokenizer = new StringTokenizer(str);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}