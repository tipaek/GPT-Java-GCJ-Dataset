import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int t = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());

        for (int test = 0; test < t; test++) {
            int[] bits = new int[b + 1];
            int r = -1, c = -1;
            int b1 = 1, b2 = 1;
            int half = (b + 1) / 2;
            int q = 1;
            int even = 0;

            while (b2 <= b) {
                if (q > 1 && q % 10 == 1) {
                    handleSpecialQuery(reader, bits, r, c, b1, b, q);
                } else {
                    handleRegularQuery(reader, bits, b1, b, q, even);
                }
            }

            printResult(bits, b);
        }
    }

    private static void handleSpecialQuery(BufferedReader reader, int[] bits, int r, int c, int b1, int b, int q) throws IOException {
        StringTokenizer tokenizer;
        if (r == -1 && c == -1) {
            System.out.println(1);
            tokenizer = new StringTokenizer(reader.readLine());
            int temp = Integer.parseInt(tokenizer.nextToken());
            System.out.flush();
            q++;
            if (temp != bits[1]) {
                flipBits(bits, b1, b);
            }
        } else if (r == -1) {
            System.out.println(c);
            tokenizer = new StringTokenizer(reader.readLine());
            int current = Integer.parseInt(tokenizer.nextToken());
            System.out.flush();
            q++;
            if (current != bits[c]) {
                flipBits(bits, b1, b);
            }
        } else if (c == -1) {
            System.out.println(r);
            tokenizer = new StringTokenizer(reader.readLine());
            int current = Integer.parseInt(tokenizer.nextToken());
            System.out.flush();
            q++;
            if (current != bits[r]) {
                flipBits(bits, b1, b);
            }
        } else {
            System.out.println(r);
            tokenizer = new StringTokenizer(reader.readLine());
            int current1 = Integer.parseInt(tokenizer.nextToken());
            System.out.flush();
            q++;
            System.out.println(c);
            tokenizer = new StringTokenizer(reader.readLine());
            int current2 = Integer.parseInt(tokenizer.nextToken());
            System.out.flush();
            q++;
            adjustBits(bits, r, c, current1, current2, b1, b);
        }
    }

    private static void handleRegularQuery(BufferedReader reader, int[] bits, int b1, int b, int q, int even) throws IOException {
        StringTokenizer tokenizer;
        if (even == 0) {
            int i = b1;
            System.out.println(i);
            tokenizer = new StringTokenizer(reader.readLine());
            bits[i] = Integer.parseInt(tokenizer.nextToken());
            System.out.flush();
            q++;
            even = 1;
        } else {
            int i = b1;
            int j = b - i + 1;
            System.out.println(j);
            tokenizer = new StringTokenizer(reader.readLine());
            bits[j] = Integer.parseInt(tokenizer.nextToken());
            System.out.flush();
            q++;

            if (bits[i] != bits[j]) {
                r = i;
            } else {
                c = i;
            }
            even = 0;
            b1++;
        }
    }

    private static void flipBits(int[] bits, int b1, int b) {
        for (int i = 1; i <= b1; i++) {
            bits[i] = 1 - bits[i];
            bits[b + 1 - i] = 1 - bits[b + 1 - i];
        }
    }

    private static void adjustBits(int[] bits, int r, int c, int current1, int current2, int b1, int b) {
        if (current2 != bits[c] && current1 != (1 - bits[r])) {
            for (int i = 1; i <= b1; i++) {
                int temp = bits[i];
                bits[i] = 1 - bits[b + 1 - i];
                bits[b + 1 - i] = 1 - temp;
            }
        } else if (current2 != bits[c] && current1 == (1 - bits[r])) {
            flipBits(bits, b1, b);
        } else if (current2 == bits[c] && current1 != bits[r]) {
            for (int i = 1; i <= b1; i++) {
                int temp = bits[i];
                bits[i] = bits[b + 1 - i];
                bits[b + 1 - i] = temp;
            }
        }
    }

    private static void printResult(int[] bits, int b) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= b; i++) {
            result.append(bits[i]);
        }
        System.out.println(result.toString());
    }
}