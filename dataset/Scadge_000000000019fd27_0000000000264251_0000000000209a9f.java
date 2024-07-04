import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numCases; ++caseNumber) {
            final char[] word = scanner.next().toCharArray();
            final StringBuilder parens = new StringBuilder();

            int currentNum = 0;
            for (char nextChar : word) {
                int nextNum = Integer.parseInt(String.valueOf(nextChar));
                int diff = nextNum - currentNum;
                if (diff > 0) {
                    for (int i = 0; i < diff; ++i) {
                        parens.append('(');
                    }
                } else if (diff < 0) {
                    for (int i = 0; i < Math.abs(diff); ++i) {
                        parens.append(')');
                    }
                }
                parens.append(nextChar);
                currentNum = nextNum;
            }

            int lastDigit = Integer.parseInt(String.valueOf(word[word.length - 1]));
            if (lastDigit != 0) {
                for (int i = 0; i < lastDigit; ++i) {
                    parens.append(')');
                }
            }

            System.out.println("Case #" + (caseNumber) + ": " + parens);
        }
    }
}