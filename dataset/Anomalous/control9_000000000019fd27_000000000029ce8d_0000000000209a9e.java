import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Solution {
    private static final int FREQ = 10;
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int testCases = nextInt();
        int bitLength = nextInt();
        for (int i = 1; i <= testCases; i++) {
            solve(bitLength);
        }
    }

    private static void solve(int bitLength) throws IOException {
        int samePairIndex = -1;
        int oppositePairIndex = -1;
        int readCount = 0;
        int[] bits = new int[bitLength];
        int currentIndex = 0;
        Arrays.fill(bits, -1);

        while (currentIndex < bitLength / 2) {
            bits[currentIndex] = readBit(currentIndex + 1);
            bits[bitLength - 1 - currentIndex] = readBit(bitLength - currentIndex);
            readCount += 2;

            if (oppositePairIndex == -1 && bits[currentIndex] != bits[bitLength - 1 - currentIndex]) {
                oppositePairIndex = currentIndex;
            }
            if (samePairIndex == -1 && bits[currentIndex] == bits[bitLength - 1 - currentIndex]) {
                samePairIndex = currentIndex;
            }
            currentIndex++;

            if (readCount == FREQ && currentIndex < bitLength / 2) {
                boolean reverse = false;
                boolean complement = false;

                if (samePairIndex != -1) {
                    int readValue = readBit(samePairIndex + 1);
                    if (readValue != bits[samePairIndex]) {
                        complement = true;
                    }
                } else {
                    readBit(1); // Ensure the read count is even
                }

                if (oppositePairIndex != -1) {
                    int readValue = readBit(oppositePairIndex + 1);
                    if ((readValue != bits[oppositePairIndex]) ^ complement) {
                        reverse = true;
                    }
                } else {
                    readBit(1); // Ensure the read count is even
                }

                if (reverse) {
                    reverseArray(bits);
                }
                if (complement) {
                    complementArray(bits);
                }
                readCount = 2;
            }
        }
        respond(bits);
    }

    private static void respond(int[] bits) throws IOException {
        StringBuilder result = new StringBuilder(bits.length);
        for (int bit : bits) {
            result.append((char) ('0' + bit));
        }
        System.out.println(result);
        System.out.flush();

        if ("N".equals(next())) {
            System.exit(0);
        }
    }

    private static void complementArray(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = 1 - bits[i];
        }
    }

    private static void reverseArray(int[] bits) {
        for (int i = 0; i < bits.length / 2; i++) {
            int j = bits.length - 1 - i;
            int temp = bits[i];
            bits[i] = bits[j];
            bits[j] = temp;
        }
    }

    private static int readBit(int position) throws IOException {
        System.out.println(position);
        System.out.flush();
        return nextInt();
    }

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    private static String next() throws IOException {
        in.nextToken();
        return in.sval;
    }
}