import java.io.*;
import java.util.*;

public class Solution {

    private String calculateResult(int x, int y, String directions) {
        int currentX = x;
        int currentY = y;
        int steps = 0;

        for (int i = 0; i < directions.length(); i++) {
            if (Math.abs(currentX) + Math.abs(currentY) <= steps) {
                return String.valueOf(steps);
            }

            char direction = directions.charAt(i);
            switch (direction) {
                case 'N':
                    currentY++;
                    break;
                case 'S':
                    currentY--;
                    break;
                case 'E':
                    currentX++;
                    break;
                case 'W':
                    currentX--;
                    break;
            }
            steps++;
        }

        if (Math.abs(currentX) + Math.abs(currentY) <= steps) {
            return String.valueOf(steps);
        }

        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        InputReader reader = new InputReader(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);

        int testCases = reader.nextInt();
        for (int i = 0; i < testCases; i++) {
            int x = reader.nextInt();
            int y = reader.nextInt();
            String directions = reader.next();

            printTestCase(writer, i + 1, new Solution().calculateResult(x, y, directions));
        }

        writer.close();
    }

    static void printTestCase(PrintWriter writer, int testCaseNumber, String result) {
        writer.println(String.format("Case #%d: %s", testCaseNumber, result));
    }

    static class InputReader {
        private BufferedReader bufferedReader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            bufferedReader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(bufferedReader.readLine());
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

        public int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        public long[] nextLongArray(int size) {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextLong();
            }
            return array;
        }

        public double[] nextDoubleArray(int size) {
            double[] array = new double[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextDouble();
            }
            return array;
        }
    }
}