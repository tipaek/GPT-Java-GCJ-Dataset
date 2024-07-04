import java.io.*;
import java.util.*;

public class Solution {
    static InputStream inputStream;
    static PrintWriter out;
    static InputReader in;
    static int test;

    static void solve() throws Exception {
        int rows = in.nextInt();
        int cols = in.nextInt();
        int[] values = new int[rows * cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                values[i * cols + j] = in.nextInt();
            }
        }

        int[] nextValues = Arrays.copyOf(values, rows * cols);
        int totalInterest = calculateInterest(values, rows * cols);
        int eliminated;
        
        do {
            eliminated = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (values[i * cols + j] != Integer.MAX_VALUE) {
                        int neighborSum = 0;
                        int neighborCount = 0;

                        int t = 1;
                        while (i - t >= 0 && values[(i - t) * cols + j] == Integer.MAX_VALUE) t++;
                        if (i - t >= 0) {
                            neighborSum += values[(i - t) * cols + j];
                            neighborCount++;
                        }

                        t = 1;
                        while (i + t < rows && values[(i + t) * cols + j] == Integer.MAX_VALUE) t++;
                        if (i + t < rows) {
                            neighborSum += values[(i + t) * cols + j];
                            neighborCount++;
                        }

                        t = 1;
                        while (j - t >= 0 && values[i * cols + j - t] == Integer.MAX_VALUE) t++;
                        if (j - t >= 0) {
                            neighborSum += values[i * cols + j - t];
                            neighborCount++;
                        }

                        t = 1;
                        while (j + t < cols && values[i * cols + j + t] == Integer.MAX_VALUE) t++;
                        if (j + t < cols) {
                            neighborSum += values[i * cols + j + t];
                            neighborCount++;
                        }

                        if (values[i * cols + j] * neighborCount < neighborSum) {
                            nextValues[i * cols + j] = Integer.MAX_VALUE;
                            eliminated++;
                        }
                    }
                }
            }
            values = Arrays.copyOf(nextValues, rows * cols);
            if (eliminated > 0) {
                totalInterest += calculateInterest(values, rows * cols);
            }
        } while (eliminated > 0);
        
        out.println(totalInterest);
    }

    static int calculateInterest(int[] array, int length) {
        int interest = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] != Integer.MAX_VALUE) {
                interest += array[i];
            }
        }
        return interest;
    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    public static void main(String[] args) {
        try {
            inputStream = System.in;
            out = new PrintWriter(System.out);
            in = new InputReader(inputStream);

            int testCases = in.nextInt();
            for (test = 1; test <= testCases; test++) {
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
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String str = reader.readLine();
                    if (str == null) return "";
                    tokenizer = new StringTokenizer(str);
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