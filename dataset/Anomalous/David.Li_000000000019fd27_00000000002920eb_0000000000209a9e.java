import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int t = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int test = 0; test < t; test++) {
            int[] bits = new int[b + 1];
            int r = -1, c = -1;
            int b1 = 1, b2 = 1;
            int half = (b + 1) / 2;
            int q = 1;
            int even = 0;

            while (b2 <= b) {
                if (q > 1 && q % 10 == 1) {
                    handleSpecialCase(reader, bits, r, c, b1, q);
                } else {
                    if (even == 0) {
                        int i = b1;
                        System.out.println(i);
                        System.out.flush();
                        bits[i] = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
                        q++;
                        even = 1;
                        b2++;
                    } else {
                        int i = b1;
                        int j = b - i + 1;
                        System.out.println(j);
                        System.out.flush();
                        bits[j] = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
                        q++;

                        if (r == -1 && bits[i] != bits[j]) r = i;
                        if (c == -1 && bits[i] == bits[j]) c = i;
                        even = 0;
                        b1++;
                        b2++;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= b; i++) result.append(bits[i]);
            System.out.println(result);
            System.out.flush();

            if (reader.readLine().charAt(0) != 'Y') break;
        }
    }

    private static void handleSpecialCase(BufferedReader reader, int[] bits, int r, int c, int b1, int q) throws IOException {
        if (r == -1 && c == -1) {
            handleNoMatch(reader, bits, b1, q);
        } else if (r == -1) {
            handleSingleMatch(reader, bits, c, b1, q);
        } else if (c == -1) {
            handleSingleMatch(reader, bits, r, b1, q);
        } else {
            handleDoubleMatch(reader, bits, r, c, b1, q);
        }
    }

    private static void handleNoMatch(BufferedReader reader, int[] bits, int b1, int q) throws IOException {
        System.out.println(1);
        System.out.flush();
        int temp = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
        q++;
        if (temp != bits[1]) {
            invertBits(bits, b1);
        }
    }

    private static void handleSingleMatch(BufferedReader reader, int[] bits, int index, int b1, int q) throws IOException {
        System.out.println(index);
        System.out.flush();
        int current = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
        q++;
        if (current != bits[index]) {
            invertBits(bits, b1);
        }
    }

    private static void handleDoubleMatch(BufferedReader reader, int[] bits, int r, int c, int b1, int q) throws IOException {
        System.out.println(r);
        System.out.flush();
        int current1 = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
        q++;
        System.out.println(c);
        System.out.flush();
        int current2 = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
        q++;

        if (current2 != bits[c] && current1 != (1 - bits[r])) {
            reverseAndInvertBits(bits, b1);
        } else if (current2 != bits[c] && current1 == (1 - bits[r])) {
            invertBits(bits, b1);
        } else if (current2 == bits[c] && current1 != bits[r]) {
            reverseBits(bits, b1);
        }
    }

    private static void invertBits(int[] bits, int b1) {
        for (int i = 1; i <= b1; i++) {
            bits[i] = 1 - bits[i];
            bits[bits.length - i] = 1 - bits[bits.length - i];
        }
    }

    private static void reverseBits(int[] bits, int b1) {
        for (int i = 1; i <= b1; i++) {
            int temp = bits[i];
            bits[i] = bits[bits.length - i];
            bits[bits.length - i] = temp;
        }
    }

    private static void reverseAndInvertBits(int[] bits, int b1) {
        for (int i = 1; i <= b1; i++) {
            int temp = bits[i];
            bits[i] = 1 - bits[bits.length - i];
            bits[bits.length - i] = 1 - temp;
        }
    }
}