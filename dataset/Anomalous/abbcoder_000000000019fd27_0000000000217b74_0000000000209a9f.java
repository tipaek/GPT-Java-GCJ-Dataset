import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        List<int[]> cases = readInputCases();

        for (int caseIndex = 0; caseIndex < cases.size(); caseIndex++) {
            int[] digits = cases.get(caseIndex);
            StringBuilder result = new StringBuilder();
            int previousDigit = digits[0];

            appendCharacters(result, '(', previousDigit);
            result.append(previousDigit);

            for (int i = 1; i < digits.length; i++) {
                int currentDigit = digits[i];
                if (currentDigit > previousDigit) {
                    appendCharacters(result, '(', currentDigit - previousDigit);
                } else if (currentDigit < previousDigit) {
                    appendCharacters(result, ')', previousDigit - currentDigit);
                }
                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            appendCharacters(result, ')', previousDigit);

            System.out.printf("Case #%d: %s%n", caseIndex + 1, result.toString());
        }
    }

    private static void appendCharacters(StringBuilder sb, char character, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
    }

    private static List<int[]> readInputCases() {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        List<int[]> cases = new ArrayList<>(numberOfCases);

        for (int i = 0; i < numberOfCases; i++) {
            String line = scanner.nextLine();
            int[] digits = new int[line.length()];
            for (int j = 0; j < line.length(); j++) {
                digits[j] = Character.getNumericValue(line.charAt(j));
            }
            cases.add(digits);
        }

        scanner.close();
        return cases;
    }
}