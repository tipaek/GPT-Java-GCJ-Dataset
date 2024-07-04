import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            writer.print("Case #" + testCase + ": ");
            processTestCase(scanner, writer);
            writer.println();
        }
        writer.close();
    }

    private static void processTestCase(FastScanner scanner, PrintWriter writer) throws IOException {
        long x = scanner.nextLong();
        long y = scanner.nextLong();

        char[] horizontal = {'E', 'W'};
        char[] vertical = {'N', 'S'};
        
        if (x < 0) {
            swap(horizontal);
            x = -x;
        }
        if (y < 0) {
            swap(vertical);
            y = -y;
        }

        int[] binaryX = toBinary(x);
        int[] binaryY = toBinary(y);
        StringBuilder path = new StringBuilder();
        long step = 1;

        for (int i = 33; i >= 0; i--) {
            if (isInvalidMove(binaryX, binaryY, i)) {
                writer.print("IMPOSSIBLE");
                return;
            }

            if (binaryX[i] == 1) {
                path.append(horizontal[0]);
                x -= step;
            } else if (binaryY[i] == 1) {
                path.append(vertical[0]);
                y -= step;
            }

            if (x == 0 && y == 0) {
                writer.print(path);
                return;
            }

            binaryX = toBinary(x);
            binaryY = toBinary(y);
            step *= 2;
        }
        writer.print("IMPOSSIBLE");
    }

    private static boolean isInvalidMove(int[] binaryX, int[] binaryY, int index) {
        return (binaryX[index] == 1 && binaryX[index - 1] == 1 && binaryY[index] == 1 && binaryY[index - 1] == 1) ||
               (binaryX[index] == 0 && binaryX[index - 1] == 0 && binaryY[index] == 0 && binaryY[index - 1] == 0);
    }

    private static void swap(char[] array) {
        char temp = array[0];
        array[0] = array[1];
        array[1] = temp;
    }

    private static int[] toBinary(long number) {
        int[] binaryArray = new int[34];
        int index = 33;
        while (number > 0) {
            binaryArray[index--] = (int) (number % 2);
            number /= 2;
        }
        return binaryArray;
    }

    public static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextToken());
        }

        private String nextToken() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }
    }
}