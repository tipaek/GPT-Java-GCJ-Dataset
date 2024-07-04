import java.util.Scanner;

public class Solution {

    private void printAnswer(int caseNumber, String answer) {
        System.out.println("Case #" + caseNumber + ": " + answer);
    }

    private String findAnswer(String input) {
        StringBuilder result = new StringBuilder();
        int currentIndex = 0;
        int openParentheses = 0;

        while (currentIndex <= input.length()) {
            char currentChar = (currentIndex < input.length() ? input.charAt(currentIndex) : '0');
            int digit = currentChar - '0';

            while (openParentheses > digit) {
                result.append(")");
                openParentheses--;
            }

            while (openParentheses < digit) {
                result.append("(");
                openParentheses++;
            }

            if (currentIndex == input.length()) break;

            while (currentIndex < input.length() && input.charAt(currentIndex) == currentChar) {
                result.append(input.charAt(currentIndex));
                currentIndex++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        Solution solution = new Solution();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            String answer = solution.findAnswer(input);
            solution.printAnswer(i, answer);
        }
    }
}