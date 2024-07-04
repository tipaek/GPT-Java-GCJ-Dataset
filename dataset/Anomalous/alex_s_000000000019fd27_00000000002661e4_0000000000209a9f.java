import java.util.Scanner;

public class Solution {

    private static final String OPENS = "(((((((((((";
    private static final String CLOSES = ")))))))))))";
    private static final String EMPTY = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= numberOfCases; t++) {
            System.out.print("Case #" + t + ": ");
            System.out.println(processCase(scanner.nextLine()));
        }

        scanner.close();
    }

    private static String processCase(String digits) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char digitChar : digits.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);

            if (digit > currentDepth) {
                result.append(openBrackets(digit - currentDepth));
            } else if (digit < currentDepth) {
                result.append(closeBrackets(currentDepth - digit));
            }

            result.append(digit);
            currentDepth = digit;
        }

        result.append(closeBrackets(currentDepth));
        return result.toString();
    }

    private static String openBrackets(int count) {
        return count == 0 ? EMPTY : OPENS.substring(0, count);
    }

    private static String closeBrackets(int count) {
        return count == 0 ? EMPTY : CLOSES.substring(0, count);
    }
}