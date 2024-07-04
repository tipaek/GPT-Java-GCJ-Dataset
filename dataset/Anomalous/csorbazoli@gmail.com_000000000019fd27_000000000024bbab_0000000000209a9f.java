import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    private String generateOutput(String input) {
        StringBuilder result = new StringBuilder();
        AtomicInteger currentVal = new AtomicInteger(0);
        input.chars().map(c -> c - '0')
              .forEach(num -> addParentheses(result, currentVal, num));
        while (currentVal.decrementAndGet() >= 0) {
            result.append(')');
        }
        return result.toString();
    }

    private void addParentheses(StringBuilder result, AtomicInteger currentDigit, int digit) {
        while (digit > currentDigit.get()) {
            result.append('(');
            currentDigit.incrementAndGet();
        }
        while (digit < currentDigit.get()) {
            result.append(')');
            currentDigit.decrementAndGet();
        }
        result.append(digit);
    }

    private void handleTestCase(int caseNumber, Scanner scanner, PrintWriter writer) {
        String input = scanner.next();
        writer.printf("Case #%d: %s%n", caseNumber, generateOutput(input));
    }

    private void execute(InputStream inputStream, OutputStream outputStream) {
        try (Scanner scanner = new Scanner(inputStream);
             PrintWriter writer = new PrintWriter(outputStream)) {
            int testCases = scanner.nextInt();
            for (int i = 0; i < testCases; i++) {
                handleTestCase(i + 1, scanner, writer);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().execute(System.in, System.out);
    }
}