import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    private static InputReader inputReader;
    private static PrintWriter printWriter;

    private static int query(int position) {
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

            int sameIndex = -1, diffIndex = -1;
            for (int i = 1; left <= right; i += 2) {
                if (i % 10 == 1) {
                    if (sameIndex != -1) {
                        if (result[sameIndex] != query(sameIndex)) {
                            for (int a = 0, b = bitLength - 1; a < left; ++a, --b) {
                                result[a] ^= 1;
                                result[b] ^= 1;
                            }
                        }
                    } else {
                        query(0);
                    }
                    if (diffIndex != -1) {
                        if (result[diffIndex] != query(diffIndex)) {
                            for (int a = 0, b = bitLength - 1; a < left; ++a, --b) {
                                result[a] ^= 1;
                                result[b] ^= 1;
                            }
                        }
                    } else {
                        query(0);
                    }
                    continue;
                }
                result[left] = query(left);
                result[right] = query(right);
                if (sameIndex == -1 && result[left] == result[right]) sameIndex = left;
                if (diffIndex == -1 && result[left] != result[right]) diffIndex = left;
                ++left;
                --right;
            }

            for (int i = 0; i < bitLength; ++i) {
                printWriter.print(result[i]);
            }
            printWriter.println();
            printWriter.flush();
        }
    }

    static class InputReader {
        private BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public InputReader(InputStream stream) {
            bufferedReader = new BufferedReader(new InputStreamReader(stream), 32768);
            stringTokenizer = null;
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return stringTokenizer.nextToken();
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