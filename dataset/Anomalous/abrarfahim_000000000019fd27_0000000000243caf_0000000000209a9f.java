import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        for (int i = 0; i < testCases; i++) {
            String inputString = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            int firstDigit = Character.getNumericValue(inputString.charAt(0));
            for (int j = 0; j < firstDigit; j++) {
                result.append("(");
                openBrackets++;
            }
            result.append(firstDigit);

            int previousDigit = firstDigit;

            for (int j = 1; j < inputString.length(); j++) {
                int currentDigit = Character.getNumericValue(inputString.charAt(j));

                if (currentDigit < previousDigit) {
                    for (int k = 0; k < previousDigit - currentDigit; k++) {
                        result.append(")");
                        openBrackets--;
                    }
                } else if (currentDigit > previousDigit) {
                    for (int k = 0; k < currentDigit - previousDigit; k++) {
                        result.append("(");
                        openBrackets++;
                    }
                }
                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            while (openBrackets > 0) {
                result.append(")");
                openBrackets--;
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }

        scanner.close();
    }
}