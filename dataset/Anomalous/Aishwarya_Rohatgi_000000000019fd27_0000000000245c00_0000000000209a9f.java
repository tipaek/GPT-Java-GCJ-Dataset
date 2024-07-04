import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            input += "0";
            Stack<Character> stack = new Stack<>();
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < input.length(); j++) {
                char currentChar = input.charAt(j);

                if (currentChar == '0') {
                    StringBuilder temp = new StringBuilder();
                    while (!stack.isEmpty()) {
                        temp.append(stack.pop());
                    }
                    if (temp.length() > 0) {
                        result.append("(").append(temp).append(")");
                    }
                    result.append(currentChar);
                } else {
                    stack.push(currentChar);
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result.substring(0, result.length() - 1));
        }
        scanner.close();
    }
}