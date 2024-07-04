import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numCases; ++caseNumber) {
            final char[] word = scanner.next().toCharArray();
            final StringBuilder parens = new StringBuilder();
            int state = 0;
            for (int i = 0; i < word.length; ++i) {
                if (word[i] == '1' && state == 0) {
                    state = 1;
                    parens.append("(1");
                } else if (word[i] == '0' && state == 1) {
                    state = 0;
                    parens.append(")0");
                } else {
                    parens.append(word[i]);
                }
            }

            if (word[word.length - 1] == '1') {
                parens.append(')');
            }

            System.out.println("Case #" + (caseNumber) + ": " + parens);
        }
    }
}