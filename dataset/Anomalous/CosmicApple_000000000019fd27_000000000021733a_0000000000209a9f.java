import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTests = scanner.nextInt();
        String openBrackets = "(((((((((";
        String closeBrackets = ")))))))))";

        for (int testCase = 1; testCase <= numOfTests; testCase++) {
            String rawInput = scanner.next();
            StringBuilder processed = new StringBuilder();

            for (int i = 0; i < rawInput.length(); i++) {
                int digit = Character.getNumericValue(rawInput.charAt(i));
                processed.append(openBrackets, 0, digit)
                         .append(digit)
                         .append(closeBrackets, 0, digit);
            }

            for (int i = 1; i < processed.length(); i++) {
                if (processed.charAt(i) == '(' && processed.charAt(i - 1) == ')') {
                    processed.delete(i - 1, i + 1);
                    i -= 2;
                }
            }

            System.out.println("Case #" + testCase + ": " + processed);
        }
    }
}