import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {
    private static InputReader inputReader;
    private static PrintWriter outputWriter;

    private static int queryPosition(int pos) {
        outputWriter.println(pos + 1);
        outputWriter.flush();
        return inputReader.nextInt();
    }

    public static void main(String[] args) {
        inputReader = new InputReader(System.in);
        outputWriter = new PrintWriter(System.out);

        int testCases = inputReader.nextInt();
        int bitLength = inputReader.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int[] bits = new int[bitLength];
            int left = 0, right = bitLength - 1;

            int sameIndex = -1, diffIndex = -1;
            for (int queryCount = 1; left <= right; queryCount += 2) {
                if (queryCount % 10 == 1) {
                    if (sameIndex != -1) {
                        if (bits[sameIndex] != queryPosition(sameIndex)) {
                            for (int i = 0, j = bitLength - 1; i < left; ++i, --j) {
                                bits[i] ^= 1;
                                bits[j] ^= 1;
                            }
                        }
                    } else {
                        queryPosition(0);
                    }
                    if (diffIndex != -1) {
                        if (bits[diffIndex] != queryPosition(diffIndex)) {
                            for (int i = 0, j = bitLength - 1; i < left; ++i, --j) {
                                bits[i] ^= 1;
                                bits[j] ^= 1;
                            }
                        }
                    } else {
                        queryPosition(0);
                    }
                    continue;
                }
                bits[left] = queryPosition(left);
                bits[right] = queryPosition(right);
                if (sameIndex == -1 && bits[left] == bits[right]) sameIndex = left;
                if (diffIndex == -1 && bits[left] != bits[right]) diffIndex = left;
                ++left;
                --right;
            }

            for (int i = 0; i < bitLength; ++i) {
                outputWriter.print(bits[i]);
            }
            outputWriter.print('\n');
            outputWriter.flush();
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