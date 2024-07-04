import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int testCases = Integer.parseInt(tokenizer.nextToken());
        int bitLength = Integer.parseInt(tokenizer.nextToken());

        for (int test = 0; test < testCases; test++) {
            int[] bits = new int[bitLength + 1];
            int r = -1, c = -1;
            int b1 = 1, b2 = 1;
            int queryCount = 1;
            int even = 0;

            while (b2 <= bitLength) {
                if (queryCount > 1 && queryCount % 10 == 1) {
                    handleSpecialCase(reader, bits, bitLength, b1, r, c);
                    queryCount += 2;
                } else {
                    if (even == 0) {
                        int i = b1;
                        System.out.println(i);
                        System.out.flush();
                        bits[i] = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
                        queryCount++;
                        even = 1;
                        b2++;
                    } else {
                        int i = b1;
                        int j = bitLength - i + 1;
                        System.out.println(j);
                        System.out.flush();
                        bits[j] = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
                        queryCount++;

                        if (r == -1 && bits[i] != bits[j]) r = i;
                        if (c == -1 && bits[i] == bits[j]) c = i;

                        even = 0;
                        b1++;
                        b2++;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= bitLength; i++) result.append(bits[i]);
            System.out.println(result);
            System.out.flush();

            if (reader.readLine().charAt(0) != 'Y') test = testCases;
        }
    }

    private static void handleSpecialCase(BufferedReader reader, int[] bits, int bitLength, int b1, int r, int c) throws IOException {
        StringTokenizer tokenizer;
        int queryCount = 1;

        if (r == -1 && c == -1) {
            queryCount += 2;
            int temp = getBitFromIndex(reader, 1);
            int current = getBitFromIndex(reader, 1);
            if (current != bits[1]) {
                flipBits(bits, bitLength, b1);
            }
        } else if (r == -1) {
            queryCount += 2;
            int temp = getBitFromIndex(reader, 1);
            int current = getBitFromIndex(reader, c);
            if (current != bits[c]) {
                flipBits(bits, bitLength, b1);
            }
        } else if (c == -1) {
            queryCount += 2;
            int temp = getBitFromIndex(reader, 1);
            int current = getBitFromIndex(reader, r);
            if (current != bits[r]) {
                flipBits(bits, bitLength, b1);
            }
        } else {
            queryCount += 2;
            int current1 = getBitFromIndex(reader, r);
            int current2 = getBitFromIndex(reader, c);
            if (current2 != bits[c] && current1 != (1 - bits[r])) {
                swapAndFlipBits(bits, bitLength, b1);
            } else if (current2 != bits[c] && current1 == (1 - bits[r])) {
                flipBits(bits, bitLength, b1);
            } else if (current2 == bits[c] && current1 != bits[r]) {
                swapBits(bits, bitLength, b1);
            }
        }
    }

    private static int getBitFromIndex(BufferedReader reader, int index) throws IOException {
        System.out.println(index);
        System.out.flush();
        return Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
    }

    private static void flipBits(int[] bits, int bitLength, int b1) {
        for (int i = 1; i <= b1; i++) {
            bits[i] = 1 - bits[i];
            bits[bitLength + 1 - i] = 1 - bits[bitLength + 1 - i];
        }
    }

    private static void swapBits(int[] bits, int bitLength, int b1) {
        for (int i = 1; i <= b1; i++) {
            int temp = bits[i];
            bits[i] = bits[bitLength + 1 - i];
            bits[bitLength + 1 - i] = temp;
        }
    }

    private static void swapAndFlipBits(int[] bits, int bitLength, int b1) {
        for (int i = 1; i <= b1; i++) {
            int temp = bits[i];
            bits[i] = 1 - bits[bitLength + 1 - i];
            bits[bitLength + 1 - i] = 1 - temp;
        }
    }
}