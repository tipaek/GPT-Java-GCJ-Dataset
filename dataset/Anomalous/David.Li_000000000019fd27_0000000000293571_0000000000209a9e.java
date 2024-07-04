import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
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
                    if (r == -1 && c == -1) {
                        handleQuery(reader, bits, 1, queryCount);
                    } else if (r == -1) {
                        handleQuery(reader, bits, 1, queryCount);
                        handleQuery(reader, bits, c, queryCount);
                    } else if (c == -1) {
                        handleQuery(reader, bits, 1, queryCount);
                        handleQuery(reader, bits, r, queryCount);
                    } else {
                        handleQuery(reader, bits, r, queryCount);
                        handleQuery(reader, bits, c, queryCount);
                    }
                } else {
                    if (even == 0) {
                        int i = b1;
                        bits[i] = queryBit(reader, i, queryCount);
                        even = 1;
                        b2++;
                    } else {
                        int i = b1;
                        int j = bitLength - i + 1;
                        bits[j] = queryBit(reader, j, queryCount);

                        if (r == -1 && bits[i] != bits[j]) r = i;
                        if (c == -1 && bits[i] == bits[j]) c = i;
                        
                        even = 0;
                        b1++;
                        b2++;
                    }
                }
            }

            StringBuilder result = new StringBuilder("Case # " + test + ": ");
            for (int i = 1; i <= bitLength; i++) result.append(bits[i]);
            System.out.println(result);
            System.out.flush();

            String answer = reader.readLine();
            if (answer.charAt(0) != 'Y') break;
        }
    }

    private static void handleQuery(BufferedReader reader, int[] bits, int index, int queryCount) throws IOException {
        System.out.println(index);
        System.out.flush();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int response = Integer.parseInt(tokenizer.nextToken());
        queryCount++;
        if (response != bits[index]) {
            flipBits(bits, index);
        }
    }

    private static int queryBit(BufferedReader reader, int index, int queryCount) throws IOException {
        System.out.println(index);
        System.out.flush();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int bit = Integer.parseInt(tokenizer.nextToken());
        queryCount++;
        return bit;
    }

    private static void flipBits(int[] bits, int index) {
        for (int i = 1; i <= index; i++) {
            bits[i] = 1 - bits[i];
            bits[bits.length - i - 1] = 1 - bits[bits.length - i - 1];
        }
    }
}