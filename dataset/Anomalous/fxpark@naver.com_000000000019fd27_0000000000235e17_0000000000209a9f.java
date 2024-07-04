import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution implements Runnable {
    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            process();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedReader reader;
    private PrintWriter writer;
    private StringTokenizer tokenizer = null;

    private String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private void process() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(nextToken());
        for (int i = 0; i < testCases; ++i) {
            String result = handleCase();
            writer.println(String.format("Case #%d: %s", i + 1, result));
        }
        reader.close();
        writer.close();
    }

    private String handleCase() throws IOException {
        String number = nextToken();
        int length = number.length();
        int currentDepth = 0;
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char digit = number.charAt(i);
            int value = digit - '0';

            while (currentDepth < value) {
                resultBuilder.append("(");
                currentDepth++;
            }

            while (currentDepth > value) {
                resultBuilder.append(")");
                currentDepth--;
            }

            resultBuilder.append(digit);
        }

        while (currentDepth > 0) {
            resultBuilder.append(")");
            currentDepth--;
        }

        return resultBuilder.toString();
    }
}