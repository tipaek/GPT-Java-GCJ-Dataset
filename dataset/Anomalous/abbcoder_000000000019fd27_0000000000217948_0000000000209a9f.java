import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NestingDepth {

    public static void main(String[] args) {
        List<int[]> cases = readCases();
        processCases(cases);
    }

    private static void processCases(List<int[]> cases) {
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

    private static void appendCharacters(StringBuilder sb, char ch, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
    }

    private static List<int[]> readCases() {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        List<int[]> cases = new ArrayList<>(numberOfCases);

        for (int i = 0; i < numberOfCases; i++) {
            String line = scanner.nextLine();
            int[] digits = line.chars().map(Character::getNumericValue).toArray();
            cases.add(digits);
        }

        scanner.close();
        return cases;
    }
}