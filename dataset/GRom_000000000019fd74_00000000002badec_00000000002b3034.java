import java.io.InputStream;
import java.io.PrintStream;
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

        int cases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cases; i++) {
            solveCase(i + 1);
        }
    }

    private void solveCase(int caseNo) {
        int n = Integer.parseInt(scanner.nextLine());

        String[] patterns = new String[n];
        for (int i = 0; i < n; i++) {
            patterns[i] = scanner.nextLine();
        }

        printStream.println(String.format("Case #%d: %s",
                caseNo, findCommonString(patterns)));
    }

    String findCommonString(String[] patterns) {
        String left = findFromLeft(patterns);

        if (left == null) {
            return "*";
        }

        String right = findFromRight(patterns);

        if (right == null) {
            return "*";
        }

        return left + mergeCenters(patterns) + right;
    }

    private String mergeCenters(String[] patterns) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < patterns.length; i++) {
            int firstIndex = patterns[i].indexOf('*');
            int lastIndex = patterns[i].lastIndexOf('*');

            for (int j = firstIndex + 1; j < lastIndex; j++) {
                char c = patterns[i].charAt(j);
                if (c != '*') {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

    private String findFromLeft(String[] patterns) {
        return find(patterns, 1);
    }

    private String findFromRight(String[] patterns) {
        return find(patterns, -1);
    }

    private String find(String[] patterns, int di) {
        int[] indexes = new int[patterns.length];

        if (di == -1) {
            for (int i = 0; i < indexes.length; i++) {
                indexes[i] = patterns[i].length() - 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        int starsCount = 0;
        while (starsCount < patterns.length) {
            starsCount = 0;
            char charToAdd = '0';
            boolean hasNonStarChar = false;

            for (int i = 0; i < patterns.length; i++) {
                char c = patterns[i].charAt(indexes[i]);

                if (c == '*') {
                    starsCount++;
                } else {
                    if (hasNonStarChar) {
                        if (charToAdd == c) {
                            indexes[i] += di;
                        } else {
                            return null;
                        }
                    } else {
                        charToAdd = c;
                        hasNonStarChar = true;
                        indexes[i] += di;
                    }
                }
            }

            if (hasNonStarChar) {
                sb.append(charToAdd);
            } else {
                break;
            }
        }

        if (di == -1) {
            return sb.reverse().toString();
        }

        return sb.toString();
    }
}