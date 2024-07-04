import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            int testCases = scanner.nextInt();

            for (int t = 0; t < testCases; t++) {
                String input = scanner.next();
                StringBuilder result = new StringBuilder();
                int previousDigit = Character.getNumericValue(input.charAt(0));

                // Append initial opening brackets
                result.append("(".repeat(previousDigit));
                result.append(previousDigit);

                for (int i = 1; i < input.length(); i++) {
                    int currentDigit = Character.getNumericValue(input.charAt(i));

                    if (currentDigit > previousDigit) {
                        result.append("(".repeat(currentDigit - previousDigit));
                    } else if (currentDigit < previousDigit) {
                        result.append(")".repeat(previousDigit - currentDigit));
                    }

                    result.append(currentDigit);
                    previousDigit = currentDigit;
                }

                // Append remaining closing brackets
                result.append(")".repeat(previousDigit));

                System.out.println(result.toString());
            }
        }
    }
}