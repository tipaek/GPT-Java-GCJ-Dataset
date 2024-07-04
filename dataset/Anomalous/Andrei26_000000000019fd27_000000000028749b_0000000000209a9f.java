import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        System.out.println(numberOfCases);
        scanner.nextLine();  

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            String inputString = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            StringBuilder modifiedString = new StringBuilder();

            modifiedString.append("0").append(inputString).append("0");

            int inputIndex = 0;
            for (int modifiedIndex = 0; modifiedIndex < modifiedString.length() - 1 && inputIndex < inputString.length(); ) {
                int difference = Character.getNumericValue(modifiedString.charAt(modifiedIndex)) - Character.getNumericValue(modifiedString.charAt(modifiedIndex + 1));

                if (difference < 0) {
                    while (difference < 0) {
                        result.append("(");
                        difference++;
                    }
                } else if (difference > 0) {
                    while (difference > 0) {
                        result.append(")");
                        difference--;
                    }
                }

                result.append(inputString.charAt(inputIndex));
                inputIndex++;
                modifiedIndex++;
            }

            int closingBracketsCount = Character.getNumericValue(inputString.charAt(inputString.length() - 1));
            for (int i = 0; i < closingBracketsCount; i++) {
                result.append(")");
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + result.toString());
        }
    }
}