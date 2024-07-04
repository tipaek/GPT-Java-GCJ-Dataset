import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Solution {
    private static final StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        configureTokenizerForNumbersAndText();
        int testCases = readNextIntFromString();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = readNextString();
            System.out.println(formatOutput(caseNumber, addBracesToDigits(inputString)));
        }
    }

    private static void configureTokenizerForNumbersAndText() {
        tokenizer.resetSyntax();
        tokenizer.wordChars('a', 'z');
        tokenizer.wordChars('A', 'Z');
        tokenizer.wordChars(128 + 32, 255);
        tokenizer.whitespaceChars(0, ' ');
        tokenizer.commentChar('/');
        tokenizer.quoteChar('"');
        tokenizer.quoteChar('\'');
        tokenizer.wordChars('0', '9');
    }

    private static int readNextInt() throws IOException {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

    private static int readNextIntFromString() throws IOException {
        tokenizer.nextToken();
        return Integer.parseInt(tokenizer.sval);
    }

    private static String readNextString() throws IOException {
        tokenizer.nextToken();
        return tokenizer.sval;
    }

    private static String addBracesToDigits(String input) {
        StringBuilder resultBuilder = new StringBuilder();
        int openBracesCount = 0;

        for (char digitChar : input.toCharArray()) {
            int currentDigit = digitChar - '0';
            while (openBracesCount < currentDigit) {
                resultBuilder.append("(");
                openBracesCount++;
            }
            while (openBracesCount > currentDigit) {
                resultBuilder.append(")");
                openBracesCount--;
            }
            resultBuilder.append(currentDigit);
        }
        while (openBracesCount > 0) {
            resultBuilder.append(")");
            openBracesCount--;
        }
        return resultBuilder.toString();
    }

    private static String formatOutput(int caseNumber, String formattedString) {
        return String.format("Case #%d: %s", caseNumber, formattedString);
    }
}