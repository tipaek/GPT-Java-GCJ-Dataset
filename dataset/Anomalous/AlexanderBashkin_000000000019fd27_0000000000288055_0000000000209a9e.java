import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().execute();
    }

    private void execute() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int testCases = Integer.parseInt(tokenizer.nextToken());
        int bitLength = Integer.parseInt(tokenizer.nextToken());

        for (int t = 0; t < testCases; t++) {
            performInitialReads(reader);
            boolean[] bits = new boolean[bitLength];

            // Read first 10 bits
            readBits(reader, bits, 0, Math.min(10, bitLength));

            // If bit length is greater than 10, perform additional reads
            if (bitLength > 10) {
                performInitialReads(reader);
                readBits(reader, bits, 10, bitLength);
            }

            // Output the bit array
            printBits(bits);
            readResponse(reader);
        }
    }

    private void performInitialReads(BufferedReader reader) throws IOException {
        for (int i = 0; i < 40; i++) {
            System.out.println(1);
            readResponse(reader);
        }
    }

    private void readBits(BufferedReader reader, boolean[] bits, int start, int end) throws IOException {
        for (int i = start; i < end; i++) {
            System.out.println(i + 1);
            bits[i] = "1".equals(readResponse(reader));
        }
    }

    private void printBits(boolean[] bits) {
        StringBuilder result = new StringBuilder();
        for (boolean bit : bits) {
            result.append(bit ? '1' : '0');
        }
        System.out.println(result);
    }

    private String readResponse(BufferedReader reader) throws IOException {
        String response = reader.readLine();
        if ("N".equals(response)) {
            System.exit(0);
        }
        return response;
    }
}