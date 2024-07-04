import java.util.Scanner;

public class Solution {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after the integer input

        StringBuilder result = new StringBuilder();
        for (int testCaseCounter = 1; testCaseCounter <= numTestCases; testCaseCounter++) {
            String inputLine = scanner.nextLine();
            int[] s = new int[inputLine.length()];
            for (int i = 0; i < inputLine.length(); i++) {
                s[i] = Character.getNumericValue(inputLine.charAt(i));
            }
            result.append(validateParenthesis(s, testCaseCounter)).append("\n");
        }
        System.out.print(result.toString());
    }

    public static String validateParenthesis(int[] nums, int testCaseNum) {
        StringBuilder result = new StringBuilder();
        int openParentheses = 0;

        for (int num : nums) {
            while (openParentheses < num) {
                result.append("(");
                openParentheses++;
            }
            while (openParentheses > num) {
                result.append(")");
                openParentheses--;
            }
            result.append(num);
        }
        while (openParentheses > 0) {
            result.append(")");
            openParentheses--;
        }

        return "Case #" + testCaseNum + ": " + result.toString();
    }
}