import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Solution {

    private static String query(int queryX, int queryY, PrintWriter out, InputReader in) {
        out.printf("%d %d\n", queryX, queryY);
        out.flush();
        return in.next();
    }

    private static int search(Function<Integer, Integer> xFunction, Function<Integer, Integer> yFunction, PrintWriter out, InputReader in) {
        int l = 1000000000 - 100;
        int r = 1000000000;
        int res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            int queryX = xFunction.apply(m);
            int queryY = yFunction.apply(m);;
            String s = query(queryX, queryY, out, in);
            if (s.equals("HIT")) {
                res = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int tests = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        for (int testNumber = 1; testNumber <= tests; ++testNumber) {
            int l = -search(x -> -x, y -> 0, out, in);
            int r = search(x -> x, y -> 0, out, in);
            int u = search(x -> 0, y -> y, out, in);
            int d = -search(x -> 0, y -> -y, out, in);
            int guessX = (l + r) / 2;
            int guessY = (u + d) / 2;
            boolean found = false;
            for (int x = guessX - 5; x <= guessX + 5; ++x) {
                if (found) {
                    break;
                }
                for (int y = guessY - 5; y <= guessY + 5; ++y) {
                    String s = query(x, y, out, in);
                    if (s.equals("CENTER")) {
                        found = true;
                        break;
                    }
                }
            }
        }
        out.close();

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

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }


    }
}
