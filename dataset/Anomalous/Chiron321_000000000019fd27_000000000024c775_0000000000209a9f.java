import java.util.Scanner;
import java.util.Stack;

public class Solution {
    private static String result;
    private static Stack<String> stack;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = 1;
        int numberOfTests = scanner.nextInt();

        while (numberOfTests-- > 0) {
            result = "";
            stack = new Stack<>();
            char[] testCase = scanner.next().toCharArray();

            for (int i = 0; i < testCase.length; i++) {
                if (testCase[i] == '1') {
                    handlePush(testCase[i]);
                }
                if (testCase[i] == '0' || i == testCase.length - 1) {
                    handlePop(testCase[i]);
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }

        scanner.close();
    }

    private static void handlePop(char character) {
        if (!stack.isEmpty()) {
            result += ")";
            stack.pop();
        }
        if (character == '0') {
            result += character;
        }
    }

    private static void handlePush(char character) {
        if (stack.isEmpty()) {
            result += "(" + character;
            stack.push("(");
        } else {
            result += character;
        }
    }
}