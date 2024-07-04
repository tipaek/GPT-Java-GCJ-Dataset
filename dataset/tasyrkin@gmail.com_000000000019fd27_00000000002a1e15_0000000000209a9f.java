import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while (caseNumber++ < T) {
            final char[] digits = scanner.next().toCharArray();
            StringBuilder result = new StringBuilder();
            int currBrackets = 0;
            for (int i = 0; i < digits.length; i++) {
                int digit = digits[i] - '0';
                if (currBrackets < digit) {
                    int diff = digit - currBrackets;
                    for (int j = 0; j < diff; j++) {
                        result.append("(");
                    }
                    currBrackets += diff;
                } else if (currBrackets > digit) {
                    int diff = currBrackets - digit;
                    for (int j = 0; j < diff; j++) {
                        result.append(")");
                    }
                    currBrackets -= diff;
                }
                result.append(digits[i]);
            }
            if (currBrackets != 0) {
                for (int j = 0; j < currBrackets; j++) {
                    result.append(")");
                }
            }

            System.out.println(
                    String.format("Case #%d: %s", caseNumber, result.toString())
            );
        }
    }
}
