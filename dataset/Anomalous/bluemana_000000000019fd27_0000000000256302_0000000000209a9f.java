import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            process(reader, writer);
        }
    }

    private static void process(BufferedReader reader, BufferedWriter writer) throws Exception {
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCases; i++) {
            handleTestCase(i, reader, writer);
        }
    }

    private static void handleTestCase(int caseNumber, BufferedReader reader, BufferedWriter writer) throws Exception {
        String input = reader.readLine();
        String formattedString = formatStringWithParentheses(input);
        String result = optimizeString(formattedString);
        writer.write(String.format("Case #%d: %s\n", caseNumber + 1, result));
        writer.flush();
    }

    private static String formatStringWithParentheses(String input) {
        StringBuilder builder = new StringBuilder();
        for (char ch : input.toCharArray()) {
            int digit = Character.digit(ch, 10);
            builder.append("(".repeat(digit)).append(digit).append(")".repeat(digit));
        }
        return builder.toString();
    }

    private static String optimizeString(String formattedString) {
        StringBuilder builder = new StringBuilder(formattedString);
        int index;
        while ((index = builder.indexOf(")(")) != -1) {
            builder.delete(index, index + 2);
        }
        return builder.toString();
    }
}