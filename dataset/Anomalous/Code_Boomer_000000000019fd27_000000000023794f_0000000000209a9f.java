import java.util.Scanner;

public class Solution {

    public static String addParentheses(String input) {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            int currentValue = Character.getNumericValue(input.charAt(i));
            temp.append(currentValue);

            while (i + 1 < input.length() && Character.getNumericValue(input.charAt(i + 1)) == currentValue) {
                temp.append(input.charAt(++i));
            }

            result.append("(".repeat(currentValue))
                  .append(temp)
                  .append(")".repeat(currentValue));

            temp.setLength(0); // Clear the temporary StringBuilder
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            String output = addParentheses(input);
            System.out.println("Case #" + (i + 1) + ": " + output);
        }
    }
}