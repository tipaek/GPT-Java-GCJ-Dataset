import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        System.out.println(numberOfCases);
        scanner.nextLine();  // Consume the newline

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            String inputString = scanner.nextLine();
            StringBuilder transformedString = new StringBuilder();

            System.out.println(inputString);

            int index = 0;
            while (index < inputString.length()) {
                if (Character.getNumericValue(inputString.charAt(index)) == 1) {
                    transformedString.append("(");
                    while (index < inputString.length() && Character.getNumericValue(inputString.charAt(index)) == 1) {
                        transformedString.append("1");
                        index++;
                    }
                    transformedString.append(")");
                } else if (Character.getNumericValue(inputString.charAt(index)) == 0) {
                    transformedString.append("0");
                    index++;
                }
            }

            String resultString = transformedString.toString();
            System.out.println("Case #" + (caseIndex + 1) + ": " + resultString);
        }
    }
}