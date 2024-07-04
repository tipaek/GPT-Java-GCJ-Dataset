import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {
    private static InputReader input;
    private static PrintWriter output;

    private static int query(int position) {
        output.println(position);
        output.flush();
        return input.nextInt();
    }

    public static void main(String[] args) {
        input = new InputReader(System.in);
        output = new PrintWriter(System.out);

        int testCases = input.nextInt();
        int bitLength = input.nextInt();

        for (int t = 1; t <= testCases; ++t) {
            int[] resultArray = new int[bitLength];
            int left = 0, right = bitLength - 1;
            int sameIndex = -1, diffIndex = -1;

            for (int i = 1; left <= right; i += 2) {
                if (i % 10 == 1) {
                    boolean flip = false, reverse = false;

                    if (sameIndex != -1) {
                        flip = resultArray[sameIndex] != query(sameIndex);
                    } else {
                        query(0);
                    }

                    if (diffIndex != -1) {
                        if (flip) {
                            reverse = resultArray[diffIndex] == query(diffIndex);
                        } else {
                            reverse = resultArray[diffIndex] != query(diffIndex);
                        }
                    } else {
                        query(0);
                    }

                    for (int a = 0, b = bitLength - 1; a < left; ++a, --b) {
                        if (flip) {
                            resultArray[a] ^= 1;
                            resultArray[b] ^= 1;
                        }
                        if (reverse) {
                            int temp = resultArray[a];
                            resultArray[a] = resultArray[b];
                            resultArray[b] = temp;
                        }
                    }
                    continue;
                }

                resultArray[left] = query(left);
                resultArray[right] = query(right);

                if (sameIndex == -1 && resultArray[left] == resultArray[right]) {
                    sameIndex = left;
                }
                if (diffIndex == -1 && resultArray[left] != resultArray[right]) {
                    diffIndex = left;
                }

                ++left;
                --right;
            }

            for (int i = 0; i < bitLength; ++i) {
                output.print(resultArray[i]);
            }
            output.println();
            output.flush();
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