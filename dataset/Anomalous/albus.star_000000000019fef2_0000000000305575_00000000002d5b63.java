import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputReader input = new InputReader(System.in);
        PrintWriter output = new PrintWriter(System.out);
        int testCaseCount = input.nextInt();
        int A = input.nextInt();
        int B = input.nextInt();
        
        for (int testNumber = 1; testNumber <= testCaseCount; testNumber++) {
            output.print("Case #" + testNumber + ": ");
            solve(input, output, A, B);
            output.println();
        }
        output.close();
    }

    private static void solve(InputReader input, PrintWriter output, int A, int B) throws IOException {
        for (int x = -5; x <= 5; x++) {
            for (int y = -5; y <= 5; y++) {
                System.out.println(x + " " + y);
                System.out.flush();
                String response = input.next();
                if ("CENTER".equals(response)) {
                    return;
                }
            }
        }
    }

    private static int[] toBinary(long number) {
        int[] binaryRepresentation = new int[34];
        int index = 33;
        while (number > 0) {
            binaryRepresentation[index--] = (int) (number % 2);
            number /= 2;
        }
        return binaryRepresentation;
    }

    private static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            ensureTokenizer();
            return Integer.parseInt(tokenizer.nextToken());
        }

        public long nextLong() throws IOException {
            ensureTokenizer();
            return Long.parseLong(tokenizer.nextToken());
        }

        public String next() throws IOException {
            ensureTokenizer();
            return tokenizer.nextToken();
        }

        private void ensureTokenizer() throws IOException {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
        }
    }
}