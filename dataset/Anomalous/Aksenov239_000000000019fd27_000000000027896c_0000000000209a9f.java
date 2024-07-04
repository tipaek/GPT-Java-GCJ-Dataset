import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        new Solution().execute();
    }

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    private String getNextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private int getNextInt() throws IOException {
        return Integer.parseInt(getNextToken());
    }

    private void processInput() throws IOException {
        char[] inputChars = getNextToken().toCharArray();
        int currentDepth = 0;
        for (char c : inputChars) {
            int digit = c - '0';
            if (currentDepth < digit) {
                while (currentDepth < digit) {
                    writer.print("(");
                    currentDepth++;
                }
            } else {
                while (currentDepth > digit) {
                    writer.print(")");
                    currentDepth--;
                }
            }
            writer.print(c);
        }
        while (currentDepth > 0) {
            writer.print(")");
            currentDepth--;
        }
        writer.println();
    }

    public void execute() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(System.out);

            int testCases = getNextInt();
            for (int i = 0; i < testCases; i++) {
                writer.printf("Case #%d: ", i + 1);
                processInput();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}