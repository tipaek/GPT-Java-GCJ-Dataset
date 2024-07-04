import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int testCaseNumber = t;

        while (t-- > 0) {
            String inputLine = sc.nextLine();
            StringBuilder result = new StringBuilder();
            int initialDigit = Character.getNumericValue(inputLine.charAt(0));

            for (int i = 0; i < initialDigit; i++) {
                result.append("(");
            }

            char[] inputChars = inputLine.toCharArray();
            for (int i = 0; i < inputChars.length - 1; i++) {
                result.append(inputChars[i]);
                int difference = Character.getNumericValue(inputChars[i]) - Character.getNumericValue(inputChars[i + 1]);
                char parenthesis = difference < 0 ? '(' : ')';
                
                for (int j = 0; j < Math.abs(difference); j++) {
                    result.append(parenthesis);
                }
            }

            result.append(inputChars[inputChars.length - 1]);
            int finalDigit = Character.getNumericValue(inputChars[inputChars.length - 1]);

            for (int i = 0; i < finalDigit; i++) {
                result.append(")");
            }

            System.out.println("Case #" + (testCaseNumber - t) + ": " + result.toString());
        }
    }
}