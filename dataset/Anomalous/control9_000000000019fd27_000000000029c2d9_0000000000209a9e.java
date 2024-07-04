import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Solution {
    private static final int FREQ = 10;
    private static final StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int testCases = nextInt();
        int bitLength = nextInt();
        
        for (int i = 0; i < testCases; i++) {
            solve(bitLength);
        }
    }

    private static void solve(int bitLength) throws IOException {
        int[] bits = new int[bitLength];
        Arrays.fill(bits, -1);
        int sameIndex = -1;
        int oppositeIndex = -1;
        int attempts = 0;
        int currentIndex = 0;

        while (currentIndex < bitLength / 2) {
            bits[currentIndex] = readBit(currentIndex + 1);
            bits[bitLength - 1 - currentIndex] = readBit(bitLength - currentIndex);
            attempts += 2;

            if (oppositeIndex == -1 && bits[currentIndex] != bits[bitLength - 1 - currentIndex]) {
                oppositeIndex = currentIndex;
            }
            if (sameIndex == -1 && bits[currentIndex] == bits[bitLength - 1 - currentIndex]) {
                sameIndex = currentIndex;
            }
            currentIndex++;

            if (attempts == FREQ && currentIndex <= bitLength / 2) {
                handleTransformations(bits, sameIndex, oppositeIndex);
                attempts += 2;
            }
        }

        outputResponse(bits);
    }

    private static void handleTransformations(int[] bits, int sameIndex, int oppositeIndex) throws IOException {
        boolean reverse = false;
        boolean complement = false;

        if (sameIndex != -1) {
            int readValue = readBit(sameIndex + 1);
            if (readValue != bits[sameIndex]) {
                complement = true;
            }
        } else {
            readBit(1);
        }

        if (oppositeIndex != -1) {
            int readValue = readBit(oppositeIndex + 1);
            if (readValue != bits[oppositeIndex]) {
                reverse = true;
            }
            if (complement) {
                reverse = true;
            }
        } else {
            readBit(1);
        }

        if (reverse) {
            reverseArray(bits);
        }
        if (complement) {
            complementArray(bits);
        }
    }

    private static void outputResponse(int[] bits) throws IOException {
        StringBuilder response = new StringBuilder(bits.length);
        for (int bit : bits) {
            response.append(bit);
        }
        System.out.println(response);
        System.out.flush();
        
        if ("N".equals(nextToken())) {
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

    private static int readBit(int position) throws IOException {
        System.out.println(position);
        System.out.flush();
        return nextInt();
    }

    private static int nextInt() throws IOException {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

    private static String nextToken() throws IOException {
        tokenizer.nextToken();
        return tokenizer.sval;
    }
}