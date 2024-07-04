import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        scanner.nextLine();
        
        for (int z = 1; z <= T; z++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();

            int firstNum = Character.getNumericValue(input.charAt(0));
            result.append(generateParenthesis('(', firstNum)).append(input.charAt(0));

            for (int i = 1; i < input.length(); i++) {
                int currentNum = Character.getNumericValue(input.charAt(i));
                int previousNum = Character.getNumericValue(input.charAt(i - 1));

                if (currentNum == previousNum) {
                    result.append(input.charAt(i));
                } else if (currentNum < previousNum) {
                    result.append(generateParenthesis(')', previousNum - currentNum)).append(input.charAt(i));
                } else {
                    result.append(generateParenthesis('(', currentNum - previousNum)).append(input.charAt(i));
                }
            }

            int lastNum = Character.getNumericValue(result.charAt(result.length() - 1));
            result.append(generateParenthesis(')', lastNum));

            System.out.println("Case #" + z + ": " + result.toString());
        }
    }

    static String generateParenthesis(char parenthesis, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(parenthesis);
        }
        return result.toString();
    }
}