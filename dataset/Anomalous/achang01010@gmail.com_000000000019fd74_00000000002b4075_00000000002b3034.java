import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int numberOfLines = scanner.nextInt();
            String[] conditions = new String[numberOfLines];

            for (int lineIndex = 0; lineIndex < numberOfLines; lineIndex++) {
                conditions[lineIndex] = scanner.next();
            }

            int maxLengthIndex = 0;
            int maxLength = conditions[0].length();
            for (int lineIndex = 1; lineIndex < numberOfLines; lineIndex++) {
                if (conditions[lineIndex].length() > maxLength) {
                    maxLengthIndex = lineIndex;
                    maxLength = conditions[lineIndex].length();
                }
            }

            boolean isValid = true;
            String referenceSubstring = conditions[maxLengthIndex].substring(1);
            for (String condition : conditions) {
                if (!referenceSubstring.contains(condition.substring(1))) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("Case #" + (caseIndex + 1) + ": " + referenceSubstring);
            } else {
                System.out.println("Case #" + (caseIndex + 1) + ": *");
            }
        }

        scanner.close();
    }
}