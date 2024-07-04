import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Solution {
    private static final int FREQ = 10;
    private static final StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int testCases = readInt();
        int bitLength = readInt();
        for (int i = 0; i < testCases; i++) {
            solve(bitLength);
        }
    }

    private static void solve(int bitLength) throws IOException {
        int[] bits = new int[bitLength];
        Arrays.fill(bits, -1);
        int sameIndex = -1, oppositeIndex = -1, attempts = 0, currentIndex = 0;

        while (currentIndex < bitLength / 2) {
            bits[currentIndex] = queryBit(currentIndex + 1);
            bits[bitLength - 1 - currentIndex] = queryBit(bitLength - currentIndex);
            attempts += 2;

            if (bits[currentIndex] == bits[bitLength - 1 - currentIndex] && sameIndex == -1) {
                sameIndex = currentIndex;
            }
            if (bits[currentIndex] != bits[bitLength - 1 - currentIndex] && oppositeIndex == -1) {
                oppositeIndex = currentIndex;
            }
            currentIndex++;

            if (attempts == FREQ && currentIndex < bitLength / 2) {
                boolean shouldReverse = false, shouldComplement = false;

                if (sameIndex != -1) {
                    if (queryBit(sameIndex + 1) != bits[sameIndex]) {
                        shouldComplement = true;
                    }
                } else {
                    queryBit(1);
                }

                if (oppositeIndex != -1) {
                    if (queryBit(oppositeIndex + 1) != bits[oppositeIndex] && !shouldComplement) {
                        shouldReverse = true;
                    }
                } else {
                    queryBit(1);
                }

                if (shouldReverse) {
                    reverseArray(bits);
                }
                if (shouldComplement) {
                    complementArray(bits);
                }
                attempts += 2;
            }
        }
        respond(bits);
    }

    private static void respond(int[] bits) throws IOException {
        StringBuilder response = new StringBuilder(bits.length);
        for (int bit : bits) {
            response.append((char) ('0' + bit));
        }
        System.out.println(response);
        System.out.flush();
        if ("N".equals(readString())) {
            System.exit(0);
        }
    }

    private static void complementArray(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = 1 - bits[i];
        }
    }

    private static void reverseArray(int[] bits) {
        int length = bits.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = bits[i];
            bits[i] = bits[length - 1 - i];
            bits[length - 1 - i] = temp;
        }
    }

    private static int queryBit(int position) throws IOException {
        System.out.println(position);
        System.out.flush();
        return readInt();
    }

    private static int readInt() throws IOException {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

    private static String readString() throws IOException {
        tokenizer.nextToken();
        return tokenizer.sval;
    }
}