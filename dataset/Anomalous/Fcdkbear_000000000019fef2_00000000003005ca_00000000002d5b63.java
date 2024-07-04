import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Solution {

    private static String query(int x, int y, PrintWriter out, InputReader in) {
        out.printf("%d %d\n", x, y);
        out.flush();
        return in.next();
    }

    private static int binarySearch(Function<Integer, Integer> xFunc, Function<Integer, Integer> yFunc, PrintWriter out, InputReader in) {
        int left = 1000000000 - 1000000;
        int right = 1000000000;
        int result = -1;
        
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
        
        for (int t = 1; t <= testCases; t++) {
            int left = -binarySearch(x -> -x, y -> 0, out, in);
            int right = binarySearch(x -> x, y -> 0, out, in);
            int up = binarySearch(x -> 0, y -> y, out, in);
            int down = -binarySearch(x -> 0, y -> -y, out, in);
            
            int centerX = (left + right) / 2;
            int centerY = (up + down) / 2;
            boolean found = false;
            
            for (int x = centerX - 5; x <= centerX + 5 && !found; x++) {
                for (int y = centerY - 5; y <= centerY + 5 && !found; y++) {
                    String response = query(x, y, out, in);
                    if (response.equals("CENTER")) {
                        found = true;
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