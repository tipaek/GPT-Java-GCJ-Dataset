import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {

    private static final int LIM = 1000000;
    private static final char OPEN_PAREN = '(';
    private static final char CLOSE_PAREN = ')';
    private static int closeCount = 0;
    private static boolean isClosed;

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(System.out)) {
            int testCases = Integer.parseInt(in.readLine());
            for (int testCase = 1; testCase <= testCases; testCase++) {
                String line = in.readLine();
                String result = processLine(line);
                out.println("Case #" + testCase + ": " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static String processLine(String line) {
        isClosed = false;
        closeCount = 0;
        StringBuilder result = new StringBuilder();
        String[] chars = line.split("");

        int firstDigit = Integer.parseInt(chars[0]);
        appendOpenParens(firstDigit, result);

        for (int i = 0; i < chars.length - 1; i++) {
            int currentDigit = Integer.parseInt(chars[i]);
            int nextDigit = Integer.parseInt(chars[i + 1]);
            appendDigitWithParens(currentDigit, nextDigit, result);
        }

        int lastDigit = Integer.parseInt(chars[chars.length - 1]);
        result.append(lastDigit);
        appendCloseParens(closeCount, result);

        return result.toString();
    }

    private static void appendOpenParens(int count, StringBuilder sb) {
        isClosed = false;
        for (int i = 0; i < count; i++) {
            sb.append(OPEN_PAREN);
        }
        closeCount += count;
    }

    private static void appendCloseParens(int count, StringBuilder sb) {
        isClosed = true;
        for (int i = 0; i < count; i++) {
            sb.append(CLOSE_PAREN);
        }
        closeCount -= count;
    }

    private static void appendDigitWithParens(int start, int end, StringBuilder sb) {
        sb.append(start);
        if (!isClosed) {
            appendParensWhenOpen(start, end, sb);
        } else {
            appendParensWhenClosed(start, end, sb);
        }
    }

    private static void appendParensWhenOpen(int start, int end, StringBuilder sb) {
        if (start < end) {
            appendOpenParens(end - start, sb);
        } else {
            appendCloseParens(start - end, sb);
        }
    }

    private static void appendParensWhenClosed(int start, int end, StringBuilder sb) {
        if (start > end) {
            appendCloseParens(start - end, sb);
        } else {
            appendOpenParens(end - start, sb);
        }
    }
}