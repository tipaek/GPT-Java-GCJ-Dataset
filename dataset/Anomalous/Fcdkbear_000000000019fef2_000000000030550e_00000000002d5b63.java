import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Solution {

    private static String query(int x, int y, PrintWriter out, InputReader in) {
        out.printf("%d %d\n", x, y);
        out.flush();
        return in.next();
    }

    private static int binarySearch(Function<Integer, Integer> xFunc, Function<Integer, Integer> yFunc, PrintWriter out, InputReader in) {
        int left = 0, right = 1000000000, result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int queryX = xFunc.apply(mid);
            int queryY = yFunc.apply(mid);
            String response = query(queryX, queryY, out, in);
            if (response.equals("HIT")) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        for (int t = 1; t <= testCases; ++t) {
            int left = -binarySearch(x -> -x, y -> 0, out, in);
            int right = binarySearch(x -> x, y -> 0, out, in);
            int upper = binarySearch(x -> 0, y -> y, out, in);
            int lower = -binarySearch(x -> 0, y -> -y, out, in);

            int guessX = (left + right) / 2;
            int guessY = (upper + lower) / 2;

            boolean found = false;
            for (int x = guessX - 5; x <= guessX + 5 && !found; ++x) {
                for (int y = guessY - 5; y <= guessY + 5; ++y) {
                    String response = query(x, y, out, in);
                    if (response.equals("CENTER")) {
                        found = true;
                        break;
                    }
                }
            }
        }
        out.close();
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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