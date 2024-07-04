import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int t = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());

        for (int test = 0; test < t; test++) {
            int[] bits = new int[b + 1];
            int r = -1, c = -1;
            int left = 1, right = 1;
            int half = (b + 1) / 2;
            int queryCount = 1;
            int even = 0;

            while (right <= b) {
                if (queryCount > 1 && queryCount % 10 == 1) {
                    if (r == -1 && c == -1) {
                        processQuery(reader, 1, bits);
                        queryCount++;
                        adjustBits(bits, left, right, 1);
                    } else if (r == -1 && c != -1) {
                        processQuery(reader, c, bits);
                        queryCount++;
                        adjustBits(bits, left, right, c);
                    } else if (r != -1 && c == -1) {
                        processQuery(reader, r, bits);
                        queryCount++;
                        adjustBits(bits, left, right, r);
                    } else if (r != -1 && c != -1) {
                        int current1 = processQuery(reader, r, bits);
                        queryCount++;
                        int current2 = processQuery(reader, c, bits);
                        queryCount++;
                        adjustBitsBasedOnCurrent(bits, left, right, r, c, current1, current2);
                    }
                } else {
                    if (even == 0) {
                        processQuery(reader, left, bits);
                        queryCount++;
                        even = 1;
                        right++;
                    } else {
                        int i = left;
                        int j = b - i + 1;
                        processQuery(reader, j, bits);
                        queryCount++;
                        updateIndices(bits, i, j, r, c);
                        even = 0;
                        left++;
                        right++;
                    }
                }
            }

            printResult(bits, b);
        }
    }

    private static int processQuery(BufferedReader reader, int index, int[] bits) throws IOException {
        System.out.println(index);
        System.out.flush();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        return bits[index] = Integer.parseInt(tokenizer.nextToken());
    }

    private static void adjustBits(int[] bits, int left, int right, int index) {
        if (bits[index] != bits[1]) {
            for (int i = 1; i <= left; i++) {
                bits[i] = 1 - bits[i];
                bits[right - i] = 1 - bits[right - i];
            }
        }
    }

    private static void adjustBitsBasedOnCurrent(int[] bits, int left, int right, int r, int c, int current1, int current2) {
        if ((current2 != bits[c]) && (current1 != (1 - bits[r]))) {
            for (int i = 1; i <= left; i++) {
                int temp = bits[i];
                bits[i] = 1 - bits[right - i];
                bits[right - i] = 1 - temp;
            }
        } else if ((current2 != bits[c]) && (current1 == (1 - bits[r]))) {
            for (int i = 1; i <= left; i++) {
                bits[i] = 1 - bits[i];
                bits[right - i] = 1 - bits[right - i];
            }
        } else if ((current2 == bits[c]) && (current1 != bits[r])) {
            for (int i = 1; i <= left; i++) {
                int temp = bits[i];
                bits[i] = bits[right - i];
                bits[right - i] = temp;
            }
        }
    }

    private static void updateIndices(int[] bits, int i, int j, int r, int c) {
        if (r == -1 && bits[i] != bits[j]) r = i;
        if (c == -1 && bits[i] == bits[j]) c = i;
    }

    private static void printResult(int[] bits, int b) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= b; i++) result.append(bits[i]);
        System.out.println(result);
        System.out.flush();
    }
}