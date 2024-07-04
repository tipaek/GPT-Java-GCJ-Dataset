import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    private void findAnswer(InputReader in, PrintWriter out, long a, long b) {
        final long radius = binarySearch(in, out);

        boolean isCenterBelow = false;
        for (int i = 0; i < 20; i++) {
            sendCoordinates(out, radius, -i);

            String response = in.next();
            if (response.equals("HIT")) {
                sendCoordinates(out, radius + 1, -i);

                String secondResponse = in.next();
                if (secondResponse.equals("HIT")) {
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
            long current = radius;
            long resultX = radius;
            long resultY = 0;
            for (int i = 0; i < 60; i++) {
                sendCoordinates(out, current, -i);
                String response = in.next();

                if (response.equals("MISS")) {
                    break;
                }

                while (response.equals("HIT")) {
                    resultX = current;
                    resultY = -i;

                    current++;

                    sendCoordinates(out, current, -i);
                    response = in.next();
                }
            }

            sendCoordinates(out, resultX - a, resultY);
            String response = in.next();

            if (!response.equals("CENTER")) {
                return;
            }
        } else {
            long current = radius;
            long resultX = radius;
            long resultY = 0;
            for (int i = 0; i < 60; i++) {
                sendCoordinates(out, current, i);
                String response = in.next();

                if (response.equals("MISS")) {
                    break;
                }

                while (response.equals("HIT")) {
                    resultX = current;
                    resultY = i;

                    current++;

                    sendCoordinates(out, current, i);
                    response = in.next();
                }
            }

            sendCoordinates(out, resultX - a, resultY);
            String response = in.next();

            if (!response.equals("CENTER")) {
                return;
            }
        }
    }

    private long binarySearch(InputReader in, PrintWriter out) {
        long low = 0;
        long high = 1_000_000_002;

        while (low < high) {
            long mid = (low + high + 1) / 2;

            if (isHit(in, out, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean isHit(InputReader in, PrintWriter out, long current) {
        sendCoordinates(out, current, 0);

        String response = in.next();
        if (response.equals("HIT")) {
            return true;
        } else if (response.equals("MISS")) {
            return false;
        } else {
            throw new IllegalStateException();
        }
    }

    private void sendCoordinates(PrintWriter out, long x, long y) {
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
            new Solution().findAnswer(in, out, a, b);
        }

        out.close();
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextInt();
            }
            return arr;
        }

        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextLong();
            }
            return arr;
        }

        public double[] nextDoubleArray(int n) {
            double[] arr = new double[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextDouble();
            }
            return arr;
        }
    }
}