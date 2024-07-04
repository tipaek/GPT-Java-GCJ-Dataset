import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {
    private static InputReader in;
    private static PrintWriter out;

    private static int query(int position) {
        out.println(position + 1);
        out.flush();
        return in.nextInt();
    }

    public static void main(String[] args) {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);

        int testCases = in.nextInt();
        int bitLength = in.nextInt();

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int[] result = new int[bitLength];
            int left = 0, right = bitLength - 1;

            int sameIndex = -1, differentIndex = -1;
            for (int i = 1; left <= right; i += 2) {
                if (i % 10 == 1) {
                    boolean flip = false, reverse = false;
                    if (sameIndex != -1) {
                        flip = result[sameIndex] != query(sameIndex);
                    } else {
                        query(0);
                    }
                    if (differentIndex != -1) {
                        reverse = result[differentIndex] != query(differentIndex);
                    } else {
                        query(0);
                    }
                    for (int a = 0, b = bitLength - 1; a < left; ++a, --b) {
                        if ((flip && result[a] == result[b]) || (reverse && result[a] != result[b])) {
                            result[a] ^= 1;
                            result[b] ^= 1;
                        }
                    }
                    continue;
                }
                result[left] = query(left);
                result[right] = query(right);
                if (sameIndex == -1 && result[left] == result[right]) sameIndex = left;
                if (differentIndex == -1 && result[left] != result[right]) differentIndex = left;
                ++left;
                --right;
            }

            for (int i = 0; i < bitLength; ++i) {
                out.print(result[i]);
            }
            out.println();
            out.flush();
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