import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {
    private static InputReader inputReader;
    private static PrintWriter printWriter;

    private static int ask(int position) {
        printWriter.println(position + 1);
        printWriter.flush();
        return inputReader.nextInt();
    }

    public static void main(String[] args) {
        inputReader = new InputReader(System.in);
        printWriter = new PrintWriter(System.out);

        int testCases = inputReader.nextInt();
        int bitLength = inputReader.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int[] result = new int[bitLength];
            int left = 0, right = bitLength - 1;

            int sameIndex = -1, differentIndex = -1;
            for (int i = 1; left <= right; i += 2) {
                if (i % 10 == 1) {
                    boolean flip = false, reverse = false;
                    if (sameIndex != -1) {
                        flip = result[sameIndex] != ask(sameIndex);
                    } else {
                        ask(0);
                    }
                    if (differentIndex != -1) {
                        reverse = result[differentIndex] != ask(differentIndex);
                    } else {
                        ask(0);
                    }
                    for (int a = 0, b = bitLength - 1; a < left; ++a, --b) {
                        if ((flip && result[a] == result[b]) || (reverse && result[a] != result[b])) {
                            result[a] ^= 1;
                            result[b] ^= 1;
                        }
                    }
                    continue;
                }
                result[left] = ask(left);
                result[right] = ask(right);
                if (sameIndex == -1 && result[left] == result[right]) sameIndex = left;
                if (differentIndex == -1 && result[left] != result[right]) differentIndex = left;
                ++left;
                --right;
            }

            for (int i = 0; i < bitLength; ++i) {
                printWriter.print(result[i]);
            }
            printWriter.print('\n');
            printWriter.flush();
            inputReader.next();
        }
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public BigInteger nextBigInteger() {
            return new BigInteger(next());
        }

        public BigDecimal nextBigDecimal() {
            return new BigDecimal(next());
        }
    }
}