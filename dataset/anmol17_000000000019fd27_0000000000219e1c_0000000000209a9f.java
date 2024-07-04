import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for(int i = 0; i < t; i++) {
            solution.processCase(i + 1, in);
        }
    }

    private void processCase(int t, Scanner in) {
        String input = in.nextLine();
        System.out.println("Case #" + t + ": " + calculateResult(input));
    }

    private String calculateResult(String input) {
        StringBuilder result = new StringBuilder();
        int openParenthesis = 0;
        for(int i = 0; i < input.length(); i++) {
            int number = input.charAt(i) - 48;
            while(openParenthesis < number) {
                result.append('(');
                openParenthesis++;
            }
            while(openParenthesis > number) {
                result.append(')');
                openParenthesis--;
            }
            result.append(number);
        }
        while(openParenthesis > 0) {
            result.append(')');
            openParenthesis--;
        }
        return result.toString();
    }
}