import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            result.append("Case #").append(i).append(": ").append(processInput(input));
            if (i < testCases) {
                result.append("\n");
            }
        }

        System.out.println(result);
    }

    private static String processInput(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder formattedString = new StringBuilder();
        int openParentheses = 0;

        for (char ch : input.toCharArray()) {
            if (ch == '0' && openParentheses > 0) {
                formattedString.append(')');
                openParentheses--;
            } else if (ch != '0' && openParentheses == 0) {
                formattedString.append('(');
                openParentheses++;
            }
            formattedString.append(ch);
        }

        while (openParentheses > 0) {
            formattedString.append(')');
            openParentheses--;
        }

        return formattedString.toString();
    }
}