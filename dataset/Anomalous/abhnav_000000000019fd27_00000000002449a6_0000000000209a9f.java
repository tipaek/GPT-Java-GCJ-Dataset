import java.util.Scanner;

public class CodeJam {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int count = 1; count <= testCases; count++) {
            String inputString = scanner.next();
            System.out.println("Case #" + count + ": " + generateNestingString(inputString));
        }
    }

    public static String generateNestingString(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(i) - '0';
            if (i == 0) {
                result.append("(".repeat(digit));
                currentDepth = digit;
            } else {
                int previousDigit = input.charAt(i - 1) - '0';
                if (digit > previousDigit) {
                    result.append("(".repeat(digit - previousDigit));
                } else if (digit < previousDigit) {
                    result.append(")".repeat(previousDigit - digit));
                }
                currentDepth = digit;
            }
            result.append(digit);
        }

        result.append(")".repeat(currentDepth));

        return result.toString();
    }
}