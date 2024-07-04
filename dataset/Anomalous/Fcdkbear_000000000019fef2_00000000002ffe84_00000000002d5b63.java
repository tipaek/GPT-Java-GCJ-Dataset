import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Solution {

    private static String query(int queryX, int queryY, PrintWriter out, InputReader in) {
        out.printf("%d %d\n", queryX, queryY);
        out.flush();
        return in.next();
    }

    private static int search(Function<Integer, Integer> xFunction, Function<Integer, Integer> yFunction, PrintWriter out, InputReader in) {
        int left = 999999900;
        int right = 1000000000;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int queryX = xFunction.apply(mid);
            int queryY = yFunction.apply(mid);
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
        
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int leftBoundary = -search(x -> -x, y -> 0, out, in);
            int rightBoundary = search(x -> x, y -> 0, out, in);
            int upperBoundary = search(x -> 0, y -> y, out, in);
            int lowerBoundary = -search(x -> 0, y -> -y, out, in);
            
            int guessX = (leftBoundary + rightBoundary) / 2;
            int guessY = (upperBoundary + lowerBoundary) / 2;
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