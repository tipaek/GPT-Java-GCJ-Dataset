import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    private void findCenter(InputReader in, PrintWriter out, int a, int b) {
        for (int i = -7; i <= 7; i++) {
            for (int j = -7; j <= 7; j++) {
                sendOutput(out, i + " " + j);

                String response = in.next();
                if (response.equals("CENTER")) {
                    return;
                }
            }
        }
    }

    private void sendOutput(PrintWriter out, String message) {
        out.println(message);
        out.flush();
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader inputReader = new InputReader(inputStream);
        PrintWriter outputWriter = new PrintWriter(outputStream, true);

        int testCases = inputReader.nextInt();
        int a = inputReader.nextInt();
        int b = inputReader.nextInt();
        
        Solution solution = new Solution();
        for (int i = 0; i < testCases; i++) {
            solution.findCenter(inputReader, outputWriter, a, b);
        }

        outputWriter.close();
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }

        public double[] nextDoubleArray(int n) {
            double[] array = new double[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextDouble();
            }
            return array;
        }
    }
}