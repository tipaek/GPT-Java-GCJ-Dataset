import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String inputStr = scanner.next();
            StringBuilder outputStr = new StringBuilder();
            boolean isParenthesisOpen = false;

            for (char ch : inputStr.toCharArray()) {
                if (ch == '1') {
                    if (!isParenthesisOpen) {
                        outputStr.append("(");
                        isParenthesisOpen = true;
                    }
                    outputStr.append("1");
                } else {
                    if (isParenthesisOpen) {
                        outputStr.append(")");
                        isParenthesisOpen = false;
                    }
                    outputStr.append("0");
                }
            }

            if (isParenthesisOpen) {
                outputStr.append(")");
            }

            System.out.println(outputStr);
        }

        scanner.close();
    }
}