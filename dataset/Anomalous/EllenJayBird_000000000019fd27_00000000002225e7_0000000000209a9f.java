import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution implements Runnable {

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedReader reader;
    private PrintWriter writer;

    private String nextToken() throws IOException {
        return reader.readLine();
    }

    private String formatOutput(int caseNumber, String result) {
        return "Case #" + caseNumber + ": " + result;
    }

    private String calculator(int caseNumber) throws IOException {
        String input = nextToken();
        char[] characters = input.toCharArray();
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char character : characters) {
            int value = character - '0';
            int depthDifference = value - currentDepth;

            if (depthDifference > 0) {
                result.append("(".repeat(depthDifference));
            } else if (depthDifference < 0) {
                result.append(")".repeat(-depthDifference));
            }

            result.append(character);
            currentDepth = value;
        }

        result.append(")".repeat(currentDepth));
        return formatOutput(caseNumber, result.toString());
    }

    private void solve() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(nextToken());

        for (int i = 1; i <= testCases; i++) {
            writer.println(calculator(i));
        }

        reader.close();
        writer.close();
    }
}