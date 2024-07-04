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
        int numberOfTests = Integer.parseInt(tokenizer.nextToken());
        int bitLength = Integer.parseInt(tokenizer.nextToken());

        for (int test = 0; test < numberOfTests; test++) {
            for (int i = 0; i < 40; i++) {
                System.out.println(1);
                readResponse(reader);
            }

            boolean[] bitArray = new boolean[bitLength];

            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                String response = readResponse(reader);
                bitArray[i] = "1".equals(response);
            }

            if (bitLength > 10) {
                for (int i = 0; i < 30; i++) {
                    System.out.println(1);
                    readResponse(reader);
                }
                for (int i = 10; i < bitLength; i++) {
                    System.out.println(i + 1);
                    String response = readResponse(reader);
                    bitArray[i] = "1".equals(response);
                }
            }

            for (boolean bit : bitArray) {
                System.out.print(bit ? '1' : '0');
            }
            System.out.println();
            readResponse(reader);
        }
    }

    private String readResponse(BufferedReader reader) throws IOException {
        String response = reader.readLine();
        if ("N".equals(response)) {
            System.exit(0);
        }
        return response;
    }
}