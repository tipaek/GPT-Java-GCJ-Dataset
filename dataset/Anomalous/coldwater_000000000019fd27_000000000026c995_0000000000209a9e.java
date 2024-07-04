import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {
    private static InputReader inputReader;
    private static PrintWriter outputWriter;

    private static int query(int position) {
        outputWriter.println(position + 1);
        outputWriter.flush();
        return inputReader.nextInt();
    }

    public static void main(String[] args) {
        inputReader = new InputReader(System.in);
        outputWriter = new PrintWriter(System.out);

        int testCases = inputReader.nextInt();
        int bitLength = inputReader.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int[] result = new int[bitLength];
            int leftPointer = 0, rightPointer = bitLength - 1;

            int sameIndex = -1, differentIndex = -1;
            for (int i = 1; leftPointer <= rightPointer; i += 2) {
                if (i % 10 == 1) {
                    boolean shouldFlip = false, shouldReverse = false;
                    if (sameIndex != -1) {
                        shouldFlip = result[sameIndex] != query(sameIndex);
                    } else {
                        query(0);
                    }
                    if (differentIndex != -1) {
                        if (shouldFlip) {
                            shouldReverse = result[differentIndex] == query(differentIndex);
                        } else {
                            shouldReverse = result[differentIndex] != query(differentIndex);
                        }
                    } else {
                        query(0);
                    }
                    for (int a = 0, b = bitLength - 1; a < leftPointer; ++a, --b) {
                        if (shouldFlip) {
                            result[a] ^= 1;
                            result[b] ^= 1;
                        }
                        if (shouldReverse) {
                            int temp = result[a];
                            result[a] = result[b];
                            result[b] = temp;
                        }
                    }
                    continue;
                }
                result[leftPointer] = query(leftPointer);
                result[rightPointer] = query(rightPointer);
                if (sameIndex == -1 && result[leftPointer] == result[rightPointer]) {
                    sameIndex = leftPointer;
                }
                if (differentIndex == -1 && result[leftPointer] != result[rightPointer]) {
                    differentIndex = leftPointer;
                }
                ++leftPointer;
                --rightPointer;
            }

            for (int i = 0; i < bitLength; ++i) {
                outputWriter.print(result[i]);
            }
            outputWriter.print('\n');
            outputWriter.flush();
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