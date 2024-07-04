import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            boolean isParenthesisOpen = false;

            for (char ch : input.toCharArray()) {
                if (ch == '1') {
                    if (!isParenthesisOpen) {
                        output.append('(');
                        isParenthesisOpen = true;
                    }
                    output.append('1');
                } else {
                    if (isParenthesisOpen) {
                        output.append(')');
                        isParenthesisOpen = false;
                    }
                    output.append('0');
                }
            }

            if (isParenthesisOpen) {
                output.append(')');
            }

            System.out.println("Case #" + (i + 1) + ": " + output.toString());
        }

        scanner.close();
    }
}