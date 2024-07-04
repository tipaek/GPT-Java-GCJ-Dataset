import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
                String input = scanner.next();
                StringBuilder result = new StringBuilder();
                int openBrackets = 0;

                for (char digitChar : input.toCharArray()) {
                    int digit = Character.getNumericValue(digitChar);
                    while (openBrackets < digit) {
                        result.append('(');
                        openBrackets++;
                    }
                    while (openBrackets > digit) {
                        result.append(')');
                        openBrackets--;
                    }
                    result.append(digit);
                }

                while (openBrackets > 0) {
                    result.append(')');
                    openBrackets--;
                }

                System.out.println("Case #" + caseIndex + ": " + result);
            }
        }
    }
}