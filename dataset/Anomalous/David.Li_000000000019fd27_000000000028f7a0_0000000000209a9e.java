import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int t = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int test = 0; test < t; test++) {
            int[] bits = new int[b + 1];
            int r = -1, c = -1;
            int leftIndex = 1, rightIndex = 1;
            int half = (b + 1) / 2;
            int queryCount = 1;
            int even = 0;

            while (rightIndex <= b) {
                if (queryCount > 1 && queryCount % 10 == 1) {
                    if (r == -1 && c == -1) {
                        handleQuery(reader, bits, 1, queryCount);
                    } else if (r == -1) {
                        handleQuery(reader, bits, c, queryCount);
                    } else if (c == -1) {
                        handleQuery(reader, bits, r, queryCount);
                    } else {
                        handleDoubleQuery(reader, bits, r, c, queryCount);
                    }
                } else {
                    if (even == 0) {
                        handleSingleRead(reader, bits, leftIndex, queryCount);
                        even = 1;
                        rightIndex++;
                    } else {
                        int j = b - leftIndex + 1;
                        handleSingleRead(reader, bits, j, queryCount);

                        if (r == -1 && bits[leftIndex] != bits[j]) {
                            r = leftIndex;
                        }
                        if (c == -1 && bits[leftIndex] == bits[j]) {
                            c = leftIndex;
                        }
                        even = 0;
                        leftIndex++;
                        rightIndex++;
                    }
                }
            }
            printResult(bits, b);
        }
    }

    private static void handleQuery(BufferedReader reader, int[] bits, int index, int queryCount) throws IOException {
        System.out.println(index);
        System.out.flush();
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int response = Integer.parseInt(st.nextToken());
        queryCount++;
        if (response != bits[index]) {
            invertBits(bits);
        }
    }

    private static void handleDoubleQuery(BufferedReader reader, int[] bits, int r, int c, int queryCount) throws IOException {
        System.out.println(r);
        System.out.flush();
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int response1 = Integer.parseInt(st.nextToken());
        queryCount++;

        System.out.println(c);
        System.out.flush();
        st = new StringTokenizer(reader.readLine());
        int response2 = Integer.parseInt(st.nextToken());
        queryCount++;

        if (response2 != bits[c] && response1 != (1 - bits[r])) {
            swapAndInvertBits(bits);
        } else if (response2 != bits[c] && response1 == (1 - bits[r])) {
            invertBits(bits);
        } else if (response2 == bits[c] && response1 != bits[r]) {
            swapBits(bits);
        }
    }

    private static void handleSingleRead(BufferedReader reader, int[] bits, int index, int queryCount) throws IOException {
        System.out.println(index);
        System.out.flush();
        StringTokenizer st = new StringTokenizer(reader.readLine());
        bits[index] = Integer.parseInt(st.nextToken());
        queryCount++;
    }

    private static void invertBits(int[] bits) {
        for (int i = 1; i <= bits.length / 2; i++) {
            bits[i] = 1 - bits[i];
            bits[bits.length - i] = 1 - bits[bits.length - i];
        }
    }

    private static void swapAndInvertBits(int[] bits) {
        for (int i = 1; i <= bits.length / 2; i++) {
            int temp = bits[i];
            bits[i] = 1 - bits[bits.length - i];
            bits[bits.length - i] = 1 - temp;
        }
    }

    private static void swapBits(int[] bits) {
        for (int i = 1; i <= bits.length / 2; i++) {
            int temp = bits[i];
            bits[i] = bits[bits.length - i];
            bits[bits.length - i] = temp;
        }
    }

    private static void printResult(int[] bits, int b) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= b; i++) {
            result.append(bits[i]);
        }
        System.out.println(result.toString());
        System.out.flush();
    }
}