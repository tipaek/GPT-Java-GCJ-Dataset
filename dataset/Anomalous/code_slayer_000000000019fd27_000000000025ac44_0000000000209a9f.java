import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            char previousChar = input.charAt(0);
            char closingBracket = '{';

            if (previousChar == '0') {
                result.append(previousChar);
            } else {
                result.append('(').append(previousChar);
                closingBracket = ')';
            }

            for (int i = 1; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                if (currentChar == previousChar) {
                    result.append(currentChar);
                } else {
                    result.append(closingBracket).append(currentChar);
                    previousChar = currentChar;
                    closingBracket = (closingBracket == ')') ? '(' : ')';
                }
            }

            if (previousChar == '1') {
                result.append(')');
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }

        scanner.close();
    }
}