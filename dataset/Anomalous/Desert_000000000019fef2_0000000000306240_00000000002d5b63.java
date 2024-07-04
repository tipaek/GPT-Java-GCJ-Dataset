import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    private void findCenter(InputReader in, PrintWriter out, long a, long b) {
        final long radius = binarySearchRadius(in, out);

        boolean isCenterBelow = false;
        for (int i = 0; i < 20; i++) {
            query(out, radius, -i);
            String response = in.next();
            if (response.equals("HIT")) {
                query(out, radius + 1, -i);
                if (in.next().equals("HIT")) {
                    isCenterBelow = true;
                    break;
                }
            } else if (response.equals("MISS")) {
                isCenterBelow = false;
                break;
            } else {
                throw new IllegalStateException();
            }
        }

        if (isCenterBelow) {
            locateCenter(in, out, radius, -1, a, b);
        } else {
            locateCenter(in, out, radius, 1, a, b);
        }
    }

    private long binarySearchRadius(InputReader in, PrintWriter out) {
        long low = 0;
        long high = 1_000_000_002;

        while (low < high) {
            long mid = (low + high + 1) / 2;
            if (isWithinBoundary(in, out, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean isWithinBoundary(InputReader in, PrintWriter out, long distance) {
        query(out, distance, 0);
        String response = in.next();
        if (response.equals("HIT")) {
            return true;
        } else if (response.equals("MISS")) {
            return false;
        } else {
            throw new IllegalStateException();
        }
    }

    private void locateCenter(InputReader in, PrintWriter out, long startX, int direction, long a, long b) {
        long currentX = startX;
        long finalX = startX;
        long finalY = 0;
        for (int i = 0; i < 60; i++) {
            query(out, currentX, i * direction);
            String response = in.next();
            if (response.equals("MISS")) {
                break;
            }
            while (response.equals("HIT")) {
                finalX = currentX;
                finalY = i * direction;
                currentX++;
                query(out, currentX, i * direction);
                response = in.next();
            }
        }
        query(out, finalX - a, finalY);
        if (!in.next().equals("CENTER")) {
            throw new IllegalStateException();
        }
    }

    private void query(PrintWriter out, long x, long y) {
        out.println(x + " " + y);
        out.flush();
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream, true);

        int testCount = in.nextInt();
        long a = in.nextLong();
        long b = in.nextLong();
        for (int i = 0; i < testCount; i++) {
            new Solution().findCenter(in, out, a, b);
        }

        out.close();
    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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