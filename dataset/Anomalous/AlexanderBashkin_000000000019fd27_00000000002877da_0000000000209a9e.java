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
        int bitCount = Integer.parseInt(tokenizer.nextToken());

        for (int test = 0; test < testCases; test++) {
            for (int i = 0; i < 40; i++) {
                System.out.println(1);
                readInput(reader);
            }

            boolean[] bits = new boolean[bitCount];
            for (int i = 1; i <= bitCount; i++) {
                System.out.println(i);
                String input = readInput(reader);
                bits[i - 1] = "1".equals(input);
            }

            for (boolean bit : bits) {
                System.out.print(bit ? '1' : '0');
            }
            System.out.println();
            readInput(reader);
        }
    }

    private String readInput(BufferedReader reader) throws IOException {
        String input = reader.readLine();
        if ("N".equals(input)) {
            System.exit(0);
        }
        return input;
    }
}