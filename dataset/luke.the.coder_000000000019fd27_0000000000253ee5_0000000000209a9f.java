
import java.util.Scanner;
import java.util.function.Function;

class Jam {
    /**
     * Scanner of StdIn.
     */
    private final Scanner scanner;

    /**
     * Number of test cases.
     */
    private final int numberOfCases;

    /**
     * The function that reads one test case and returns the solution.
     */
    private final Function<Scanner, String> solution;

    public Jam(Function<Scanner, String> solution) {
        scanner = new Scanner(System.in);
        numberOfCases = scanner.nextInt();
        this.solution = solution;
    }

    public void run() {
        for (int i = 0; i < numberOfCases; i++) {
            final String answer = solution.apply(scanner);
            System.out.printf("Case #%d: %s\n", i + 1, answer);
        }
    }
}

public class Solution {
    private static void appendChars(StringBuilder sb, char ch, int count) {
        for (int i = 0; i < count; i++) sb.append(ch);
    }

    public static void main(String[] args) {
        new Jam(scanner -> {
            String s = scanner.next();
            StringBuilder sb = new StringBuilder();

            int[] digits = new int[s.length()];
            for (int i = 0; i < digits.length; i++) digits[i] = s.charAt(i) - '0';

            int openParens = 0;
            int prevDigit = 0;

            for (int i = 0; i < digits.length; i++) {
                int d = digits[i];
                if (d > prevDigit) {
                    int depth = d - prevDigit;
                    appendChars(sb, '(', depth);
                    openParens += depth;
                } else if (d < prevDigit) {
                    int depth = prevDigit - d;
                    appendChars(sb, ')', depth);
                    openParens -= depth;
                }
                sb.append(d);
                prevDigit = d;
            }

            appendChars(sb, ')', openParens);

            return sb.toString();
        }).run();
    }
}
