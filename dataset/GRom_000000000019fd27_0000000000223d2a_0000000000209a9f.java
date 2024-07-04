import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private Scanner scanner;
    private PrintStream printStream;

    public static void main(String[] args) {
        new Solution().execute(System.in, System.out);
    }

    Solution() {
        // No-op.
    }

    void execute(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        printStream = out;

        int cases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cases; i++) {
            String digits = scanner.nextLine();
            printStream.println(String.format("Case #%d: %s", i + 1, solve(digits)));
        }
    }

    String solve(String digits) {
        if (digits == null || digits.length() == 0) {
            return "";
        }

        int[][] segments = findSegments(digits);
        DigitsWithParentheses digitsWithParentheses = new DigitsWithParentheses(digits);

        for (int i = 1; i < segments.length; i++) {
            for (int j = 0; j < segments[i].length; j++) {
                int len = segments[i][j];

                if (len > 0) {
                    digitsWithParentheses.addParentheses(j, len);
                }
            }
        }

        return digitsWithParentheses.toString();
    }

    private int[][] findSegments(String digits) {
        int[][] segments = new int[10][digits.length()];
        int[] startIndexes = new int[10];
        Arrays.fill(startIndexes, -1);

        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';

            for (int j = 0; j <= digit; j++) {
                if (startIndexes[j] == -1) {
                    segments[j][i] = 1;
                    startIndexes[j] = i;
                } else {
                    segments[j][startIndexes[j]]++;
                }
            }

            for (int j = digit + 1; j < 10; j++) {
                startIndexes[j] = -1;
            }
        }

        //printSegments(segments);

        return segments;
    }

    private void printSegments(int[][] segments) {
        System.out.println("Segments:");
        for (int i = 0; i < segments.length; i++) {
            System.out.println(Arrays.toString(segments[i]));
        }
    }

    private static class DigitsWithParentheses {
        private final String digits;
        private final int[] before;
        private final int[] after;

        private DigitsWithParentheses(String digits) {
            this.digits = digits;

            before = new int[digits.length()];
            after = new int[digits.length()];
        }

        private void addParentheses(int index, int len) {
            //System.out.println(String.format("addParentheses(%d, %d)", index, len));
            before[index]++;
            after[index + len - 1]++;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < digits.length(); i++) {
                append(sb, '(', before[i]);
                sb.append(digits.charAt(i));
                append(sb, ')', after[i]);
            }

            return sb.toString();
        }

        private void append(StringBuilder sb, char c, int count) {
            if (count > 0) {
                for (int i = 0; i < count; i++) {
                    sb.append(c);
                }
            }
        }
    }
}